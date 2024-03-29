package lesson27;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DomTest {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerFactoryConfigurationError, TransformerException, XPathExpressionException, XMLStreamException {
		final DocumentBuilder 	builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		final Document 			doc = builder.parse(DomTest.class.getResourceAsStream("test.xml"));
		
		doc.getDocumentElement().normalize();
		
		final NodeList nodeList = doc.getElementsByTagName("family");

	    System.err.println("Length="+nodeList.getLength());
	    final Node first = nodeList.item(0);
	    
	    System.err.println("Node type="+first.getNodeType());
	    System.err.println("Node name="+first.getNodeName());  		
	    System.err.println("Node value="+first.getTextContent());

	    
		final NodeList human = doc.getElementsByTagName("human");
	    
		int sum = 0;
		for(int index = 0; index < human.getLength(); index++) {
			final Node	n = human.item(index);
			Element e = (Element)n;
			String age = e.getAttribute("age");
			sum += Integer.valueOf(age);
		}
		System.err.println("Average age = "+(1.0 * sum / human.getLength()));
	    
	    
	    final XPath 	xPath = XPathFactory.newInstance().newXPath();
	    final String 	expression = "/*/human[@age='25']";
		final NodeList 	found = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
		
	    final Node item = found.item(0);
	    
	    
	    System.err.println("Found type="+item.getNodeType());
	    System.err.println("Found name="+item.getNodeName());  		
	    System.err.println("Found value="+item.getTextContent());
	    
	    final Element newItem = doc.createElement("comment");

	    newItem.appendChild(doc.createTextNode("any shit about"));
	    newItem.setAttribute("id", "100");
	    
	    first.getParentNode().appendChild(newItem);

		final DOMSource dom = new DOMSource(doc);
	    final Transformer transformer = TransformerFactory.newInstance().newTransformer();
	    final StreamResult result = new StreamResult(System.err);
	    
	    transformer.transform(dom, result);
	    
		final XMLOutputFactory	outFactory = XMLOutputFactory.newInstance();
		final XMLStreamWriter	writer = outFactory.createXMLStreamWriter(System.out);
		
		writer.writeStartDocument();
			writer.writeStartElement("people");
			
			for(int index = 0; index < nodeList.getLength(); index++) {
				final Element	n = (Element)nodeList.item(index);
				writer.writeStartElement("family");
					writer.writeCharacters(n.getTextContent());
				writer.writeEndElement();
			}
			writer.writeEndElement();
		writer.writeEndDocument();
		
		writer.flush();
		writer.close();
	    
	}

}
