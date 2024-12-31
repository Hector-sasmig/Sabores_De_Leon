package main.java.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import main.java.modelo.conexion.Conexion;
import main.java.modelo.vo.ReservaVO;

public class ReservaDAO extends Conexion {

    public ArrayList<ReservaVO> getLista() throws Exception {
        ArrayList<ReservaVO> reservas = new ArrayList<ReservaVO>();
        try {
            this.abrirConexion();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM RESERVA");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ReservaVO reserva = new ReservaVO(
                    rs.getString("Nombre"), 
                    rs.getString("Apellido"), 
                    rs.getString("dni"), 
                    rs.getInt("Telefono"), 
                    rs.getString("Correo"), 
                    rs.getInt("Comensales"), 
                    rs.getString("FechaHora")
                );
                reserva.setIdReserva(rs.getInt("id"));  // Asignar el id correcto
                reservas.add(reserva);
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener la lista de reservas: " + e.getMessage(), e);
        } finally {
            this.cerrarConexion();
        }
        return reservas;
    }

    public ReservaVO getReserva(int id) throws Exception {
        ReservaVO reserva = null;
        try {
            this.abrirConexion();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM RESERVA WHERE id = ?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                reserva = new ReservaVO(
                    rs.getString("Nombre"), 
                    rs.getString("Apellido"), 
                    rs.getString("dni"), 
                    rs.getInt("Telefono"), 
                    rs.getString("Correo"), 
                    rs.getInt("Comensales"), 
                    rs.getString("FechaHora")
                );
                reserva.setIdReserva(rs.getInt("id"));
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener la reserva con id " + id + ": " + e.getMessage(), e);
        } finally {
            this.cerrarConexion();
        }
        return reserva;
    }

    public void add(ReservaVO reserva) throws Exception {
        try {
            this.abrirConexion();
            PreparedStatement st = this.getConnection().prepareStatement(
                "INSERT INTO RESERVA (Nombre, Apellido, dni, Telefono, Correo, Comensales, FechaHora) VALUES (?, ?, ?, ?, ?, ?, ?)"
            );
            st.setString(1, reserva.getNombre());
            st.setString(2, reserva.getApellido());
            st.setString(3, reserva.getDni());
            st.setInt(4, reserva.getTelefono());
            st.setString(5, reserva.getCorreo());
            st.setInt(6, reserva.getComensales());
            st.setString(7, reserva.getFechaHora());

            int rowsAffected = st.executeUpdate();
            if (rowsAffected == 0) {
                throw new Exception("No se pudo insertar la reserva.");
            }
        } catch (Exception e) {
            throw new Exception("Error al insertar la reserva: " + e.getMessage(), e);
        } finally {
            this.cerrarConexion();
        }
    }

    public void update(ReservaVO reservaVO) throws Exception {
        try {
            this.abrirConexion();
            PreparedStatement st = this.getConnection().prepareStatement(
                "UPDATE RESERVA SET Nombre = ?, Apellido = ?, dni = ?, Telefono = ?, Correo = ?, Comensales = ?, FechaHora = ? WHERE id = ?"
            );
            st.setString(1, reservaVO.getNombre());
            st.setString(2, reservaVO.getApellido());
            st.setString(3, reservaVO.getDni());
            st.setInt(4, reservaVO.getTelefono());
            st.setString(5, reservaVO.getCorreo());
            st.setInt(6, reservaVO.getComensales());
            st.setString(7, reservaVO.getFechaHora());
            st.setInt(8, reservaVO.getIdReserva());

            int rowsAffected = st.executeUpdate();
            if (rowsAffected == 0) {
                throw new Exception("No se pudo actualizar la reserva con id: " + reservaVO.getIdReserva());
            }
        } catch (Exception e) {
            throw new Exception("Error al actualizar la reserva con id: " + reservaVO.getIdReserva() + ": " + e.getMessage(), e);
        } finally {
            this.cerrarConexion();
        }
    }
    
    public void delete(int id) throws Exception {
        try {
            this.abrirConexion();
            PreparedStatement st = this.getConnection().prepareStatement("DELETE FROM RESERVA WHERE id = ?");
            st.setInt(1, id);

            int rowsAffected = st.executeUpdate();
            if (rowsAffected == 0) {
                throw new Exception("No se pudo eliminar la reserva con id: " + id);
            }
        } catch (Exception e) {
            throw new Exception("Error al eliminar la reserva con id: " + id + ": " + e.getMessage(), e);
        } finally {
            this.cerrarConexion();
        }
    }
}
