package br.com.caelum.blog.model;

import java.util.Calendar;
import org.springframework.format.annotation.DateTimeFormat;

public class Artigo 
{
	private Long id;
	private String titulo;
	private String subtitulo;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataPostagem;
	private String autor;
	private String texto;
	private String imagem;
	private String categoria;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSubtitulo() {
		return subtitulo;
	}
	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}
	public Calendar getDataPostagem() {
		return dataPostagem;
	}
	public void setDataPostagem(Calendar dataPostagem) {
		this.dataPostagem = dataPostagem;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
}
