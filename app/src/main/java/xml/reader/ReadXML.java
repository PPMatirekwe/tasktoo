package xml.reader;

import java.io.File;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class ReadXML {
    public static void main(String[] args) {
        try {
            // create a new file object
            File file = new File("C:/Users/Hp/Desktop/xml-reader/app/src/main/java/xml/reader/data.xml");
            





            // create a new DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // parse the XML file into a Document object
            Document doc = dBuilder.parse(file);

            // normalize the Document object
            doc.getDocumentElement().normalize();

            // get a list of "person" elements
            NodeList nodeList = doc.getElementsByTagName("person");

            // create a scanner object to get user input
            Scanner scanner = new Scanner(System.in);

            // ask the user which fields to output
            System.out.print("Enter field names (comma-separated): ");
            String[] fields = scanner.nextLine().split(",");

            // loop through the "person" elements and print out the selected fields
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // loop through the selected fields and output their values
                    for (String field : fields) {
                        NodeList fieldNodes = element.getElementsByTagName(field.trim());
                        if (fieldNodes.getLength() > 0) {
                            String value = fieldNodes.item(0).getTextContent();
                            System.out.println(field.trim() + ": " + value);
                        } else {
                            System.out.println(field.trim() + ": Field not found.");
                        }
                    }
                    System.out.println(); // add an empty line between records
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
