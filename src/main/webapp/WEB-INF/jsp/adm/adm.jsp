<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Administrador de cpf ${adm.cpf}</h1>
	<a href = "/">home</a><br>
	<a href = "/adm/telaAdms">administradores cadastrados</a><br>
	
	Nome:${adm.nome}<br>
	Telefone:${adm.telefone}<br>
	E-mail:${adm.email}<br>
</body>
</html>