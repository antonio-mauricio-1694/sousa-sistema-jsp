<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%out.print("meu sucesso garantido");

String nome = request.getParameter("nome");
out.print("nome" + nome);

String idade = request.getParameter("idade");
out.print("idade" + idade);
%>
</body>
</html>