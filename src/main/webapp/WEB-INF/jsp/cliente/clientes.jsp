<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Clientes cadastrados</h1>
	<a href = "/">home</a>
	
	<table border="1">
		
		<tr><th>Nome</th><th>Telefone</th><th>E-mail</th><th>operacoes<th></tr>
	
		<c:forEach items="${clientes}" var="item">
			<tr>
				<td>${item.nome}</td>
				<td>${item.telefone}</td>
				<td>${item.email}</td>
				<td><a href="/cliente/visualiza/${item.cpf}">visualizar</a></td>
			</tr>
		</c:forEach>
		
	</table>

</body>
</html>