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
<h1>Seus pedidos</h1>
<h1>${msg6}</h1>

<table class="w3-table w3-striped" border="1">
		
		<tr><th>Prato</th><th>Pagamento</th><th>Observacao</th></tr>
	
		<c:forEach items="${pedido}" var="item">
			<tr>
				<td>${item.prato.nome}</td>
				<td>${item.pagamento.descricao}</td>
				<td>${item.observacao}</td>
			</tr>
		</c:forEach>
		
	</table>
	
</body>
</html>