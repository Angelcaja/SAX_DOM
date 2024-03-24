import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class Ejercicio9 {

	public static void main(String[] args) {
		try {

			// Creo un objeto SAXParserFactory
			SAXParserFactory factory = SAXParserFactory.newInstance();

			// Creao un objeto SAXParser
			SAXParser parser = factory.newSAXParser();

			// Especifico el manejador (handler) para el parser
			ManejadorXML handler = new ManejadorXML();

			// Parseao el archivo XML
			parser.parse(new File("Personas.xml"), handler);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

// Implemento el manejador (handler) que extiende DefaultHandler
class ManejadorXML extends DefaultHandler {

	boolean nombre = false;
	boolean apellido = false;
	boolean nacionalidad = false;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//llamada al inicio de un elemento XML
		if (qName.equalsIgnoreCase("nombre")) {
			nombre = true;
		} else if (qName.equalsIgnoreCase("apellido")) {
			apellido = true;
		} else if (qName.equalsIgnoreCase("nacionalidad")) {
			nacionalidad = true;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// Método llamado cuando se encuentran caracteres dentro de un elemento
		if (nombre) {
			System.out.println("Nombre: " + new String(ch, start, length));
			nombre = false;
		} else if (apellido) {
			System.out.println("Apellido: " + new String(ch, start, length));
			apellido = false;
		} else if (nacionalidad) {
			System.out.println("nacionalidad: " + new String(ch, start, length));
			nacionalidad = false;
		}
	}
}