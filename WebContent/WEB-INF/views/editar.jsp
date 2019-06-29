<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="alterarArtigo">
		<input type="hidden" name="id" value="${artigo.id}"/>
		<p>Titulo: </p><input type="text" name="titulo" value="${artigo.titulo}"/>
		<p>Subtitulo: </p> <input type="text" name="subtitulo" value="${artigo.subtitulo}"/>
		
		<p>Data de Postagem: </p> <input type="text" name="dataPostagem" value="<fmt:formatDate value = "${artigo.dataPostagem.time}" 
		pattern = "dd/MM/yyyy"/>"/>
		<p>Autor: </p> <input type="text" name="autor" value="${artigo.autor}"/>
		<p>Texto: </p> <textarea rows="20" cols="30" name="texto">${artigo.texto}</textarea>
		<p>Imagem </p>  <input type="file" name="imagem" accept="image/png, image/jpeg" />
		<p>Categoria: </p> <input type="text" name="categoria" value="${artigo.categoria}"/>
		
		<input type="submit" value="Editar"/>
	</form>
</body>
</html>