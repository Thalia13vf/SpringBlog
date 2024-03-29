package br.com.blog.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.blog.model.Usuario;

@Repository
public class JdbcUsuarioDao 
{	
	private Connection connection;
	
	@Autowired
	public JdbcUsuarioDao(DataSource dataSource) 
	{
		try 
		{
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public boolean existeUsuario(Usuario usuario) 
	{
		if(usuario == null) {
			throw new IllegalArgumentException("Usu�rio n�o deve ser nulo");
		}
		String sql = "select * from usuarios where login = ? and senha = ?";
		try {
			PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			
			ResultSet rs = stmt.executeQuery();
			boolean encontrado = rs.next();
			rs.close();
			stmt.close();
			return encontrado;
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
