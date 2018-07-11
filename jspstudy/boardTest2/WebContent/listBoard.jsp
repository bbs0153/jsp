<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>${title}</h2>
	<hr>
	<table width="80%" border="1" style="border-collapse: collapse;">
		<tr>
			<td>글번호</td>
			<td>글제목</td>
			<td>작성자</td>
			<td>조회수</td>
			<td>등록일</td>
		</tr>
		<c:forEach var="b" items="${list}">
			<tr>
				<td>${b.no }</td>
				<td>
				<c:if test="${b.b_level>0}">
					<c:forEach begin="1" end="${b.b_level}">
            	&nbsp;&nbsp;
            	</c:forEach>
					<img src="re.png">
				</c:if>
				<a href="detailBoard.do?no=${b.no }">${b.title }</a>
				</td>
				<td>${b.writer }</td>
				<td>${b.hit }</td>
				<td>${b.regdate }</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<c:if test="${startPage>1}">
		<a href="listBoard.do?pageNUM=${startPage-1}">[이전]</a>
	</c:if>

	<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<a href="listBoard.do?pageNUM=${i}">${i}</a>&nbsp;
   </c:forEach>

	<c:if test="${endPage<totalPage}">
		<a href="listBoard.do?pageNUM=${endPage+1}">[다음]</a>
	</c:if>

</body>
</html>