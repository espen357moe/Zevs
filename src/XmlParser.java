
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
	// all datatypes we would like to get out of the XML parsing
	public String clouds; // Main weather depiction for clouds and sun.
	//Temperature data:
	public String celsius; // For displaying temperature in degrees celsius.
	public String fahrenheit; // For displaying temperature in degrees Fahrenheit.
	public int celsiusInt; // Used for measuring Temperature.
	//Wind data:
	public String windText; // Wind speed textual content. e.g "Fresh breeze".
	public Double wind; // Wind speed m/s.
	public String windDirection; // wind Direction textual content.
	//Seasonal data:
	public String season; // Used to depict seasonal ground changes in main program.
	public int seasons; //Used to set season
	public String month; // Used to convert chars to String.
	//Updates data:
	public String lastUpdate; // Display latest update of XML
	public String nextUpdate; // Display next update of XML
	//DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
	public XmlParser() {
	DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder = null;
	Document document = null;
	try {
	builder = builderFactory.newDocumentBuilder();
	} catch (ParserConfigurationException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	try {
	document = builder.parse(new URL("http://www.yr.no/sted/Norge/Vestfold/Larvik/Stavernsodden/varsel.xml").openStream()); // Try to load xml from url.
	} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} catch (SAXException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	document.getDocumentElement().normalize(); //Normalize document.
	NodeList nList = document.getElementsByTagName("weatherdata");
	Node nNode = nList.item(0);
	//Get relevant data from XML:
	if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	Element eElement = (Element) nNode;
	lastUpdate = (eElement.getElementsByTagName("lastupdate").item(0).getTextContent());
	nextUpdate = (eElement.getElementsByTagName("nextupdate").item(0).getTextContent());
	seasons = Integer.parseInt(month = Character.toString(lastUpdate.charAt(5)) + Character.toString(lastUpdate.charAt(6)));
	clouds = eElement.getElementsByTagName("symbol").item(0).getAttributes().getNamedItem("name").getTextContent();
	wind = Double.parseDouble(eElement.getElementsByTagName("windSpeed").item(0).getAttributes().getNamedItem("mps").getTextContent()); // Get Wind m/s String and convert to double.
	windText = eElement.getElementsByTagName("windSpeed").item(0).getAttributes().getNamedItem("name").getTextContent(); //Get textual content of wind e.g. "Fresh breeze".
	windDirection = eElement.getElementsByTagName("windDirection").item(0).getAttributes().getNamedItem("name").getTextContent();
	celsius = eElement.getElementsByTagName("temperature").item(0).getAttributes().getNamedItem("value").getTextContent();
	celsiusInt = Integer.parseInt(celsius);
	fahrenheit = Double.parseDouble(celsius) * 1.8000 + 32 + ""; // Convert Celsius to Fahrenheit.
	// Display weather data in the console. For test purposes, Can be commented out:
	System.out.println(clouds);
	System.out.println("Vind: "+windText +", " + wind + " m/s");
	System.out.println("Vindretning: "+windDirection);
	System.out.println("Temperatur: " + celsius + "¡C / " + fahrenheit+ "¡F");
	System.out.println("Sist oppdatert: " + lastUpdate);
	System.out.println("Neste oppdatering: " + nextUpdate);
	//System.out.println(season);
	}
	}
	// Methods for getting data:
	public String getClouds() {
	return clouds;
	}
	public Double getWind() {
	return wind;
	}
	public String getCelsius() {
	return celsius;
	}
	public String getFahrenheit() {
	return fahrenheit + "¡F";
	}
	public int getCelsiusInt(){
	return celsiusInt;
	}
	public String getSeason(){
	if ((seasons==12)||(seasons==11)||(seasons==1) || (seasons==2) || (seasons==3))
	{
	season="winter";
	}
	else if ((seasons==4)||(seasons==5))
	{
	season="spring";
	}
	else if ((seasons==6)||(seasons==7)||(seasons==8))
	{
	season="summer";
	}
	else if ((seasons==9)||(seasons==10))
	{
	season="fall";
	}
	return season;
	}
	
	public static void main(String[] args) {
		new XmlParser();
	}
	}