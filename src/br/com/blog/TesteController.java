package br.com.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TesteController 
{
	@RequestMapping("teste")
	public String teste() 
	{
		System.out.println("Teste");
		return "teste";
	}
}
