<%@ taglib tagdir="/WEB-INF/tags/" prefix="caelum" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="../js/jquery.js" ></script>
<script type="text/javascript" src="../js/jquery-ui.js" ></script>
<meta charset="UTF-8">
<title>Adicionar Contato</title>
</head>
<body>
	<h1>Adicionar Contato</h1>
	<form action="../mvc?logica=ReplaceContato" method="POST">
		<label for="nome" >Nome: </label>
		<input type="text" name="nome" />
		<br/>
		<label>Email: </label>
		<input type="text" name="email" />
		<br/>
		<label>Endereco: </label>
		<input type="text" name="endereco" />
		<br/>
		<caelum:campodata label="Data de Nascimento" name="dataNascimento"/>
		<br/><br/>
		<input type="submit" value="Adicionar"/>
	</form>
</body>
</html>