<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String uId = request.getParameter("userId");
	String uPw = request.getParameter("userPw");

// JDBC를 사용해서 DB정보 가져오기
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn = DriverManager.getConnection(url, "MKJ93", "java");
	Statement stmt = conn.createStatement();
	String sql = "select mem_id from member where mem_id = '" + uId +  "' and mem_pass = '" + uPw + "'";
	ResultSet rs = stmt.executeQuery(sql);
	System.out.println(uId); 
	System.out.println(uPw); 
	
	//System.out.println(rs.next()); //boolean값으로 확인 가능
	if(rs.next()){
%>
		
		{"rst" : "ok"}
<%
	} else{
%>
		{"rst" : "fail"}
<%
	}
	
%>
