
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>Projeto fj21-agenda</title>
</head>
<body>
	<c:import url="jsp/cabecalho.jsp"/>
	
	<% String menssagem = "Bem vindo ao curso FJ-21"; %>
	
	<h1><% out.println(menssagem);%></h1>
	<br/>
	
	<% String desenvolvido = "Desenvolvido por "; %>
	<c:choose>
		<c:when test="${empty param.nome }">
			<h3><%= desenvolvido%> Eric Dallo </h3>	
		</c:when>
		<c:otherwise>
			<h3><%= desenvolvido%> ${param.nome} </h3>
		</c:otherwise>
		
	</c:choose>
	
	<div>
		<a href="jsp/adiciona-contato.jsp" style="background-color:#e2e2e2; text-decoration:none; color:#00CC00; padding:0.5em; border:1px solid #e2e2e2; border-radius:0.2em;">Adicionar novo contato</a>
	</div>
	<br/><br/>
	<div>
		<a href="mvc?logica=ListaContato" style="background-color:#e2e2e2; text-decoration:none; color:#0000CC; padding:0.5em; border:1px solid #e2e2e2; border-radius:0.2em;">Lista de contatos</a>
	</div>
	<c:import url="jsp/rodape.jsp"/>
</body>
</html>