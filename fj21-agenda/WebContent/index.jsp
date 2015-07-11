<%@page import="java.util.List"%>
<%@page import="br.com.caelum.jdbc.modelo.Contato"%>
<%@page import="br.com.caelum.jdbc.dao.ContatoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>Projeto fj21-agenda</title>
</head>
<body style="padding:5em; margin-left:500px;">
	<%--Comentario em scriplet --%>
	
	<% String menssagem = "Bem vindo ao curso FJ-21"; %>
	
	<h1><% out.println(menssagem);%></h1>
	<br/>
	
	<% String desenvolvido = "Desenvolvido por "; %>
	
	<h3><%= desenvolvido%> ${param.nome} </h3>
	
	<div>
		<a href="adiciona-contato.html" style="background-color:#e2e2e2; text-decoration:none; color:#00CC00; padding:0.5em; border:1px solid #e2e2e2; border-radius:0.2em;">Adicionar novo contato</a>
	</div>
	<br/><br/>
	<br/><br/>
	<div class="list">
		<% ContatoDao dao = new ContatoDao();
		  List<Contato> contatos = dao.getLista();%>
		<table style="border:1px solid black;">
			<tr >
				<th>Nome</th>
				<th>Email</th>
				<th>Endereço</th>
				<th>Data de nascimento</th>
			</tr>
		 	<%for(Contato c : contatos){ %>
			 <tr>
			 	<br/>
			 	<td><%= c.getNome() %></td>
			 	<td><%= c.getEmail() %></td>
			 	<td><%= c.getEndereco() %></td>
			 	<td><%= c.getDataNascimento().getTime() %></td>
			 </tr>
			  
		  <%} %>
		  </table>
	</div>
</body>
</html>