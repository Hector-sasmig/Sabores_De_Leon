package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modelo.conexion.Conexion;
import modelo.vo.LineaGestionVO;

public class LineaGestionDAO extends Conexion{

	public ArrayList<LineaGestionVO> getLista() throws Exception {
		try {
			this.abrirConexion();
			PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM LINEA_GESTION");
			ResultSet rs = st.executeQuery();
			ArrayList<LineaGestionVO> gestiones = new ArrayList<LineaGestionVO>();
			while (rs.next()) {
				LineaGestionVO lineaGestion = new LineaGestionVO(rs.getInt("cantidad_Menus"), rs.getInt("idGestion"), rs.getInt("idMenu"));
				lineaGestion.setIdLineaGestion(rs.getInt("id"));
				gestiones.add(lineaGestion);
				
			}
			this.cerrarConexion();
			return gestiones;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public LineaGestionVO getLineaGestion(int id) throws Exception {
		try {
			this.abrirConexion();
			PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM LINEA_GESTION WHERE id=? ");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			LineaGestionVO lineaGestion = null;
			while (rs.next()) {
				lineaGestion = new LineaGestionVO(rs.getInt("cantidad_Menus"), rs.getInt("idGestion"), rs.getInt("idMenu"));
				
			}
			this.cerrarConexion();
			return lineaGestion;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public void add(LineaGestionVO lineaGestion) throws Exception {
		try {
			this.abrirConexion();
			PreparedStatement st = this.getConnection().prepareStatement("INSERT INTO LINEA_GESTION" + "(cantidad_Menus,idGestion,idMenu) VALUES(?,?,?)");
			st.setInt(1, lineaGestion.getCantidadMenus());
			st.setInt(2, lineaGestion.getIdGestion());
			st.setInt(3, lineaGestion.getIdMenu());
			if (st.executeUpdate() == 0) {
				// Error
			} else {
				this.cerrarConexion();
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
}
