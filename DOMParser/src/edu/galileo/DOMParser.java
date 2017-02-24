package edu.galileo;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DOMParser {

    /*
     * Tree structure:

        + ELEMENT: students
            + ELEMENT: student
                + ELEMENT: firstName
                    + TEXT: Rakesh
                + ELEMENT: lastName
                    + TEXT: Mishra
                + ELEMENT: location
                    + TEXT: Bangalore
            + ELEMENT: student
                + ELEMENT: firstName
                    + TEXT: John
                + ELEMENT: lastName
                    + TEXT: Davis
                + ELEMENT: location
                    + TEXT: Chennai
            + ELEMENT: student
                + ELEMENT: firstName
                    + TEXT: Rajesh
                + ELEMENT: lastName
                    + TEXT: Sharma
                + ELEMENT: location
                    + TEXT: Pune
     */

    public static void main(String[] args) throws Exception {

        // Get the DOM builder factory
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();

        // Get the DOM builder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Load and parse the XML document
        // "document" contains the XML information as a tree
        // Changed the following input to avoid an Exception
        InputStream xmlInput =
                new FileInputStream("Student.xml");
        Document document = builder.parse(xmlInput);

        List<Student> stdList = new ArrayList<>();

        // Iterating through the node list and extracting the data
        NodeList nodeList = document.getDocumentElement().getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {

            // We have encountered and <student> tag
            Node node = nodeList.item(i);
            // Check if the current node is an instance of element
            if (node instanceof Element) {
                Student std = new Student();
                // Check if the current node is a <student> tag
                if (node.getNodeName().equals("student")) {
                    NamedNodeMap attr = node.getAttributes();
                    // Get the student "id", "active" attributes
                    std.id = attr.getNamedItem("id").getNodeValue();
                    std.active = attr.getNamedItem("active").getNodeValue();
                }
                // Get a list of the child nodes of student element
                NodeList childNodes = node.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node cNode = childNodes.item(j);

                    // Identify the child tag of student encountered
                    if (cNode instanceof Element) {
                        // Get the last child of the current tag,
                        // the last child'll be the next node
                        String content = cNode.getLastChild().getNodeValue().trim();
                        switch (cNode.getNodeName()) {
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
                }
                stdList.add(std);
            }
        }
        // Prints the student list
        for (Student std : stdList) {
            System.out.println(std);
        }
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