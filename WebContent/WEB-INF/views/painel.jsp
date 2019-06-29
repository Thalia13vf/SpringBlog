<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link type="text/css" href="resources/css/estilo.css" rel="stylesheet"/>
	<link rel="stylesheet" href="resources/css/artigo.css" />
	<script type="text/javascript" src="resources/js/jquery.js"></script>
	<title>Painel</title>
</head>
<body>
	<script>
		function remove(id)
		{
			$.post("remover", {'id': id}, function()
				{
					$("#artigo_"+id).closest("tr").hide();
				})	
		};
	</script>
	<h2>Página Inicial</h2>
	<p>Bem-vindo, ${usuarioLogado.login}</p>
	<p><a href="adicionar">Adicionar Post</a></p>
	<br/>
	<br/>
	<table>
		<tr>
			<th>Id</th>
			<th>Titulo</th>
			<th>Subtitulo</th>
			<th>dataPostagem</th>
			<th>Autor</th>
			<th>Texto</th>
			<th>Imagem</th>
			<th>Categoria</th>
			<th>Alterar</th>
			<th>Deletar</th>
		</tr>
		<c:forEach items="${artigos}" var="artigo">
			<tr id="artigo_${artigo.id}">
				<td>${artigo.id}</td>
				<td>${artigo.titulo}</td>
				<td>${artigo.subtitulo}</td>
				<td>
					<fmt:formatDate value="${artigo.dataPostagem.time}" pattern="dd/MM/yyyy"/>
				</td>
				<td>${artigo.autor}</td>
				<td>${artigo.texto}</td>
				<td>${artigo.imagem}</td>
				<td>${artigo.categoria}</td>
				<td><a href="editar?id=${artigo.id}">Alterar</a></td>
				<td id="artigo_${artigo.id}"><a href="#" onclick="remove(${artigo.id})">Deletar</a></td>
			</tr>
			
		</c:forEach>
	</table>
	<p><a href="logout">Sair do sistema</a></p>
</body>
</html>