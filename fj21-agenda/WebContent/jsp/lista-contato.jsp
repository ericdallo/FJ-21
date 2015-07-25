<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="list">
			<table>  
				<tr >
					<th>Nome</th>
					<th>Email</th>
					<th>Endereço</th>
					<th>Data de nascimento</th>
					<th>Alterar</th>
					<th>X</th>
				</tr>
				
			 	<c:forEach var="con" items="${lista}"> 
				 <tr>
				 	<br/>
				 	<td>${con.nome}</td>
				 	<td>
				 	<c:choose>
					 	<c:when test="${not empty con.email}">
					 		<a href="mailto:${con.email }">${con.email}</a>
					 	</c:when>
					 	<c:otherwise>
					 		E-mail não informado 
					 	</c:otherwise>
				 	</c:choose>
				 	</td>
				 	
				 	<td>${con.endereco}</td>
				 	<td><fmt:formatDate value="${con.dataNascimento.time }" pattern="dd/MM/yyyy"/></td>
				 	<td><a href="jsp/altera-contato.jsp?id=${con.id}">Alterar</a></td>
				 	<td><a href="mvc?logica=ExcluirContato&id=${con.id}" >Excluir</a></td>
				 </tr>
				 
				</c:forEach>
			</table>
		  
	</div>
	<div>
		<a href="home.jsp">Voltar</a>
	</div>
</body>
</html>