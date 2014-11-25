

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TeamTvilsomAttributes {


	public static void listAllAttributes(Element element) {
		NamedNodeMap attributes = element.getAttributes();
		int antallAttrs = attributes.getLength();
		for (int i = 0; i < antallAttrs;){	
			Attr høyde = (Attr) attributes.item(0);
			Attr bredde = (Attr) attributes.item(3);
			Attr lengde = (Attr) attributes.item(4);
			
			if (høyde != null){
			String høydeName = høyde.getNodeName();
			String høydeValue = høyde.getNodeValue();
			System.out.println(høydeName + " : " + høydeValue);
			} 
			
			if(bredde != null) {
			String breddeName = bredde.getNodeName();
			String breddeValue = bredde.getNodeValue();
			System.out.println(breddeName + " : " + breddeValue);
			}
			
			if (lengde != null){
			String lengdeName = lengde.getNodeName();
			String lengdeValue = lengde.getNodeValue();
			System.out.println(lengdeName + " : " + lengdeValue);
			}			
		 break; 
		   
		}
	}

	public char[] sendtLink(String urlNorsk) {
		try {
			System.out.println(urlNorsk);
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder
					.parse(urlNorsk);
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getElementsByTagName("location");
			System.out.println("Root element :"
					+ doc.getDocumentElement().getNodeName());
			
			int num = nodeList.getLength();
			
			for (int i=0; i<num; i++) {
				Element node = (Element) nodeList.item(i);
				listAllAttributes(node);
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}