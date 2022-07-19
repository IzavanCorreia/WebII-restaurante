<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Cadastro de Cliente</h1>
	<a href="/">Inicio</a>

	<form method="post" action="/cliente/cadastro">
	
		Cpf: <input type="text" name="cpf"/>
		Nome: <input type="text" name="nome"/>
		Telefone: <input type="text" name="telefone"/>
		E-mail: <input type="text" name="email"/>
		Senha: <input type="password" name="senha"/>
		
		<input type = "submit" value="cadastrar"/>
	
	</form>
</body>
</html>