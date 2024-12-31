package main.java.controladores;

import java.util.ArrayList;

import main.java.modelo.dao.EmpleadoDAO;
import main.java.modelo.vo.EmpleadoVO;

public class RestauranteLoggingControlador {

    private ArrayList<EmpleadoVO> empleados;

    public RestauranteLoggingControlador() {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        try {
            this.empleados = empleadoDAO.getLista();
            if (this.empleados == null || this.empleados.isEmpty()) {
                System.out.println("Advertencia: No se encontraron empleados en la base de datos.");
                this.empleados = new ArrayList<>(); // Evita `null`
            }
        } catch (Exception e) {
            System.err.println("Error al cargar los empleados: " + e.getMessage());
            this.empleados = new ArrayList<>(); // Inicializa como lista vacía
        }
    }

    public String login(String user, String password) {
        if (this.empleados == null || this.empleados.isEmpty()) {
            System.out.println("No hay empleados cargados para realizar el login.");
            return null;
        }

        for (EmpleadoVO empleado : this.empleados) {
            if (empleado.getDni().equals(user) && empleado.getContrasena().equals(password)) {
                System.out.println("Login exitoso para usuario: " + user);
                return empleado.getTipo(); // Devuelve "Gerente" o "Empleado"
            }
        }

        System.out.println("Credenciales incorrectas para usuario: " + user);
        return null;
    }
}
