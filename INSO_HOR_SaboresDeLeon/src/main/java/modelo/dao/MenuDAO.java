package main.java.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import main.java.modelo.conexion.Conexion;
import main.java.modelo.vo.MenuVO;

public class MenuDAO extends Conexion {

    // Obtiene la lista completa de menús
    public ArrayList<MenuVO> getLista() throws Exception {
        try {
            this.abrirConexion();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM MENU");
            ResultSet rs = st.executeQuery();
            ArrayList<MenuVO> menus = new ArrayList<>();
            while (rs.next()) {
                MenuVO menu = new MenuVO(
                    rs.getString("PrimerPlato"), 
                    rs.getString("SegundoPlato"), 
                    rs.getString("Postre"), 
                    rs.getString("Bebida"), 
                    rs.getFloat("Precio")
                );
                menu.setIdMenu(rs.getInt("id"));
                menus.add(menu);
            }
            this.cerrarConexion();
            return menus;
        } catch (Exception e) {
            throw new Exception("Error al obtener la lista de menús: " + e.getMessage(), e);
        }
    }

    // Obtiene un menú específico por su ID
    public MenuVO getMenu(int id) throws Exception {
        try {
            this.abrirConexion();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM MENU WHERE id = ?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            MenuVO menu = null;
            if (rs.next()) {
                menu = new MenuVO(
                    rs.getString("PrimerPlato"), 
                    rs.getString("SegundoPlato"), 
                    rs.getString("Postre"), 
                    rs.getString("Bebida"), 
                    rs.getFloat("Precio")
                );
                menu.setIdMenu(rs.getInt("id"));
            }
            this.cerrarConexion();
            return menu;
        } catch (Exception e) {
            throw new Exception("Error al obtener el menú con id: " + id + ": " + e.getMessage(), e);
        }
    }

    // Agrega un nuevo menú a la base de datos
    public void add(MenuVO menu) throws Exception {
        try {
            this.abrirConexion();
            PreparedStatement st = this.getConnection().prepareStatement(
                "INSERT INTO MENU (PrimerPlato, SegundoPlato, Postre, Bebida, Precio) VALUES (?, ?, ?, ?, ?)"
            );
            st.setString(1, menu.getPrimerPlato());
            st.setString(2, menu.getSegundoPlato());
            st.setString(3, menu.getPostre());
            st.setString(4, menu.getBebida());
            st.setFloat(5, menu.getPrecio());
            
            int rowsAffected = st.executeUpdate();
            if (rowsAffected == 0) {
                throw new Exception("No se pudo insertar el menú.");
            }
            this.cerrarConexion();
        } catch (Exception e) {
            throw new Exception("Error al insertar el menú: " + e.getMessage(), e);
        }
    }

    // Actualiza un menú existente en la base de datos
    public void update(MenuVO menu) throws Exception {
        try {
            this.abrirConexion();
            PreparedStatement st = this.getConnection().prepareStatement(
                "UPDATE MENU SET PrimerPlato = ?, SegundoPlato = ?, Postre = ?, Bebida = ?, Precio = ? WHERE id = ?"
            );
            st.setString(1, menu.getPrimerPlato());
            st.setString(2, menu.getSegundoPlato());
            st.setString(3, menu.getPostre());
            st.setString(4, menu.getBebida());
            st.setFloat(5, menu.getPrecio());
            st.setInt(6, menu.getIdMenu());
            
            int rowsAffected = st.executeUpdate();
            if (rowsAffected == 0) {
                throw new Exception("No se pudo actualizar el menú con id: " + menu.getIdMenu());
            }
        } catch (Exception e) {
            throw new Exception("Error al actualizar el menú con id: " + menu.getIdMenu() + ": " + e.getMessage(), e);
        
        } finally {
            this.cerrarConexion();
        }
    }

    // Elimina un menú de la base de datos por su ID
    public void delete(int id) throws Exception {
        try {
            this.abrirConexion();
            PreparedStatement st = this.getConnection().prepareStatement("DELETE FROM MENU WHERE id = ?");
            st.setInt(1, id);
            
            int rowsAffected = st.executeUpdate();
            if (rowsAffected == 0) {
                throw new Exception("No se pudo eliminar el menú con id: " + id);
            }
            this.cerrarConexion();
        } catch (Exception e) {
            throw new Exception("Error al eliminar el menú con id: " + id + ": " + e.getMessage(), e);
        }
    }
}
