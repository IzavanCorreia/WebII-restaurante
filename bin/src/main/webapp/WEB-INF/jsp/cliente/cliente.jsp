<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Cliente de cpf ${cliente.cpf}</h1>
	<a href = "/">home</a><br>
	<a href = "/cliente/list">clientes cadastrados</a><br>
	
	Nome:${cliente.nome}<br>
	Telefone:${cliente.telefone}<br>
	E-mail:${cliente.email}<br>
</body>
</html>