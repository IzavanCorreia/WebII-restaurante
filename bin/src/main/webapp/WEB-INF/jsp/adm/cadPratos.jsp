<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Cadastro de pratos</h1>
	<a href="/">Inicio</a>

	<form method="post" action="/adm/cadPratos">
	
		Numero do prato: <input type="text" name="id"/>
		Nome: <input type="text" name="nome"/>
		Descricao: <input type="text" name="descricao"/>
		Preco: <input type="text" name="preco"/>
		
		<input type = "submit" value="cadastrar"/>
	
	</form>
</body>
</html>