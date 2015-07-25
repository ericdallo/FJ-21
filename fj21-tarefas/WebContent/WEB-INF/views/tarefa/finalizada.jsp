<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<td>${tarefa.id}</td>
<td>${tarefa.descricao}</td>
<td>Finalizada</td>
<td><fmt:formatDate value="${tarefa.dataFinalizacao.time}"
    pattern="dd/MM/yyyy" /></td>
<td><a href="mostraTarefa?id=${tarefa.id}">#</a></td>
<td><a href="mostraTarefa?id=${tarefa.id}">O</a></td>
<td><a href="removeTarefa?id=${tarefa.id}">X</a></td>