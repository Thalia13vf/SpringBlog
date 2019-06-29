package br.com.caelum.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.blog.dao.JdbcUsuarioDao;
import br.com.caelum.blog.model.Usuario;

@Controller
public class LoginController 
{
	private JdbcUsuarioDao dao;
	
	@Autowired
	public LoginController(JdbcUsuarioDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("loginForm")
	public String paginaLogin() {
		return "formulario-login";
	}
	@RequestMapping("efetuaLogin")
	public String logar(Usuario usuario, HttpSession sessao) {
		if(dao.existeUsuario(usuario)) {
			sessao.setAttribute("usuarioLogado", usuario);
			return "redirect:painel";
		}
		return "redirect:loginForm";
	}
	@RequestMapping("logout")
	public String logout(HttpSession sessao) {
		sessao.invalidate();
		return "redirect:loginForm";
	}

}
