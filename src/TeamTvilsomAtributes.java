package zevsTest;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

public class TeamTvilsomAtributes {
	
	public static void main(String[] args) throws Exception {
		
		
		DocumentBuilderFactory factory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder
				.parse("http://www.yr.no/sted/Norge/Telemark/Sauherad/Gvarv/varsel.xml");
		doc.getDocumentElement().normalize();
		NodeList nodeList = doc.getElementsByTagName("location");
		System.out.println("Root element :"
				+ doc.getDocumentElement().getNodeName());
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(false);
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		int num = nodeList.getLength();
		
		for (int i=0; i<num; i++) {
			Element node = (Element) nodeList.item(i);
			listAllAttributes(node);
		}
		
	}

	public static void listAllAttributes(Element element) {
		
		System.out.println("List attributes for node: " + element.getNodeName());
		
		// get a map containing the attributes of this node 
		NamedNodeMap attributes = element.getAttributes();

		// get the number of nodes in this map
		int numAttrs = attributes.getLength();

		for (int i = 0; i < numAttrs; i++) {
			Attr attr = (Attr) attributes.item(i);
			
			String attrName = attr.getNodeName();
			String attrValue = attr.getNodeValue();
			
			System.out.println("Found attribute: " + attrName + " with value: " + attrValue);
			
		}
	}

}