<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="insertGoodsOk.do" method="post" enctype="multipart/form-data">
상품번호:<input type="number" name="no"><br>
상품명:<input type="text" name="item"><br>
가격:<input type="number" name="price"><br>
수량:<input type="number" name="qty"><br>
이미지:<input type="file" name="fname"><br>

<input type="submit" value="추가">
<input type="reset" value="취소">
</form>

</body>
</html>