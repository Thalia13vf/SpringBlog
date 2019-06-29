package br.com.blog.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.blog.dao.JdbcArtigoDao;
import br.com.blog.model.Artigo;

@Controller
public class BlogController 
{
	private final JdbcArtigoDao dao;
	
	@Autowired
	public BlogController(JdbcArtigoDao dao) 
	{
		this.dao = dao;
	}

	@RequestMapping("adicionar")
	public String adicionar() {
		return "adicionar-artigo";
	}
	
	@RequestMapping("AdicionarArtigo")
	public String adicionarArtigo(Artigo artigo) 
	{
		dao.adiciona(artigo);
		return "adicionado";
	}
	@RequestMapping("/")
	public String lista(Model model) 
	{
		model.addAttribute("artigos", dao.listaArtigos());
		return "index";
	}
	@RequestMapping("mostraArtigo")
	public String mostraArtigo(Long id,Model model) 
	{
		model.addAttribute("artigo",dao.buscaPorId(id));
		return "artigo";
	}
	@RequestMapping("painel")
	public String painel(Model model) 
	{
		model.addAttribute("artigos", dao.listaArtigos());
		return "painel";
	}
	@RequestMapping("editar")
	public String editar(Long id, Model model) 
	{
		model.addAttribute("artigo", dao.buscaPorId(id));
		return "editar";
	}
	@RequestMapping("alterarArtigo")
	public String alterar(Artigo artigo) 
	{
		dao.altera(artigo);
		return "redirect:painel";
	}
	@RequestMapping("remover")
	public void remover(Long id, HttpServletResponse response ) 
	{
		Artigo artigo = new Artigo();
		artigo.setId(id);
		dao.remove(artigo);
		response.setStatus(200);
	}
}
