<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Administradores cadastrados</h1>
	<a href = "/">home</a>
	
	<table border="1">
		
		<tr><th>Nome</th><th>Telefone</th><th>E-mail</th><th>operacoes<th></tr>
	
		<c:forEach items="${adm}" var="item">
			<tr>
				<td>${item.nome}</td>
				<td>${item.telefone}</td>
				<td>${item.email}</td>
				<td><a href="/adm/visualiza/${item.cpf}">visualizar</a></td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>