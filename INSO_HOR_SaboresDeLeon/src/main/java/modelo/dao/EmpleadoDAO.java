package main.java.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import main.java.modelo.conexion.Conexion;
import main.java.modelo.vo.EmpleadoVO;

public class EmpleadoDAO extends Conexion {

    public ArrayList<EmpleadoVO> getLista() throws Exception {
        ArrayList<EmpleadoVO> empleados = new ArrayList<>();
        String query = "SELECT * FROM empleado";

        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            this.abrirConexion();
            conn = this.getConnection();
            st = conn.prepareStatement(query);
            rs = st.executeQuery();

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
            throw new Exception("Error al obtener la lista de empleados: " + e.getMessage());
        } finally {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (conn != null) this.cerrarConexion();
        }
        return empleados;
    }

    public EmpleadoVO getEmpleado(int id) throws Exception {
        EmpleadoVO empleado = null;
        String query = "SELECT * FROM empleado WHERE id = ?";

        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            this.abrirConexion();
            conn = this.getConnection();
            st = conn.prepareStatement(query);
            st.setInt(1, id);
            rs = st.executeQuery();

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
            throw new Exception("Error al obtener el empleado con ID " + id + ": " + e.getMessage());
        } finally {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (conn != null) this.cerrarConexion();
        }
        return empleado;
    }

    public void add(EmpleadoVO empleado) throws Exception {
        String query = "INSERT INTO empleado (nombre, apellido, dni, telefono, correo, tipo, contrasena) VALUES (?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement st = null;

        try {
            this.abrirConexion();
            conn = this.getConnection();
            st = conn.prepareStatement(query);
            st.setString(1, empleado.getNombre());
            st.setString(2, empleado.getApellido());
            st.setString(3, empleado.getDni());
            st.setInt(4, empleado.getTelefono());
            st.setString(5, empleado.getCorreo());
            st.setString(6, empleado.getTipo());
            st.setString(7, empleado.getContrasena());
            st.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al añadir el empleado: " + e.getMessage());
        } finally {
            if (st != null) st.close();
            if (conn != null) this.cerrarConexion();
        }
    }

    public void update(EmpleadoVO empleadoVO) throws Exception {
        String query = "UPDATE empleado SET nombre = ?, apellido = ?, dni = ?, telefono = ?, correo = ?, tipo = ?, contrasena = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement st = null;

        try {
            this.abrirConexion();
            conn = this.getConnection();
            st = conn.prepareStatement(query);
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
            throw new Exception("Error al actualizar el empleado: " + e.getMessage());
        } finally {
            if (st != null) st.close();
            if (conn != null) this.cerrarConexion();
        }
    }
}
