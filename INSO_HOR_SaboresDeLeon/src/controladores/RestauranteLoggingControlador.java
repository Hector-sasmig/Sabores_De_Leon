package controladores;

import java.util.ArrayList;

import modelo.dao.EmpleadoDAO;
import modelo.vo.EmpleadoVO;

public class RestauranteLoggingControlador {

	private ArrayList<EmpleadoVO> empleados;
	
	public RestauranteLoggingControlador() {
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();
		try {
			this.empleados= empleadoDAO.getLista();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public String login(String user, String password) {
		for(EmpleadoVO empleado: this.empleados) {
			if(empleado.getDni().equals(user) && empleado.getContrasena().equals(password)) {
				return empleado.getTipo();
			}
		}
		return null;
	}	
}
