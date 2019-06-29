package br.com.blog.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.blog.model.Artigo;

@Repository
public class JdbcArtigoDao 
{
	private final Connection connection;
	
	@Autowired
	public JdbcArtigoDao(DataSource dataSource) 
	{
		try {
			this.connection = dataSource.getConnection();
		}
		catch(SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
	public void adiciona(Artigo artigo) 
	{
		String sql = "insert into blog_posts(titulo, subtitulo, dataPostagem, autor, texto, imagem, categoria) "
				+ "values(?,?,?,?,?,?,?)";
		PreparedStatement stmt;
		try {
			stmt= connection.prepareStatement(sql);
			stmt.setString(1, artigo.getTitulo());
			stmt.setString(2, artigo.getSubtitulo());
			stmt.setDate(3, new Date(
					artigo.getDataPostagem().getTimeInMillis()));
			stmt.setString(4, artigo.getAutor());
			stmt.setString(5, artigo.getTexto());
			stmt.setString(6, artigo.getImagem());
			stmt.setString(7, artigo.getCategoria());
			stmt.execute();
		} catch(SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public void altera(Artigo artigo) 
	{
		try 
		{
			String sql = "update blog_posts set titulo = ?, subtitulo = ?,dataPostagem = ?, "
					+ "autor=?, texto=?, imagem=?, categoria=? where id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, artigo.getTitulo());
			stmt.setString(2, artigo.getSubtitulo());
			stmt.setDate(3, new Date(
					artigo.getDataPostagem().getTimeInMillis()));
			stmt.setString(4, artigo.getAutor());
			stmt.setString(5, artigo.getTexto());
			stmt.setString(6, artigo.getImagem());
			stmt.setString(7, artigo.getCategoria());
			stmt.setLong(8, artigo.getId());
			stmt.execute();
			stmt.close();
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Artigo> listaArtigos()
	{
		try
		{
			List<Artigo> artigos = new ArrayList<>();
			String sql = "select * from blog_posts";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		
			while(rs.next()) 
			{
				artigos.add(populaArtigo(rs));
			}
			rs.close();
			stmt.close();
			return artigos;
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
	}
	public Artigo buscaPorId(Long id)
	{
		try 
		{
			String sql = "select * from blog_posts where id = ?";
			PreparedStatement stmt;
			stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) 
			{
				return populaArtigo(rs);
			}
			stmt.close();
			rs.close();
			return null;
		}
		catch(SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public Artigo populaArtigo(ResultSet rs) 
	{
		Artigo artigo = new Artigo();
		try {
				artigo.setId(rs.getLong("id"));
				artigo.setTitulo(rs.getString("titulo"));
				artigo.setSubtitulo(rs.getString("subtitulo"));
				Date data = rs.getDate("dataPostagem");
				Calendar dataPostagem = Calendar.getInstance();
				dataPostagem.setTime(data);
				artigo.setDataPostagem(dataPostagem);
				artigo.setAutor(rs.getString("autor"));
				artigo.setTexto(rs.getString("texto"));
				artigo.setImagem(rs.getString("imagem"));
				artigo.setCategoria(rs.getString("categoria"));
				return artigo;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}
	public void remove(Artigo artigo) {
		try 
		{
			String sql = "delete from blog_posts where id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, artigo.getId());
			stmt.execute();
			stmt.close();			
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
