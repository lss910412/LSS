package com.biz.parser;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParserTest extends DefaultHandler {
	public static void main(String[] args) {
		
		String url = "C:\\jp\\workspace_java\\bt_prj\\src\\com\\biz\\parser\\book.xml";
		
		try {
			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
			
			File xmlFile = new File(url);
			parser.parse(xmlFile, new SaxParserTest());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 문서의 시작
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("Start Document");
	}

	// 엘리먼트 시작
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("Start Element: " + qName);
		// 엘리먼트 속성
		for (int i = 0; i < attributes.getLength(); i++) {
			System.out.println("Attribute: " + attributes.getQName(i) + "=" + attributes.getValue(i));
		}
	}
	// 엘리먼트 끝
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("End Element: " + qName);
	}
	// 텍스트 데이터
	public void characters(char ch[], int start, int length) throws SAXException {
		System.out.println("Character: " + new String(ch, start, length));
	}
	// 문서의 끝
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("End Document");
	}

	
}


