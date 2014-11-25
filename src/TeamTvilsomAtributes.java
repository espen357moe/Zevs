

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
		
		// get a map containing the attributes of this node 
		NamedNodeMap attributes = element.getAttributes();

		// get the number of nodes in this map
		int numAttrs = attributes.getLength();

		for (int i = 0; i < numAttrs;) {
			
			
			
			Attr altitude = (Attr) attributes.item(0);
			Attr latitude = (Attr) attributes.item(3);
			Attr longitude = (Attr) attributes.item(4);
			
			
			if(latitude != null) {
			String latitudeName = latitude.getNodeName();
			String latitudeValue = latitude.getNodeValue();
			System.out.println(latitudeName + " : " + latitudeValue);
			}
			
			if (longitude != null){
			String longitudeName = longitude.getNodeName();
			String longitudeValue = longitude.getNodeValue();
			System.out.println(longitudeName + " : " + longitudeValue);
			}
			
			if (altitude != null){
			String altitudeName = altitude.getNodeName();
			String altitudeValue = altitude.getNodeValue();
			System.out.println(altitudeName  + " : " + altitudeValue);
			}
		break;
		   
		}
	}

}