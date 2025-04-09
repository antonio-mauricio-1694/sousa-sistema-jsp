<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sistema sousa</title>
</head>
<body>
	<h1>Seja Bem vindo ao Sistema Sousa</h1>

	<form action="ServletLOgar" method="post">
	<input type="hidden" value="<%= request.getParameter("url")%> " name="url">

		<table>
			<tr>

				<td><label>login</label> <input name="login"></td>

			</tr>
			
			
			<tr>

				<td><label>senha</label> <input name="senha"></td>

			</tr>
			
			<tr>

				<td> <input type="submit" value="enviar"></td>

			</tr>

		</table>

	</form>
	
	<h4>${msg}</h4>


</body>
</html>