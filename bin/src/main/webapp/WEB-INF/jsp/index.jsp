<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>SISTEMA DE PEDIDOS DE RESTAURANTE</h1>

	<a href="/cliente/telaCadastro" class="w3-btn w3-black">Cadastrar um cliente</a><br>
	<a href="/cliente/telaLogin" class="w3-btn w3-black">Fazer Login como cliente</a><br>
	
	<a href="/adm/telaCadastro" class="w3-btn w3-black">Cadastrar um administrador</a><br>
	<a href="/adm/telaLogin" class="w3-btn w3-black">Fazer Login como administrador</a><br>
	
	<h2>${msg}</h2>
	
</body>
</html>