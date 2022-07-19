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
<a href="/">Inicio</a>
<h1>Pedido em andamento</h1>

<form method="post" action="/cliente/cadastroPedidos">
	<table class="w3-table w3-striped" border="1">	
		<tr><th>Forma de pagamento</th><th>Escolher</th></tr>
		<c:forEach items="${pagamento}" var="item">
			<tr>
				<td>${item.descricao}</td>
				<td><input type = "radio" name = "id" value="${item.id}"/></td>
			</tr>
		</c:forEach>
	</table>
		Observacao: <input type="text" name="observacao"/>	
		<button type = "submit" name = "id2" value="${pedido.prato.id}">Fazer Pedido</button>
	</form>
	
</body>
</html>