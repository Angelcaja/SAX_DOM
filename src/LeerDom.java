import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class LeerDom {

	public static void main(String[] args) {
		

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			
			try {
				DocumentBuilder builder = factory.newDocumentBuilder();
				//Instanciaremos el fichero que vamos a leer
				Document document = builder.parse(new File("Personas.xml"));
				document.getDocumentElement().normalize();
								
				//creamos una lista con tododos los nodos empleados
				NodeList Personas = document.getElementsByTagName("Persona");
				
				for (int i = 0; i < Personas.getLength();i++) {
					//selecionaremos nodo a nodo
					Node nodo = Personas.item(i);
					
					if (nodo.getNodeType() == Node.ELEMENT_NODE) { //Filtramos nodos existentes que no se ven
						
						Element e = (Element) nodo;
						NodeList hijos = e.getChildNodes(); //almacenamos los elementos hijos 
						
						for (int h = 0; h < hijos.getLength(); h++) { //recorremos los hijos
							Node hijo = hijos.item(h);
							if (hijo.getNodeType() == Node.ELEMENT_NODE) { //solo leemos en caso de que el nodo sea un elemento
								System.out.println("Nodo: " + hijo.getNodeName() + ", Texto: " + hijo.getTextContent());
							}
						}
					}
				}
		} catch (Exception e) {
			System.out.println("error");
		}
	}
}
