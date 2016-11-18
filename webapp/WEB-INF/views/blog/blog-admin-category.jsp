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
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
var isEnd = false;
var data;

var render = function(vo){
						/* 파라미터 */
	
	var htmls = 
		"<tr><td id=>" + vo.categoryNo + "</td>" + 
		"<td>" + vo.categoryName + "</td>" + 
		"<td>" + vo.postCount + "</td>" + 
		"<td>" + vo.description + "</td>" +   
		"<td><img src='${pageContext.request.contextPath}/assets/images/delete.jpg'>" + "</td>" +	
		"</tr>";
		
		$("#table-body").prepend(htmls);

	}

	var list = function() {
		$.ajax({
			url : "${pageContext.request.contextPath}/admin/category",
			type : "get",
			dataType : "json",
			success : function(response) {

			$(response.data).each(function(index, vo){
				render(vo);
			});

				if (response.result != "success") {
					console.error(response.message);
					return;
				}
			}
		});

	}

	$(function() {

		list();
		
		
		$("#admin-cat-add").submit(function(event) {
			event.preventDefault(); /* 1. click 이벤트를 실행합니다. 2. 브라우저에게 href 에 표시된 곳으로 이동 */

			var name = $("#cate-title").val() /* form에 들어있는 value 들을 제어할 수 있는 함 */

			if (name == "") {
				messageBox("카테고리 명 입력", "카테고리 명은 필수 입력사항", function() {
					$("#cate-title").focus();
				});
				return;
			}
			var description = $("#cate-description").val() /* form에 들어있는 value 들을 제어할 수 있는 함 */

			if (description == "") {
				messageBox("카테고리 설명 입력", "카테고리 설명은 필수 입력사항", function() {
					$("#cate-description").focus();
				});
				return;
			}

			$.ajax({
				url : "${pageContext.request.contextPath}/blog/api/insert",
				type : "post", /* get방식도 vo랑 이름맞춰주면 modelAttribute로 알아서 된다. */
				dataType : "json",
				data : "categoryName=" + name + /* 이꼬르 안넣어서 안됬었므 */
				"&description=" + description,
				success : function(responce) {
					if (response.result != "success") {
						console.error(response.message);
						return;
					}
					console.log("json")
					render(response.data, true);
				}
			})
		})
	});
</script>
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url ="/WEB-INF/views/includes/admin-header.jsp"/>
		</div>
		<div id="wrapper">
			<div id="content" class="full-screen">
				<c:import url ="/WEB-INF/views/includes/admin-navigation.jsp"/>
		      	<table class="admin-cat">
		      		 <tr>
		      			<th>번호</th>
		      			<th>카테고리명</th>
		      			<th>포스트 수</th>
		      			<th>설명</th>
		      			<th>삭제</th>      			
		      		</tr>
		      		
		      		<!-- 여기에 뿌려준다 널어준다 -->
		      		<!-- tbody태그는 본문이 들어가는 행의 묶음이다. -->
		      		<tbody id="table-body">
		      		<!--data-id 이 속성을 사용하면 마크업에서 스크립트로 정보를 전달할 수 있다. 
		      		   어떤 요소든 임의의 속성을 넣을 수 있기 때문에 기존의 복잡한 단계를 거치지 않아도 된다.  -->
		      		
		      		</tbody>
		      		
				 	<%-- <tr>
						<td>3</td>
						<td>미분류</td>
						<td>10</td>
						<td>카테고리를 지정하지 않은 경우</td>
						<td><img src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>
					</tr>  		 --%>	 	  
				</table>
      	
      			<h4 class="n-c">새로운 카테고리 추가</h4>
      		<form id="admin-cat-add" action="" method="post">
		      	<table>
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input type="text" id="cate-title" name="name"></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input type="text" id="cate-description" name="description"></td>
		      		</tr>
		      		<tr>
		      			<td class="s">&nbsp;</td>
		      			<td><input type="submit" value="카테고리 추가"></td>
		      		</tr>      		      		
		      	</table> 
		      </form>
			</div>
		</div>
		<div id="footer">
			<p>
				<strong>${authUser.id}</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>