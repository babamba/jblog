<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div class="center-content">
	<h1 class="logo">JBlog</h1>
	  <c:if test="${not empty authUser }">
	      <strong>${authUser.name} 님 안녕하세요</strong>
	  </c:if>
	
	<c:import url = "/WEB-INF/views/includes/navigation.jsp"/>
	<c:import url = "/WEB-INF/views/includes/searchbar.jsp"/>
	</div>
</body>
</html>