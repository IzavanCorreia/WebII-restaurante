<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Cadastro de formas de pagamento</h1>
	<a href="/">Inicio</a>

	<form method="post" action="/adm/cadPagamentos">
		Opcao de pagamento: <input type="text" name="id"/>
		Descricao: <input type="text" name="descricao"/>
		
		<input type = "submit" value="cadastrar"/>
	
	</form>

</body>
</html>