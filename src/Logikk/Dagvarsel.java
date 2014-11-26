package Logikk;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Dagvarsel {

	public Dagvarsel() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder
					.parse("http://www.yr.no/sted/Norge/Telemark/Sauherad/Gvarv/varsel.xml");
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getElementsByTagName("weatherdata");
			System.out.println("Root element :"
					+ doc.getDocumentElement().getNodeName());

			for (int temp = 0; temp < nodeList.getLength(); temp++) {
				Node node = nodeList.item(temp);
				System.out.println("\nElement type :" + node.getNodeName());
				System.out.println("");
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element weatherdata = (Element) node;
					System.out.println("Sted :		"
							+ weatherdata.getElementsByTagName("name").item(0)
									.getTextContent());
					System.out.println("Land :		"
							+ weatherdata.getElementsByTagName("country")
									.item(0).getTextContent());
					System.out.println("Type sted :	"
							+ weatherdata.getElementsByTagName("type").item(0)
									.getTextContent());
					System.out.println("Dag :		"
							+ weatherdata.getElementsByTagName("title").item(0)
									.getTextContent());
					System.out.println("V�r :		"
							+ weatherdata.getElementsByTagName("body").item(0)
									.getTextContent());
					System.out
						.println("Linker : " + weatherdata.getNodeValue());
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		
	}
		
	}
	
}
