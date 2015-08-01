<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login - Tarefas</title>
<link rel="stylesheet" href="resources/css/jquery.css" type="text/css">
<link rel="stylesheet" href="resources/css/index.css" type="text/css">
</head>
<body>

	<div class="box">
		<h1>Login - Tarefas</h1>
		<form action="login" method="POST" class="login_form">
			<input type="text" placeholder="Usuário" class="email" name="login"/>
			<input type="password" placeholder="Senha" class="senha" name="senha"/>
			<input type="submit" value="Login" class="bt_login"/>
		</form>
	</div>
</body>
</html>