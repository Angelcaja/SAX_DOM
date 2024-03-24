
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class Ejercicio8 {

	public static void main(String[] args) {
		try {

			// Creo un objeto SAXParserFactory
			SAXParserFactory factory = SAXParserFactory.newInstance();

			// Creao un objeto SAXParser
			SAXParser parser = factory.newSAXParser();

			// Especifico el manejador (handler) para el parser
			Example handler = new Example();

			// Parseao el archivo XML
			parser.parse(new File("XmlEjercicio8"), handler);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Example extends DefaultHandler {
	
	// Métodos sobrescritos para manejar eventos SAX
	
	//llamada al inicio del documento XML
	public void startDocument() {
		System.out.println("Comienzo del documento XML");
	}
	// llamada al final del documento XML
	public void endDocument() {
		System.out.println("Final del documento XML");
	}
	//llamada al inicio de un elemento XML
	public void startElement(String uri, String nombre, String nombreC, Attributes atts) {
		System.out.printf("\t Principio elemento: %s %n" , nombreC);
	}
	//llamada al final de un elemento XML
	public void endElement (String uri, String nombre, String nombreC) {
		System.out.printf("\t Fin Elemento: %s %n" , nombreC);
	}
	//se hace la llamada a los carácteres escritos dentro de un elemento en el caso de que los tenga
	public void characters (char[] ch, int inicio, int longitud) throws SAXException {
		String car = new String (ch, inicio, longitud);
		//eliminamos tabulaciones y saltos de linea
		car = car.replaceAll("[\t\n]","");
		System.out.printf("\t Caracteres: %s %n" , car);
	}
}