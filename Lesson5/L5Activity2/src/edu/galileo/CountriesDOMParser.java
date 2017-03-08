package edu.galileo;

/**
 * Created by emiliano on 02/03/17.
 */
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.*;
import javax.xml.parsers.*;

public class CountriesDOMParser {
    public static void setLifeExpectancy(Countries countries, String xml) {

        //Removing the first blank space
        xml = xml.substring(1,xml.length());
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document document = null;
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(new InputSource(new StringReader(xml)));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Iterating through the node list and extracting the data
        NodeList nodeList = document.getDocumentElement().getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {

            // We have encountered and <student> tag
            Node node = nodeList.item(i);
            // Check if the current node is an instance of element
            if (node instanceof Element) {
                Country country = new Country();
                // Check if the current node is a <student> tag
                if (node.getNodeName().equals("country")) {
                    NamedNodeMap attr = node.getAttributes();
                    /*
                    // Get the student "id", "active" attributes
                    std.id = attr.getNamedItem("id").getNodeValue();
                    std.active = attr.getNamedItem("active").getNodeValue();
                    */
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
                        /*
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
                        */
                    }
                }
                countries.addCountry(country);
            }
        }
        // Prints the student list
        for (Country country : Countries) {
            System.out.println(country);
        }

    }
}

