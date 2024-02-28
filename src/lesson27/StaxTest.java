package lesson27;

import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.XMLEvent;

public class StaxTest {

	public static void main(String[] args) throws XMLStreamException {
		final XMLInputFactory	factory = XMLInputFactory.newInstance();
		final XMLEventReader	rdr = factory.createXMLEventReader(StaxTest.class.getResourceAsStream("test.xml"));
		
		while (rdr.hasNext()) {
		    XMLEvent event = rdr.nextEvent();
		    
		    switch (event.getEventType()) {
		    	case XMLEvent.START_ELEMENT	:
		    		final Iterator<Attribute> 	attrs = event.asStartElement().getAttributes();
		    		
		    		System.err.println("Name: "+event.asStartElement().getName());
		    		while(attrs.hasNext()) {
		    			final Attribute attr = attrs.next();
		    			
			    		System.err.println("Attr: "+attr.getName()+"="+attr.getValue());
		    		}
		    		break;
		    	case XMLEvent.CHARACTERS	:
		    		System.err.println("Content: "+event.asCharacters().getData());
		    		break;
		    }
		}
		
		
		final XMLOutputFactory	outFactory = XMLOutputFactory.newInstance();
		final XMLStreamWriter	writer = outFactory.createXMLStreamWriter(System.err);
		
		writer.writeStartDocument();
			writer.writeStartElement("people");
				writer.writeStartElement("human");
				writer.writeAttribute("age", "21");
				writer.writeStartElement("family");
					writer.writeCharacters("ivanov");
				writer.writeEndElement();
				writer.writeEndElement();
			writer.writeEndElement();
		writer.writeEndDocument();
		
		writer.flush();
		writer.close();
	}

}
