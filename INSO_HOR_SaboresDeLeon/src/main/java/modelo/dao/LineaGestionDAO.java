package main.java.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import main.java.modelo.conexion.Conexion;
import main.java.modelo.vo.LineaGestionVO;

public class LineaGestionDAO extends Conexion {

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
            throw new Exception("Error al obtener la lista de lineas de gestión: " + e.getMessage(), e);
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
                lineaGestion.setIdLineaGestion(rs.getInt("id"));
            }
            this.cerrarConexion();
            return lineaGestion;
        } catch (Exception e) {
            throw new Exception("Error al obtener la línea de gestión con id: " + id + ": " + e.getMessage(), e);
        }
    }

    public void add(LineaGestionVO lineaGestion) throws Exception {
        try {
            this.abrirConexion();
            PreparedStatement st = this.getConnection().prepareStatement("INSERT INTO LINEA_GESTION (cantidad_Menus, idGestion, idMenu) VALUES(?, ?, ?)");
            st.setInt(1, lineaGestion.getCantidadMenus());
            st.setInt(2, lineaGestion.getIdGestion());
            st.setInt(3, lineaGestion.getIdMenu());
            if (st.executeUpdate() == 0) {
                throw new Exception("No se pudo insertar la línea de gestión.");
            }
            this.cerrarConexion();
        } catch (Exception e) {
            throw new Exception("Error al insertar la línea de gestión: " + e.getMessage(), e);
        }
    }

    public void update(LineaGestionVO lineaGestion) throws Exception {
        try {
            this.abrirConexion();
            PreparedStatement st = this.getConnection().prepareStatement("UPDATE LINEA_GESTION SET cantidad_Menus = ?, idGestion = ?, idMenu = ? WHERE id = ?");
            st.setInt(1, lineaGestion.getCantidadMenus());
            st.setInt(2, lineaGestion.getIdGestion());
            st.setInt(3, lineaGestion.getIdMenu());
            st.setInt(4, lineaGestion.getIdLineaGestion());
            if (st.executeUpdate() == 0) {
                throw new Exception("No se pudo actualizar la línea de gestión.");
            }
            this.cerrarConexion();
        } catch (Exception e) {
            throw new Exception("Error al actualizar la línea de gestión: " + e.getMessage(), e);
        }
    }
}
