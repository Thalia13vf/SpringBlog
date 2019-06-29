<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8"/>
		<title>História do HTML</title>
		<link rel="stylesheet" href="resources/css/estilo.css" />
		<link rel="stylesheet" href="resources/css/artigo.css" />
	</head>
	<body>
		<div id="pagina">
			<nav id="menu">
				<a href="blog"><img id="logo"src="resources/img/code.gif" /></a>
				<ul>
					<li><a href="#">Front-End</a></li>
					<li><a href="#">Back-End</a></li>
					<li><a href="#">Mobile</a></li>
					<li><a href="#">Data Science</a></li>
				</ul>
			</nav>
			<section id="corpo-artigo">
				<article id="artigo">
					<header id="cabecalho-artigo">
						<img src="resources/img/${artigo.imagem}" alt="" />
						<h1 class="titulo-artigo">${artigo.titulo}</h1>
						<h2 class="autor">${artigo.autor}</h2>
					</header>
					
					<p>${artigo.texto}</p>
				
					<p>Postado em: <fmt:formatDate	value="${artigo.dataPostagem.time}"
					pattern="dd/MM/yyyy" />
					</p>
				</article>
			</section>


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
				<p>Copyright &copy; 2019</p>
			</footer>
		</div>		
	</body>
</html>