package xmlParsingSAX;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadXMLFile{
	
	public static void main(String[] args) {
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		SAXParser saxParser = null;
		try {
			saxParser = factory.newSAXParser();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		DefaultHandler handler = new DefaultHandler() {
			
			boolean bName = false;
			boolean bPrice = false;
			boolean bDescription = false;
			boolean bCalories = false;
			
			public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
				
				if(qName.equalsIgnoreCase("name")) {
					bName = true;
				}
				
				if(qName.equalsIgnoreCase("price")) {
					bPrice = true;
				}
				
				if(qName.equalsIgnoreCase("description")) {
					bDescription = true;
				}
				
				if(qName.equalsIgnoreCase("calories")) {
					bCalories = true;
				}
			}
			
			public void endElement(String uri, String localName, String qName) {
				
			}
			
			public void characters(char[] ch, int start, int length) throws SAXException {
				
				if(bName) {
					System.out.println("name : " +new String(ch, start, length));
					bName = false;
				}
				
				if(bPrice) {
					System.out.println("price : " +new String(ch, start, length));
					bPrice = false;
				}
				
				if(bDescription) {
					System.out.println("description : " +new String(ch, start, length));
					bDescription = false;
				}
				
				if(bCalories) {
					System.out.println("calories : " +new String(ch, start, length));
					bCalories = false;
				}
				
			}
		
		};
		
		try {
			saxParser.parse("sample.xml", handler);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}