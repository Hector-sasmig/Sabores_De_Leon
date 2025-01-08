package main.java.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import main.java.modelo.conexion.Conexion;
import main.java.modelo.vo.EmpleadoVO;

public class EmpleadoDAO extends Conexion {

    public ArrayList<EmpleadoVO> getLista() throws Exception {
        ArrayList<EmpleadoVO> empleados = new ArrayList<>();
        try {
            this.abrirConexion();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM EMPLEADO");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                EmpleadoVO empleado = new EmpleadoVO(
                    rs.getString("Nombre"),
                    rs.getString("Apellido"),
                    rs.getString("Dni"),
                    rs.getInt("Telefono"),
                    rs.getString("Correo"),
                    rs.getString("Tipo"),
                    rs.getString("Contrasena")
                );
                empleado.setIdEmpleado(rs.getInt("id"));
                empleados.add(empleado);
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener la lista de empleados: " + e.getMessage(), e);
        } finally {
            this.cerrarConexion();
        }
        return empleados;
    }

    public EmpleadoVO getEmpleado(int id) throws Exception {
        EmpleadoVO empleado = null;
        try {
            this.abrirConexion();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM EMPLEADO WHERE id = ?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                empleado = new EmpleadoVO(
                    rs.getString("Nombre"),
                    rs.getString("Apellido"),
                    rs.getString("Dni"),
                    rs.getInt("Telefono"),
                    rs.getString("Correo"),
                    rs.getString("Tipo"),
                    rs.getString("Contrasena")
                );
                empleado.setIdEmpleado(rs.getInt("id"));
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener el empleado con ID " + id + ": " + e.getMessage(), e);
        } finally {
            this.cerrarConexion();
        }
        return empleado;
    }

    public void add(EmpleadoVO empleado) throws Exception {
        try {
            this.abrirConexion();
            PreparedStatement st = this.getConnection().prepareStatement(
                "INSERT INTO EMPLEADO (Nombre, Apellido, Dni, Telefono, Correo, Tipo, Contrasena) VALUES (?, ?, ?, ?, ?, ?, ?)"
            );
            st.setString(1, empleado.getNombre());
            st.setString(2, empleado.getApellido());
            st.setString(3, empleado.getDni());
            st.setInt(4, empleado.getTelefono());
            st.setString(5, empleado.getCorreo());
            st.setString(6, empleado.getTipo());
            st.setString(7, empleado.getContrasena());

            int rowsAffected = st.executeUpdate();
            if (rowsAffected == 0) {
                throw new Exception("No se pudo insertar el empleado.");
            }
        } catch (Exception e) {
            throw new Exception("Error al insertar el empleado: " + e.getMessage(), e);
        } finally {
            this.cerrarConexion();
        }
    }

    public void update(EmpleadoVO empleadoVO) throws Exception {
        try {
            this.abrirConexion();
            PreparedStatement st = this.getConnection().prepareStatement(
                "UPDATE EMPLEADO SET Nombre = ?, Apellido = ?, Dni = ?, Telefono = ?, Correo = ?, Tipo = ?, Contrasena = ? WHERE id = ?"
            );
            
            st.setString(1, empleadoVO.getNombre());
            st.setString(2, empleadoVO.getApellido());
            st.setString(3, empleadoVO.getDni());
            st.setInt(4, empleadoVO.getTelefono());
            st.setString(5, empleadoVO.getCorreo());
            st.setString(6, empleadoVO.getTipo());
            st.setString(7, empleadoVO.getContrasena());
            st.setInt(8, empleadoVO.getIdEmpleado());

            int rowsAffected = st.executeUpdate();
            if (rowsAffected == 0) {
                throw new Exception("No se pudo actualizar el empleado con id: " + empleadoVO.getIdEmpleado());
            }
       
        } catch (Exception e) {
            throw new Exception("Error al actualizar el empleado con id: " + empleadoVO.getIdEmpleado() + ": " + e.getMessage(), e);
        
        } finally {
            this.cerrarConexion();
        }
    }

    public void delete(int id) throws Exception {
        try {
            this.abrirConexion();
            PreparedStatement st = this.getConnection().prepareStatement("DELETE FROM EMPLEADO WHERE id = ?");
            st.setInt(1, id);

            int rowsAffected = st.executeUpdate();
            if (rowsAffected == 0) {
                throw new Exception("No se pudo eliminar el empleado con id: " + id);
            }
        } catch (Exception e) {
            throw new Exception("Error al eliminar el empleado con id: " + id + ": " + e.getMessage(), e);
        } finally {
            this.cerrarConexion();
        }
    }
}
