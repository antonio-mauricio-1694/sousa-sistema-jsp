package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.SingleConnectionBanco;
import model.ModelLogin;

public class DaoLoginRepository {
	
	private Connection connection;
	
	public DaoLoginRepository() {
		connection = SingleConnectionBanco.getConnection();
	}
	
	public boolean validarAutenticacao(ModelLogin modelLogin) throws SQLException {
		
		String sql = "select * from model_login where login = ? and senha = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, modelLogin.getLogin());
		statement.setString(2, modelLogin.getSenha());
		

		ResultSet resultSet = statement.executeQuery();
		
		if(resultSet.next()) {
			return true;
		}
		
		return false;
		
		
		
	}

}
