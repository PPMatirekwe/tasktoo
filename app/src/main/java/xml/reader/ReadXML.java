package xml.reader;
import java.io.File;
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
            
            // loop through the "person" elements and print out the field values
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String age = element.getElementsByTagName("age").item(0).getTextContent();
                    System.out.println("Name: " + name);
                    System.out.println("Age: " + age);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
