package kr.or.ddit.basic;

import java.io.File;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * XML DOM을 이용한 XML문서 파싱 예제(레시피정보 조회 API)
 * 
 * @author PC-05
 *
 */
public class T03DOMParsingExam2 {

	public void parse() throws Exception {
		
  		String apiKey = "L6I8RPohz0b89AHjzWh%2B2GJ4i3o%2BZK9shI7RS3xduVScQTWjQZNcWhQJdKrixOQzJRoJcA7P6A59Oze1Sdzruw%3D%3D&"; // 개인별 발급.
  		URL url = new URL("http://apis.data.go.kr/6300000/storyDaejeonService/storyDaejeonList?serviceKey=L6I8RPohz0b89AHjzWh%2B2GJ4i3o%2BZK9shI7RS3xduVScQTWjQZNcWhQJdKrixOQzJRoJcA7P6A59Oze1Sdzruw%3D%3D&");

  		//System.out.println(url.toString());
		
		// XML문서를 생성하기 위한 DocumentBuilder객체 생성하기
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder = dbf.newDocumentBuilder();

		// Document 객체 생성
		Document document = builder.parse(url.toString());
		
		// Root 엘리먼트 가져오기
		Element root = document.getDocumentElement();
		System.out.println("루트엘리먼트 태그명 : " + root.getTagName());
		
		//전체 레시피 수를 가져오기
//		
//		String totalCnt = root.getElementsByTagName("totalCnt").item(0).getTextContent();
//		endIdx = totalCnt;
//		
//		 url = new URL("http://211.237.50.150:7080/openapi/"+ apiKey
//	  				+ "/xml/"+ svcKey + "/"+startIdx +"/" + endIdx
//	  				+"?RECIPE_ID=" +  recipeId);
//		 
//		 document = builder.parse(url.toString());
//
//		 root = document.getDocumentElement();
//		 String code = root.getElementsByTagName("code").item(0).getTextContent();
//		 
//		 if(code.equals("INFO-000")) { //정상상태인 경우"
//		 		NodeList rowNodeList = root.getElementsByTagName("row");
//		 		
//		 		for(int i = 0; i<rowNodeList.getLength(); i++) {
//		 			Element element = (Element) rowNodeList.item(i);
//		 			
//		 			String rowNum = element.getElementsByTagName("ROW_NUM").item(0).getTextContent();
//		 			String irdntNm = element.getElementsByTagName("IRDNT_NM").item(0).getTextContent();
//		 			String irdntCpacty = element.getElementsByTagName("IRDNT_CPCTY").item(0).getTextContent();
//		 			String rowirdntTynm = element.getElementsByTagName("IRDNT_TY_NM").item(0).getTextContent();
//		 			System.out.printf( " %3s %8s %10s %10s %8s \n", rowNum, recipeId, irdntNm, rowirdntTynm, irdntCpacty);
//		 			System.out.println("------------------------------------------------------");
//		 			
//		 		}
//		 }
//		 
		
		
	}

	public static void main(String[] args) throws Exception {
		new T03DOMParsingExam2().parse();
	}

}
