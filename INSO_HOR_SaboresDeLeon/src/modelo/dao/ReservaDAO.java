package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modelo.conexion.Conexion;
import modelo.vo.ReservaVO;

public class ReservaDAO extends Conexion {

	public ArrayList<ReservaVO> getLista() throws Exception {
		try {
			this.abrirConexion();
			PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM RESERVA");
			ResultSet rs = st.executeQuery();
			ArrayList<ReservaVO> reservas = new ArrayList<ReservaVO>();
			while (rs.next()) {
				ReservaVO reserva = new ReservaVO(rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("dni"), rs.getInt("Telefono"), rs.getString("Correo"), rs.getInt("Comensales"), rs.getString("FechaHora"));
				reserva.setIdReserva(0);
				reservas.add(reserva);
			}
			this.cerrarConexion();
			return reservas;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public ReservaVO getReserva(int id) throws Exception {
		try {
			this.abrirConexion();
			PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM RESERVAS WHERE id=? ");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			ReservaVO reserva=null;
			while (rs.next()) {
				reserva = new ReservaVO(rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("dni"), rs.getInt("Telefono"), rs.getString("Correo"), rs.getInt("Comensales"), rs.getString("FechaHora"));
	
			}
			this.cerrarConexion();
			return reserva;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public void add(ReservaVO reserva) throws Exception {
		try {
			this.abrirConexion();
			PreparedStatement st = this.getConnection().prepareStatement("INSERT INTO RESERVA"+"(Nombre,Apellido,dni,Telefono,Correo,Comensales,FechaHora) VALUES(?,?,?,?,?,?,?)");
			st.setString(1, reserva.getNombre());
			st.setString(2, reserva.getApellido());
			st.setString(3, reserva.getDni());
			st.setInt(4, reserva.getTelefono());
			st.setString(5, reserva.getCorreo());
			st.setInt(6, reserva.getComensales());
			st.setString(7, reserva.getFechaHora());
			if(st.executeUpdate()==0) {
				//Error
			} else {
				this.cerrarConexion();
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public void update(ReservaVO ReservaVO) throws Exception {
		// TODO Auto-generated method stub
		try {
			this.abrirConexion();
			PreparedStatement st = this.getConnection().prepareStatement("UPDATE RESERVA SET nombre=?, apellidos=?, dni=?, telefono=?, correo=?, comensales=?, fechaHora=? WHERE id = ?");
			st.setString(1, ReservaVO.getNombre());
			st.setString(2, ReservaVO.getApellido());
			st.setString(3, ReservaVO.getDni());
			st.setInt(4, ReservaVO.getTelefono());
			st.setString(5, ReservaVO.getCorreo());
			st.setInt(6, ReservaVO.getComensales());
			st.setString(7, ReservaVO.getFechaHora());
			st.executeUpdate();
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
}

