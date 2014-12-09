package controller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import model.MeteorologiData;
import model.SoekeTreff;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlParser {
	
	private String stedsNavn;
	private int hoydeOverHavet; //- altitude
	//private String koordinater; //- longitude + latitude
	private float nedbor; //- precipitation
	private String skyDekke; //- clouds
	private int temperatur; //- celsiusInt
	private String vindBetegnelse;
	private String vindRetning; //- windDirection
	private float vindHastighet; //- wind
	private int symbolNummer; //- symbol
	private String sistOppdatert; //- lastUpdate
	private String nesteOppdatering; //- nextUpdate
	
	public String clouds, celsius, fahrenheit, windText, windDirection, month, nextUpdate, lastUpdate, altitude, breddeGrad, lengdeGrad;
	public int symbol, celsiusInt;
	public double wind, precipitation;

	public MeteorologiData parseXml(SoekeTreff soekeTreff) {
		
		String urlNorsk = soekeTreff.getUrlNorsk();
		stedsNavn = soekeTreff.getStedsNavn();
		
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document document = null;
		
		try {
			builder = builderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		try {
			document = builder
					.parse(new URL(urlNorsk)
							.openStream());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		document.getDocumentElement().normalize();
		
		NodeList nList = document.getElementsByTagName("weatherdata");
		
		Node nNode = nList.item(0);
		
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			
			symbolNummer = Integer.parseInt((eElement.getElementsByTagName("symbol")
					.item(0).getAttributes().getNamedItem("numberEx")
					.getTextContent()));
			
			nedbor = Float.parseFloat(eElement
					.getElementsByTagName("precipitation").item(0)
					.getAttributes().getNamedItem("value").getTextContent());
			
			sistOppdatert = (eElement.getElementsByTagName("lastupdate").item(0)
					.getTextContent());
			
			nesteOppdatering = (eElement.getElementsByTagName("nextupdate").item(0)
					.getTextContent());
			
			skyDekke = eElement.getElementsByTagName("symbol").item(0)
					.getAttributes().getNamedItem("name").getTextContent();
			
			vindHastighet = Float.parseFloat(eElement
					.getElementsByTagName("windSpeed").item(0).getAttributes()
					.getNamedItem("mps").getTextContent());
			
			vindBetegnelse = eElement.getElementsByTagName("windSpeed").item(0)
					.getAttributes().getNamedItem("name").getTextContent();
			
			vindRetning = eElement.getElementsByTagName("windDirection")
					.item(0).getAttributes().getNamedItem("name")
					.getTextContent();
			
			celsius = eElement.getElementsByTagName("temperature").item(0)
					.getAttributes().getNamedItem("value").getTextContent();
			
			hoydeOverHavet = Integer.parseInt(eElement.getElementsByTagName("location")
					.item(1).getAttributes().getNamedItem("altitude")
					.getTextContent());
			
			lengdeGrad = eElement.getElementsByTagName("location")
					.item(1).getAttributes().getNamedItem("longitude")
					.getTextContent();
			
			breddeGrad = eElement.getElementsByTagName("location")
					.item(1).getAttributes().getNamedItem("latitude")
					.getTextContent();
			
			temperatur = Integer.parseInt(celsius);
			
			fahrenheit = Double.parseDouble(celsius) * 1.8000 + 32 + "";
			
			System.out.println(stedsNavn);
			System.out.println(skyDekke);
			System.out.println("Symbolnummer: " + symbol);
			System.out.println("Vind: " + vindBetegnelse + ", " + vindHastighet + " m/s");
			System.out.println("Vindretning: " + vindRetning);
			System.out.println("Temperatur: " + temperatur + "°C");
			System.out.println("Nedbør: " + nedbor);
			System.out.println("Sist oppdatert: " + sistOppdatert);
			System.out.println("Neste oppdatering: " + nesteOppdatering);
			System.out.println("Høyde over havet: " + hoydeOverHavet + " meter");
			System.out.println("Breddegrad:  " + breddeGrad);
			System.out.println("Longitude:  " + lengdeGrad);
		}
		
		MeteorologiData meteorologiData = new MeteorologiData(stedsNavn, hoydeOverHavet, breddeGrad, lengdeGrad, nedbor, skyDekke, temperatur, vindRetning, vindBetegnelse, vindHastighet, symbolNummer, sistOppdatert, nesteOppdatering);	
				
		return meteorologiData;
	}

	
}

