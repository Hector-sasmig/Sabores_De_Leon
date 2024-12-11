package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modelo.conexion.Conexion;
import modelo.vo.EmpleadoVO;

public class EmpleadoDAO extends Conexion{

	public ArrayList<EmpleadoVO> getLista() throws Exception {
		try {
			this.abrirConexion();
			PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM EMPLEADO");
			ResultSet rs = st.executeQuery();
			ArrayList<EmpleadoVO> empleados = new ArrayList<EmpleadoVO>();
			while (rs.next()) {
				EmpleadoVO empleado = new EmpleadoVO(rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("Dni"), rs.getInt("Telefono"), rs.getString("Correo"), rs.getString("Tipo"), rs.getString("Contrasena"));
				empleado.setIdEmpleado(rs.getInt("id"));;
				empleados.add(empleado);
			}
			this.cerrarConexion();
			return empleados;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public EmpleadoVO getEmpleado(int id) throws Exception {
 		try {
 			this.abrirConexion();
 			PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM EMPLEADO WHERE id=? ");
 			st.setInt(1, id);
 			ResultSet rs = st.executeQuery();
 			EmpleadoVO empleado = null;
 			
 			while (rs.next()) {
 				empleado= new EmpleadoVO(rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("Dni"), rs.getInt("Telefono"), rs.getString("Correo"), rs.getString("Tipo"), rs.getString("Contrasena"));
 			}
 			
 			this.cerrarConexion();
 			return empleado;
 		} catch (Exception e) {
 			throw new Exception(e);
 		}
 	}
	
	public void add(EmpleadoVO empleado) throws Exception {
		try {
			this.abrirConexion();
			PreparedStatement st = this.getConnection().prepareStatement("INSERT INTO EMPLEADO"+"(nombre,apellido,dni,telefono,correo,tipo,contrasena) VALUES(?,?,?,?,?,?,?)");
			st.setString(1, empleado.getNombre());
			st.setString(2, empleado.getApellido());
			st.setString(3, empleado.getDni());
			st.setInt(4, empleado.getTelefono());
			st.setString(5, empleado.getCorreo());
			st.setString(6, empleado.getTipo());
			st.setString(7, empleado.getContrasena());
			if(st.executeUpdate()==0) {
				//Error
			} else {
				this.cerrarConexion();
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public void update(EmpleadoVO empleadoVO) throws Exception {
		// TODO Auto-generated method stub
		try {
			this.abrirConexion();
			PreparedStatement st = this.getConnection().prepareStatement("UPDATE EMPLEADO SET nombre = ?, apellido = ?, dni = ?, telefono = ?, correo = ?, tipo = ?, contrasena = ? WHERE id = ?");
			st.setString(1, empleadoVO.getNombre());
			st.setString(2, empleadoVO.getApellido());
			st.setString(3, empleadoVO.getDni());
			st.setInt(4, empleadoVO.getTelefono());
			st.setString(5, empleadoVO.getCorreo());
			st.setString(6, empleadoVO.getTipo());
			st.setString(7, empleadoVO.getContrasena());
			st.setInt(8, empleadoVO.getIdEmpleado());
			st.executeUpdate();
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
}
