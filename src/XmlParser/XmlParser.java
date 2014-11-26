package XmlParser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlParser {
	public String clouds, celsius, fahrenheit, windText, windDirection, season,
			month, nextUpdate, lastUpdate, altitude, latitude, longitude;
	public int symbol, seasons, celsiusInt;
	public Double wind, precipitation;

	public String XmlParser(String urlNorsk, String lengdeGrad) {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();
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
		// Get relevant data from XML:
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			symbol = Integer.parseInt(eElement.getElementsByTagName("symbol")
					.item(0).getAttributes().getNamedItem("numberEx")
					.getTextContent());
			precipitation = Double.parseDouble(eElement
					.getElementsByTagName("precipitation").item(0)
					.getAttributes().getNamedItem("value").getTextContent());
			lastUpdate = (eElement.getElementsByTagName("lastupdate").item(0)
					.getTextContent());
			nextUpdate = (eElement.getElementsByTagName("nextupdate").item(0)
					.getTextContent());
			seasons = Integer.parseInt(month = Character.toString(lastUpdate
					.charAt(5)) + Character.toString(lastUpdate.charAt(6)));
			clouds = eElement.getElementsByTagName("symbol").item(0)
					.getAttributes().getNamedItem("name").getTextContent();
			wind = Double.parseDouble(eElement
					.getElementsByTagName("windSpeed").item(0).getAttributes()
					.getNamedItem("mps").getTextContent());
			windText = eElement.getElementsByTagName("windSpeed").item(0)
					.getAttributes().getNamedItem("name").getTextContent();
			windDirection = eElement.getElementsByTagName("windDirection")
					.item(0).getAttributes().getNamedItem("name")
					.getTextContent();
			celsius = eElement.getElementsByTagName("temperature").item(0)
					.getAttributes().getNamedItem("value").getTextContent();
			altitude = eElement.getElementsByTagName("location")
					.item(1).getAttributes().getNamedItem("altitude")
					.getTextContent();
			longitude = eElement.getElementsByTagName("location")
					.item(1).getAttributes().getNamedItem("longitude")
					.getTextContent();
			latitude = eElement.getElementsByTagName("location")
					.item(1).getAttributes().getNamedItem("latitude")
					.getTextContent();
			celsiusInt = Integer.parseInt(celsius);
			fahrenheit = Double.parseDouble(celsius) * 1.8000 + 32 + "";
			System.out.print(clouds +" ");
			System.out.println(symbol);
			System.out.println("Vind: " + windText + ", " + wind + " m/s");
			System.out.println("Vindretning: " + windDirection);
			System.out.println("Temperatur: " + celsius + "C");
			System.out.println("Nedbør: " + precipitation);
			System.out.println("Sist oppdatert: " + lastUpdate);
			System.out.println("Neste oppdatering: " + nextUpdate);
			System.out.println("Høyde over havet: " + altitude + " meter");
			System.out.println("Koordinater:  Lengdegrad: " + longitude + "    Breddegrad :" + latitude);
		}
		return "------------------------------------------------------------------";
	}

	public String getClouds() {
		return clouds;
	}

	public int getSymbol() {
		return symbol;
	}

	public Double getWind() {
		return wind;
	}

	public Double getPrecipitation() {
		return precipitation;
	}

	public String getCelsius() {
		return celsius;
	}

	public String getFahrenheit() {
		return fahrenheit + "¡F";
	}

	public int getCelsiusInt() {
		return celsiusInt;
	}
	
	public String getAltitude() {
		return altitude;
	}
	
	public String getKoordinater() {
		return latitude + longitude;
	}

	public String getSeason() {
		if ((seasons == 12) || (seasons == 11) || (seasons == 1)
				|| (seasons == 2) || (seasons == 3)) {
			season = "winter";
		} else if ((seasons == 4) || (seasons == 5)) {
			season = "spring";
		} else if ((seasons == 6) || (seasons == 7) || (seasons == 8)) {
			season = "summer";
		} else if ((seasons == 9) || (seasons == 10)) {
			season = "fall";
		}
		return season;
	}



	}

