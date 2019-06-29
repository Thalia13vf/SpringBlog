<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adicionar Post</title>
</head>
<body>
	<form method="post" action="AdicionarArtigo">
		<p>Titulo: </p><input type="text" name="titulo"/>
		<p>Subtitulo: </p> <input type="text" name="subtitulo"/>
		<p>Data de Postagem: </p> <input type="text" name="dataPostagem"/>
		<p>Autor: </p> <input type="text" name="autor"/>
		<p>Texto: </p> <textarea rows="20" cols="30" name="texto"></textarea>
		<p>Imagem </p>  <input type="file" name="imagem" accept="image/png, image/jpeg" />
		<p>Categoria: </p> <input type="text" name="categoria" />
		
		<input type="submit" value="Adicionar"/>
	</form>
</body>
</html>