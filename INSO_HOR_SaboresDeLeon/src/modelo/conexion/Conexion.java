package modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

	private String dataBaseURL;
	private String driverName;
	private String user;
	private String pass;
	private Connection conexion;

	public Conexion() {
		this.dataBaseURL = "jdbc:mysql://localhost:3310/sabores_de_leon";
		this.driverName = "com.mysql.cj.jdbc.Driver";
		this.user = "root";
		this.pass = "";
	}

	public void abrirConexion() throws Exception {
		try {
			Class.forName(this.driverName);
			this.conexion = DriverManager.getConnection(this.dataBaseURL, this.user, this.pass);
		} catch (Exception e) {
			throw new Exception("Al abrir base de datos " + e.getMessage());
		}
	}

	public void cerrarConexion() throws Exception {
		try {
			this.conexion.close();
		} catch (Exception e) {
			throw new Exception("Al cerrar base de datos " + e.getMessage());
		}
	}
	
	public Connection getConnection() {
		return this.conexion;
	}

}