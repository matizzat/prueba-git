
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {
    
    // Atributos
    
    private static BaseDatos INSTANCIA = null;		// SINGLETON
	private static Connection con;
    private static String usuario;
    private static String password;
    private static String url;
    
    // Constructor privado
    
    private BaseDatos(String usuario, String password, String baseDatos, String ip, String puerto) {
        
		this.usuario = usuario;
		this.password = password;
		this.url = "jdbc:postgresql://"+ip+":"+puerto+"/"+baseDatos;
    }
	
	public BaseDatos getInstance() {
		
		if (INSTANCIA == null) {
			INSTANCIA = new BaseDatos("postgres", "tomitomi123", "postgres", "localhost", "5432");
		}
		return INSTANCIA;
	}
    
    // Otros métodos
    
    public Connection establecerConexion() {
        
		if (con==null) {
			try {
				Class.forName("org.postgresql.Driver");
				con = DriverManager.getConnection(url, usuario, password);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace(System.out);
			}
		}
		return con;
    }
    
}
