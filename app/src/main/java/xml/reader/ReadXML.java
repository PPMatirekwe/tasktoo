package xml.reader;

import java.io.File;
import java.util.Scanner;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class ReadXML {
    public static void main(String[] args) {
        try {
            // create a new file object
            File file = new File("C:/Users/Hp/Desktop/xml-reader/app/src/main/java/xml/reader/data.xml");

            // create a new SAXParser object
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // create a new handler object
            DefaultHandler handler = new DefaultHandler() {
                boolean isPerson = false;

                // start element callback
                public void startElement(String uri, String localName, String qName, Attributes attributes) {
                    if (qName.equalsIgnoreCase("person")) {
                        
                        isPerson = true;
                    }
                }

                // characters callback
                public void characters(char ch[], int start, int length) {
                    if (isPerson) {
                        System.out.println(new String(ch, start, length));
                    }
                }

                // end element callback
                public void endElement(String uri, String localName, String qName) {
                    if (qName.equalsIgnoreCase("person")) {
                        System.out.println(); // add an empty line between records
                        isPerson = false;
                    }
                }
            };

            // parse the XML file using the handler object
            saxParser.parse(file, handler);

            // create a scanner object to get user input
            Scanner scanner = new Scanner(System.in);

            // ask the user which fields to output
            System.out.print("Enter field names (comma-separated): ");
            String[] fields = scanner.nextLine().split(",");

            // loop through the selected fields and output their values
            for (String field : fields) {
                System.out.println(field.trim() + ": Field not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
