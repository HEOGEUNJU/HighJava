<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	String uId = request.getParameter("userId");
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn = DriverManager.getConnection(url,"MKJ93","java");
	Statement stmt = conn.createStatement();
	
	String sql = "select mem_id from member where mem_id = '" + uId + "'";
	
	ResultSet rs = stmt.executeQuery(sql);
	if(rs.next()){
		// 결과가 조회되었을 때 중복 -> 사용불가
		
%>
<%-- jsp 문자열 주석 문양 주의 !사용 시 500 에러 발생 --%>
		{
			"code" : "no", 
			"msg" : "사용불가" }
<%
	} else {
		// id 사용가능
%>
		{	"code" : "ok", 
			"msg" : "사용가능" }
<%
	}
%>