package edu.galileo;

// Don't import packages as jdk.internal.org.xml.sax....
// Just use: org.xml.sax....
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


class SAXHandler extends DefaultHandler {

    List<Student> stdList;
    Student std = null;
    String content = null;

    // Overriding methods..

    @Override
    public void startDocument() throws SAXException {
        stdList = new ArrayList<>();
    }

    // Triggered when the start tag is found
    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        switch (qName) {
            // Creates a new Student object when the start tag is found
            case "student":
                std = new Student();
                std.id = attributes.getValue("id");
                std.active = attributes.getValue("active");
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        content = String.copyValueOf(ch, start, length).trim();
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        switch (qName) {
            // Add student to the list once the end tag was found
            case "student":
                stdList.add(std);
                break;
            // For all other end tags, the student has to be updated
            case "firstName":
                std.firstName = content;
                break;
            case "lastName":
                std.lastName = content;
                break;
            case "location":
                std.location = content;
                break;
        }
    }

    @Override
    public void endDocument() throws SAXException {
        // If found </student> end element tag
        for (Student std : stdList) {
            System.out.println(std);
        }
    }
}



public class SAXParser {

    public static void main(String[] args) throws Exception {

        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        javax.xml.parsers.SAXParser parser = parserFactory.newSAXParser();
        SAXHandler handler = new SAXHandler();
        // Changed the following input to avoid an Exception
        InputStream xmlInput =
                new FileInputStream("Student.xml");
        parser.parse(xmlInput, handler);

        /*
        // Printing the list of Students obtained from XML
        for(Student std : handler.stdList) {
            System.out.println(std);
        }
         */
    }
}


class Student {

    String id;
    String active;
    String firstName;
    String lastName;
    String location;

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + id + ") " + location + " Active: " + active;
    }
}