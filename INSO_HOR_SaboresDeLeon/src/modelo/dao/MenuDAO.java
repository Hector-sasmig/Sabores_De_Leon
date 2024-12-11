package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modelo.conexion.Conexion;
import modelo.vo.MenuVO;

public class MenuDAO extends Conexion {

	public ArrayList<MenuVO> getLista() throws Exception {
		try {
			this.abrirConexion();
			PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM MENU");
			ResultSet rs = st.executeQuery();
			ArrayList<MenuVO> menus = new ArrayList<MenuVO>();
			while (rs.next()) {
				MenuVO menu = new MenuVO(rs.getString("PrimerPlato"), rs.getString("SegundoPlato"), rs.getString("Postre"), rs.getString("Bebida"), rs.getFloat("Precio"));
				menu.setIdMenu(rs.getInt("id"));
				menus.add(menu);
			}
			this.cerrarConexion();
			return menus;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public MenuVO getMenu(int id) throws Exception {
		try {
			this.abrirConexion();
			PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM MENU WHERE id = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			MenuVO menu = null;
			while (rs.next()) {
				menu = new MenuVO(rs.getString("PrimerPlato"), rs.getString("SegundoPlato"), rs.getString("Postre"), rs.getString("Bebida"), rs.getFloat("Precio"));
				menu.setIdMenu(rs.getInt("id"));
			}
			this.cerrarConexion();
			return menu;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public void add(MenuVO menu) throws Exception {
		try {
			this.abrirConexion();
			PreparedStatement st = this.getConnection().prepareStatement(
					"INSERT INTO MENU" + "(PrimerPlato,SegundoPlato,Postre,Bebida,Precio) VALUES(?,?,?,?,?)");
			st.setString(1, menu.getPrimerPlato());
			st.setString(2, menu.getSegundoPlato());
			st.setString(3, menu.getPostre());
			st.setString(4, menu.getBebida());
			st.setFloat(5, menu.getPrecio());
			if (st.executeUpdate() == 0) {
				// Error
			} else {
				this.cerrarConexion();
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public void update(MenuVO menu) throws Exception {
		try {
			this.abrirConexion();
			PreparedStatement st = this.getConnection().prepareStatement(
					"UPDATE MENU SET primerPlato=?, segundoPlato=?, postre=?, bebida=?, precio=? WHERE id=?");
			st.setString(1, menu.getPrimerPlato());
			st.setString(2, menu.getSegundoPlato());
			st.setString(3, menu.getPostre());
			st.setString(4, menu.getBebida());
			st.setFloat(5, menu.getPrecio());
			st.setInt(6, menu.getIdMenu());
			st.executeUpdate();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
}
