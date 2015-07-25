<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="resources/js/jquery.js"></script>
<script type="text/javascript" src="resources/js/tarefas.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui.js"></script>
<link rel="stylesheet" href="resources/css/jquery.css" type="text/css">
<link rel="stylesheet" href="resources/css/tarefas.css" type="text/css">
<title>Adicionar tarefa</title>
</head>
<body>
	<c:choose>
		<c:when test="${param.st eq 1}">
			<div>
				<p>Adicinado tarefa com sucesso!</p>
			</div>
		</c:when>
		<c:when test="${param.st eq 2}">
			<div>
				<p>Removido tarefa com sucesso!</p>
			</div>
		</c:when>
	</c:choose>
	<h3>Adicionar tarefas</h3>
	<form:errors path="tarefa.descricao" />
	<form action="adicionaTarefa" method="post">
		Descrição: <br />
		<textarea name="descricao" rows="5" cols="100"></textarea>
		<br /> <input type="submit" value="Adicionar">
	</form>
	<br />
	<br />
	<table>
		<tr>
			<th>Id</th>
			<th>Descrição</th>
			<th>Finalizado?</th>
			<th>Data de finalização</th>
			<th>Finalizar</th>
			<th>Alterar</th>
			<th>Remover</th>
		</tr>
		<c:forEach items="${tarefas}" var="tarefa">
			<tr id="tarefa_${tarefa.id}">
				<td>${tarefa.id}</td>
				<td>${tarefa.descricao}</td>
				<c:if test="${tarefa.finalizado eq false}">
					<td>Não finalizado</td>
				</c:if>
				<c:if test="${tarefa.finalizado eq true}">
					<td>Finalizado</td>
				</c:if>
				<td><fmt:formatDate value="${tarefa.dataFinalizacao.time}"
						pattern="dd/MM/yyyy" /></td>
				<td><a href="#" onClick="finalizarTarefa(${tarefa.id})">#</a></td>
				<td><a href="mostraTarefa?id=${tarefa.id}">O</a></td>
				<td><a href="removeTarefa?id=${tarefa.id}">X</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>