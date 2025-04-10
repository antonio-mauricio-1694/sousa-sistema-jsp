<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tela de Erros</title>
</head>
<body>
<h1>Erro no Sistema,Entre em contato com o Suporte do Sistema</h1>

<%
out.print(request.getAttribute("msg"));
%>
</body>
</html>