package lesson27;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxTest {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		final SAXParser	parser = SAXParserFactory.newInstance().newSAXParser();
		final MyHandler h = new MyHandler(); 
		
		parser.parse(SaxTest.class.getResourceAsStream("test.xml"), h);
		
	}

	public static class MyHandler extends DefaultHandler {
	    private StringBuilder value = new StringBuilder();

	    @Override
	    public void characters(char[] ch, int start, int length) throws SAXException {
	    	value.append(ch, start, length);
	    }

	    @Override
	    public void startElement(String uri, String lName, String qName, Attributes attr) throws SAXException {
	        switch (qName) {
	            case "human":
	            	System.err.println("Human: age="+attr.getValue("age"));
	                break;
	            case "family":
	            	value.setLength(0);
	                break;
	            case "name":
	            	value.setLength(0);
	                break;
	            case "patroname":
	            	value.setLength(0);
	                break;
	        }
	    }

	    @Override
	    public void endElement(String uri, String localName, String qName) throws SAXException {
	        switch (qName) {
	            case "human":
	                break;
	            case "family":
	            	System.err.println("Family="+value);
	                break;
	            case "name":
	            	System.err.println("Name="+value);
	                break;
	            case "patroname":
	            	System.err.println("Patroname="+value);
	                break;
	        }
	    }
	}	
}
