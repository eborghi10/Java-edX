package edu.galileo;

/**
 * Created by emiliano on 02/03/17.
 */
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public class CountriesSAXParser {
    public static void setWorldBankData(Countries countries, String xml) {
        //Removing the first blank space
        xml = xml.substring(1,xml.length());
        SAXParserFactory parserFactor = SAXParserFactory.newInstance();
        SAXParser parser = null;
        SAXHandler handler = new SAXHandler(countries);
        try {
            parser = parserFactor.newSAXParser();
            parser.parse(new InputSource(new StringReader(xml)), handler);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {

    List<Country> countries;
    Country country = null;

    public SAXHandler(Countries countries) {
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        /*
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
        */
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        /*
        content = String.copyValueOf(ch, start, length).trim();
         */
    }
}

