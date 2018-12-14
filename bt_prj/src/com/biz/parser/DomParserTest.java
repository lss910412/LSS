package com.biz.parser;

import javax.xml.parsers.*;
import org.w3c.dom.*;

public class DomParserTest  {

	public static void main(String[] args) { 
		try {
			//DOM Document 객체 생성하기 위한 메서드 
			DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
			//DOM 파서로부터 입력받은 파일을 파싱하도록 요청
			DocumentBuilder parser = f.newDocumentBuilder();

			//XML 파일 지정
			String url = "C:\\jp\\workspace_java\\bt_prj\\src\\com\\biz\\parser\\book.xml";

			Document xmlDoc = null; 
			//DOM 파서로부터 입력받은 파일을 파싱하도록 요청 
			xmlDoc = parser.parse(url);

			//루트 엘리먼트
			Element root = xmlDoc.getDocumentElement();
			System.out.println("root TAG : " + root.getTagName());    //<booklist>

			
			//하위 엘리먼트 리스트
			NodeList bookNodeList = root.getElementsByTagName("book");
			
			//전체 출력
			//속성값 			: isbn, kind
			//엘리먼트 텍스트 값	: title, author, price
			System.out.println("------------------------------------------------------------------");
			for(int i=0; i<bookNodeList.getLength(); i++)
			{
				Node bookNode = bookNodeList.item(i);
				Element bookElement = (Element)bookNode;
				String is = bookElement.getAttribute("isbn");
				String ki = bookElement.getAttribute("kind");
				
				String title  = bookElement.getElementsByTagName("title").item(0).getTextContent();
				String author = bookElement.getElementsByTagName("author").item(0).getTextContent();
				String price  = bookElement.getElementsByTagName("pirce").item(0).getTextContent();
				
				System.out.println(is +","+ ki+","+ title+","+ author+","+ price);       
			}

		} catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}



//
//import org.w3c.dom.*;
//
//import javax.xml.XMLConstants;
//import javax.xml.parsers.*;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.validation.Schema;
//import javax.xml.validation.SchemaFactory;
//import javax.xml.validation.Validator;
//
//import java.io.*;
//
//public class DomParserTest {
//
//	public static void main(String[] args) {
////		http://blog.rss.naver.com/knockya.xml
////		https://howtodoinjava.com/xml/read-xml-dom-parser-example/
//		
//		String filename = "C:\\jp\\workspace_java\\bt_prj\\src\\com\\biz\\parser\\emp.xml";
//		
//		try {
//			//Get Document Builder
//			DocumentBuilderFactory builderFactoryFactory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder builder = builderFactoryFactory.newDocumentBuilder();
//			
//			//Build Document
//			Document document = builder.parse(new File(filename));
//			
//			
//			//Normalize the XML Structure; It's just too important !!
////			document.getDocumentElement().normalize();
//			
//			//OPTIONAL : Validate Document structure
////			String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
////			SchemaFactory schemaFactory = SchemaFactory.newInstance(language);
////			Schema schema = schemaFactory.newSchema(new File(filename));
////			Validator validator = schema.newValidator();
////			validator.validate(new DOMSource(document));
//			
//			
//			//root node
//			Element rootNode = document.getDocumentElement();
//			System.out.println(rootNode.getNodeName());
//			
//			//Get all employees
//			NodeList nList = document.getElementsByTagName("employee");
//			System.out.println("============================");
//			
//			for(int i = 0; i < nList.getLength(); i++){
//				Node node = nList.item(i);
//				if (node.getNodeType() == Node.ELEMENT_NODE) {
//					Element eElement = (Element)node;
//				    System.out.println("Employee id : " + eElement.getAttribute("id"));
//				    System.out.println("First Name : "  + eElement.getElementsByTagName("firstName").item(0).getTextContent());
//				    System.out.println("Last Name : "   + eElement.getElementsByTagName("lastName").item(0).getTextContent());
//				    System.out.println("Location : "    + eElement.getElementsByTagName("location").item(0).getTextContent());
//				 }
//			}
//			
////			element.getAttribute("attributeName");   		//returns specific attribute
////			element.getAttributes();               	 		//returns a Map(table) of names/values
////			
////			node.getElementsByTagName("subElementName"); //returns a list of sub-elements of specified name
////			node.getChildNodes();                        //returns a list of all child nodes
////			
//			
//		} catch (ParserConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//		    e.printStackTrace();
//		}
//		
//		
//
//	}
//
//}
