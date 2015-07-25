function finalizarTarefa(id) {
	$.post("finalizaTarefa", {'id' : id}, function(resposta) {
		$("#tarefa_"+id).html(resposta);
	});
}