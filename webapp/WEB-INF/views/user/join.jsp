<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
<script>

	$(function(){
		return true;
		$("#join-form").submit(function(){
	/* 		return true; */
			if($("#name").val() == ""){
			   $("#dialog p").text("이름은 필수 입력 항목입니다.")
			   $("#dialog").dialog();
			   $("#name").focus();
			   return false;
			}
			return true;
		})
	})

</script>
</head>
<body>

	<div class="center-content">
		<h1 class="logo">JBlog</h1>
			<c:import url = "/WEB-INF/views/includes/navigation.jsp"/>
			
			<form:form
			modelAttribute="userVo"
			class="join-form" 
			id="join-form" 
			method="post" 
			action="${pageContext.request.contextPath }/user/join">
			
			
			<label class="block-label" for="name">이름</label>
				<form:input path="name"/>
							<p style="text-align: left; color:red">
								<form:errors path="name"/>
							</p>
			
			<label class="block-label" for="blog-id">아이디</label>
				<form:input path="id"/>
			<p>
				<form:errors path="id"/>
			</p>
			
			<input id="btn-checkemail" type="button" value="id 중복체크">
			<img id="img-checkemail" style="display: none;" src="${pageContext.request.contextPath}/assets/images/check.png">
			
			<label class="block-label" for="password">패스워드</label>
				<form:input path="password"/>
			<p>
				<form:errors path="password"/>
			</p>

			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>

			<input type="submit" value="가입하기">
		<div id="dialog" title="가입폼 체크" style="display:none">
	  		<p></p>
		</div>	
		</form:form>
	</div>
</body>
</html>
