package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionBanco {
	
	private static String banco = "jdbc:postgresql://localhost:5432/sousadb?autoReconnect=true";
	private static String user = "postgres";
	private static String senha = "isluc";
	private static Connection connection = null;
	
	public static Connection getConnection() {
		return connection;
	}
	
	
	public SingleConnectionBanco() {
		conectar();
	}
	
	static {
		conectar();
	}
	
	private static void conectar() {
		
		try {
			
			
			if(connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(banco, user,senha);
				connection.setAutoCommit(false);// para não fazer altetrações no banco sem meu comando
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
