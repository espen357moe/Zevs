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

	private String stedsNavn, skyDekke, skyDekke24, skyDekke48, celsius,
			celsius24, celsius48, vindBetegnelse, vindBetegnelse24,
			vindBetegnelse48, sistOppdatert, vindRetning, vindRetning24,
			vindRetning48, nesteOppdatering, breddeGrad, lengdeGrad,
			vaerVarsel;
	private int hoydeOverHavet, temperatur, symbolNummer, symbolNummer24,
			symbolNummer48;
	private float nedbor, nedbor24, nedbor48, vindHastighet, vindHastighet24,
			vindHastighet48;

	public MeteorologiData parseXml(SoekeTreff soekeTreff) {

		String urlNorsk = soekeTreff.getUrlNorsk();
		stedsNavn = soekeTreff.getStedsNavn();

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
			document = builder.parse(new URL(urlNorsk).openStream());
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
			hentingAvElementer(eElement);
		}

		MeteorologiData meteorologiData = new MeteorologiData(stedsNavn,
				hoydeOverHavet, breddeGrad, lengdeGrad, nedbor, nedbor24,
				nedbor48, skyDekke, temperatur, vindRetning, vindBetegnelse,
				vindHastighet, symbolNummer, sistOppdatert, nesteOppdatering,
				vaerVarsel);

		return meteorologiData;
	}

	private void hentingAvElementer(Element eElement) {
		symbolNummer = Integer.parseInt((eElement
				.getElementsByTagName("symbol").item(0).getAttributes()
				.getNamedItem("numberEx").getTextContent()));

		symbolNummer24 = Integer.parseInt((eElement
				.getElementsByTagName("symbol").item(4).getAttributes()
				.getNamedItem("numberEx").getTextContent()));

		symbolNummer48 = Integer.parseInt((eElement
				.getElementsByTagName("symbol").item(8).getAttributes()
				.getNamedItem("numberEx").getTextContent()));

		nedbor = Float.parseFloat(eElement
				.getElementsByTagName("precipitation").item(0).getAttributes()
				.getNamedItem("value").getTextContent());

		nedbor24 = Float.parseFloat(eElement
				.getElementsByTagName("precipitation").item(4).getAttributes()
				.getNamedItem("value").getTextContent());

		nedbor48 = Float.parseFloat(eElement
				.getElementsByTagName("precipitation").item(8).getAttributes()
				.getNamedItem("value").getTextContent());

		sistOppdatert = (eElement.getElementsByTagName("lastupdate").item(0)
				.getTextContent());

		nesteOppdatering = (eElement.getElementsByTagName("nextupdate").item(0)
				.getTextContent());

		skyDekke = eElement.getElementsByTagName("symbol").item(0)
				.getAttributes().getNamedItem("name").getTextContent();

		skyDekke24 = eElement.getElementsByTagName("symbol").item(4)
				.getAttributes().getNamedItem("name").getTextContent();

		skyDekke48 = eElement.getElementsByTagName("symbol").item(8)
				.getAttributes().getNamedItem("name").getTextContent();

		vindHastighet = Float.parseFloat(eElement
				.getElementsByTagName("windSpeed").item(0).getAttributes()
				.getNamedItem("mps").getTextContent());

		vindHastighet24 = Float.parseFloat(eElement
				.getElementsByTagName("windSpeed").item(4).getAttributes()
				.getNamedItem("mps").getTextContent());

		vindHastighet48 = Float.parseFloat(eElement
				.getElementsByTagName("windSpeed").item(8).getAttributes()
				.getNamedItem("mps").getTextContent());

		vindBetegnelse = eElement.getElementsByTagName("windSpeed").item(0)
				.getAttributes().getNamedItem("name").getTextContent();

		vindBetegnelse24 = eElement.getElementsByTagName("windSpeed").item(4)
				.getAttributes().getNamedItem("name").getTextContent();

		vindBetegnelse48 = eElement.getElementsByTagName("windSpeed").item(8)
				.getAttributes().getNamedItem("name").getTextContent();

		vindRetning = eElement.getElementsByTagName("windDirection").item(0)
				.getAttributes().getNamedItem("name").getTextContent();

		vindRetning24 = eElement.getElementsByTagName("windDirection").item(4)
				.getAttributes().getNamedItem("name").getTextContent();

		vindRetning48 = eElement.getElementsByTagName("windDirection").item(8)
				.getAttributes().getNamedItem("name").getTextContent();

		celsius = eElement.getElementsByTagName("temperature").item(0)
				.getAttributes().getNamedItem("value").getTextContent();

		celsius24 = eElement.getElementsByTagName("temperature").item(4)
				.getAttributes().getNamedItem("value").getTextContent();

		celsius48 = eElement.getElementsByTagName("temperature").item(8)
				.getAttributes().getNamedItem("value").getTextContent();

		hoydeOverHavet = Integer.parseInt(eElement
				.getElementsByTagName("location").item(1).getAttributes()
				.getNamedItem("altitude").getTextContent());

		lengdeGrad = eElement.getElementsByTagName("location").item(1)
				.getAttributes().getNamedItem("longitude").getTextContent();

		breddeGrad = eElement.getElementsByTagName("location").item(1)
				.getAttributes().getNamedItem("latitude").getTextContent();

		vaerVarsel = ((eElement.getElementsByTagName("body").item(0)
				.getTextContent()).replaceAll("<strong>", "")).replaceAll(
				"</strong>", "");

		temperatur = Integer.parseInt(celsius);
	}

}