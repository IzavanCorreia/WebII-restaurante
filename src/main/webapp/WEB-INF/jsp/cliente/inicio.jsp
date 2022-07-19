<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${msg2}</h1>
<a href = "/">home</a>
<h1>Menu do restaurante</h1>
	<h1>Pratos cadastrados</h1>

<form method="post" action="/cliente/pedidohelp">
	<table class="w3-table w3-striped" border="1">
		
		<tr><th>Nome</th><th>Descricao</th><th>preco</th><th>operacoes<th></tr>
	
		<c:forEach items="${prato}" var="item">
			<tr>
				<td>${item.nome}</td>
				<td>${item.descricao}</td>
				<td>${item.preco}</td>
				<td><input type = "submit" name ="id" value = "${item.id}"/></td>
				
			</tr>
		</c:forEach>
		
	</table>
</form>
	
<a href = "/cliente/visualizarPedidos"><input type = "submit" value= "Meus Pedidos"/></a>
	
</body>
</html>