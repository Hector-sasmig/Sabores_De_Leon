package main.java.modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private String dataBaseURL;
    private String driverName;
    private String user;
    private String pass;
    private Connection conexion;

    public Conexion() {
        // Ajusta el puerto si es necesario, usualmente 3306 es el predeterminado
        this.dataBaseURL = "jdbc:mysql://localhost:3306/sabores_de_leon";  // Cambié el puerto a 3306
        this.driverName = "com.mysql.cj.jdbc.Driver";
        this.user = "root";  // Asegúrate de que el usuario sea correcto
        this.pass = "root";      // Cambia la contraseña si es necesario
    }

    public void abrirConexion() throws Exception {
        try {
            // Cargar el driver de MySQL
            Class.forName(this.driverName);
            this.conexion = DriverManager.getConnection(this.dataBaseURL, this.user, this.pass);

            if (this.conexion != null) {
                System.out.println("Conexión exitosa a la base de datos.");
            }
        } catch (Exception e) {
            throw new Exception("Error al abrir la base de datos: " + e.getMessage());
        }
    }

    public void cerrarConexion() throws Exception {
        try {
            if (this.conexion != null && !this.conexion.isClosed()) {
                this.conexion.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (Exception e) {
            throw new Exception("Error al cerrar la base de datos: " + e.getMessage());
        }
    }

    public Connection getConnection() throws Exception {
        if (this.conexion == null || this.conexion.isClosed()) {
            abrirConexion();
        }
        return this.conexion;
    }
}
