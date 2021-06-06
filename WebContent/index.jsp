<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="index.do" method="post">
		I	   D:<input type="text" name="id"/><br>
		Password:<input type="password" name="pwd"/><br>
		<input type="radio" name="radio" value="prof">Professor
		<input type="radio" name="radio" value="student">Student<br>
		<input type="submit" value="Login">
	</form>	
</body>
</html>
