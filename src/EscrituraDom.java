import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class EscrituraDom {

	public static void main(String[] args) throws IOException, ParserConfigurationException {
		try {

			// Creamos la instancia para crear el documento xml
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			// Creamos un documento vacio con la version de xml
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			// documento con nombre raid (Personas)
			Document document = implementation.createDocument(null, "Personas", null);
			document.setXmlVersion("1.0");

			// etiquetas de persona1
			Element persona = document.createElement("Persona");
			// creamos los tags que iran dentro de la persona y elementos de texto que iran
			// dentro de estos

			// nombre
			Element nombre = document.createElement("Nombre");
			Text nombreTexto = document.createTextNode("Angel");
			nombre.appendChild(nombreTexto);
			persona.appendChild(nombre);
			// apellido
			Element apellido = document.createElement("Apellido");
			Text apellidoTexto = document.createTextNode("Caja");
			apellido.appendChild(apellidoTexto);
			persona.appendChild(apellido);
			// nacionalidad
			Element nacionalidad = document.createElement("Nacionalidad");
			Text nacionalidadTexto = document.createTextNode("Española");
			nacionalidad.appendChild(nacionalidadTexto);
			persona.appendChild(nacionalidad);

			// Incluyo persona 1 en la raiz
			document.getDocumentElement().appendChild(persona);

			// ---------------------------------------------------------------------------------------------------------------------------
			// Persona 2
			persona = document.createElement("Persona");
			// creamos los tags que iran dentro de la persona y elementos de texto que iran
			// dentro de estos

			// nombre
			nombre = document.createElement("Nombre");
			nombreTexto = document.createTextNode("Carolina");
			nombre.appendChild(nombreTexto);
			persona.appendChild(nombre);
			// apellido
			apellido = document.createElement("Apellido");
			apellidoTexto = document.createTextNode("Adamez");
			apellido.appendChild(apellidoTexto);
			persona.appendChild(apellido);
			// nacionalidad
			nacionalidad = document.createElement("Nacionalidad");
			nacionalidadTexto = document.createTextNode("Española");
			nacionalidad.appendChild(nacionalidadTexto);
			persona.appendChild(nacionalidad);

			document.getDocumentElement().appendChild(persona);

			// ---------------------------------------------------------------------------------------------------------------------------
			// Persona 3
			persona = document.createElement("Persona");
			// creamos los tags que iran dentro de la persona y elementos de texto que iran
			// dentro de estos

			// nombre
			nombre = document.createElement("Nombre");
			nombreTexto = document.createTextNode("Jorge");
			nombre.appendChild(nombreTexto);
			persona.appendChild(nombre);
			// apellido
			apellido = document.createElement("Apellido");
			apellidoTexto = document.createTextNode("Barbera");
			apellido.appendChild(apellidoTexto);
			persona.appendChild(apellido);
			// nacionalidad
			nacionalidad = document.createElement("Nacionalidad");
			nacionalidadTexto = document.createTextNode("Española");
			nacionalidad.appendChild(nacionalidadTexto);
			persona.appendChild(nacionalidad);

			document.getDocumentElement().appendChild(persona);

			// creo el fichero donde voy a escribir
			Source source = new DOMSource(document);
			Result result = new StreamResult(new File("Personas.xml"));

			// escribo el contenido de documento al fichero
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
			System.out.println("Fichero XML creado");

		} catch (ParserConfigurationException | TransformerException ex) {
			System.out.println(ex.getMessage());
		}
		
		
	}

}
