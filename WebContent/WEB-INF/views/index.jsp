<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Tudo sobre programação de computadores</title>
	<link rel="stylesheet" type="text/css" href="resources/css/estilo.css"/>
</head>
<body>
	<div id="pagina">
			<nav id="menu">
				<a href="views/index.html"><img id="logo"src="resources/img/code.gif" /></a>
				<ul>
					<li><a href="#">Front-End</a></li>
					<li><a href="#">Back-End</a></li>
					<li><a href="#">Mobile</a></li>
					<li><a href="#">Data Science</a></li>
				</ul>
			</nav>
		<c:forEach items="${artigos}" var="artigo">
			<section id="corpo">
				<article id="artigo">
					<header id="cabecalho-artigo">
						<a href="views/html.html"><img src="resources/img/html5-2.jpg" /></a>
						<h1 class="titulo-artigo">${artigo.titulo}</h1>
					</header>
					<p>
						${artigo.texto}
					</p>
					<p class="ler"><a class="ler" href="mostraArtigo?id=${artigo.id}">Continue Lendo ...</a></p>
				</article>
			</section>
		</c:forEach>
			<aside id="lateral">
				<div id="news">
					<h2>Receba os principais posts direto no seu Email. Increva-se e fique por dentro de todos os assustos!</h2>
						<form id="formulario" method="post" name="noticias" action="">
							<p><label for="cNome">Nome</label><input type="text" name="tNome" id="cNome" size="20" maxlength="50" placeholder="Nome" /></p>
							<p><label for="cEmail">Email</label><input type="text" name="tEmail" id="cEmail" size="20" maxlength="30" placeholder="Email" /></p>
							<input type="submit" name="bReceber" id="botao" value="Receber Conteúdos" />
						</form>
					</div>

				<nav id="recentes">	
					<h1>Posts Recentes</h1>
					<ul>
						<li><a href="html.html">História do HTML</a></li>
						<li><a href="#">História do CSS</a></li>
						<li><a href="#">História do JavaScript</a></li>
						<li><a href="#">Hello World em Java </a></li>
						<li><a href="#">Conheça o Spring Framework</a></li>
					</ul>
				</nav>	
			</aside>

			<footer id="rodape">
				<p>Copyright &copy; 2018</p>
			</footer>	
		</div>
</body>
</html>