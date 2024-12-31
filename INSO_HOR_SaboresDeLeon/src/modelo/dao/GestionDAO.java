package main.java.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import main.java.modelo.conexion.Conexion;
import main.java.modelo.vo.GestionVO;

public class GestionDAO extends Conexion {

    public ArrayList<GestionVO> getLista() throws Exception {
        try {
            this.abrirConexion();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM GESTION");
            ResultSet rs = st.executeQuery();
            ArrayList<GestionVO> gestiones = new ArrayList<GestionVO>();
            while (rs.next()) {
                GestionVO gestion = new GestionVO(rs.getFloat("PrecioTotal"), rs.getInt("idEmpleado"), rs.getInt("idReserva"));
                gestion.setIdGestion(rs.getInt("id"));
                gestiones.add(gestion);
            }
            this.cerrarConexion();
            return gestiones;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public GestionVO getGestion(int id) throws Exception {
        try {
            this.abrirConexion();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM GESTION WHERE id=? ");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            GestionVO gestion = null;
            while (rs.next()) {
                gestion = new GestionVO(rs.getFloat("PrecioTotal"), rs.getInt("idEmpleado"), rs.getInt("idReserva"));
            }
            this.cerrarConexion();
            return gestion;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void add(GestionVO gestion) throws Exception {
        try {
            this.abrirConexion();
            PreparedStatement st = this.getConnection().prepareStatement("INSERT INTO GESTION" + "(PrecioTotal,idEmpleado,idReserva) VALUES(?,?,?)");
            st.setFloat(1, gestion.getPrecioTotal());
            st.setInt(2, gestion.getIdEmpleado());
            st.setInt(3, gestion.getIdReserva());
            if (st.executeUpdate() == 0) {
                // Error
            } else {
                this.cerrarConexion();
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void update(GestionVO gestionVO) throws Exception {
        try {
            this.abrirConexion();
            PreparedStatement st = this.getConnection().prepareStatement("UPDATE GESTION SET PrecioTotal = ?, idEmpleado = ?, idReserva = ? WHERE id = ?");
            st.setFloat(1, gestionVO.getPrecioTotal());
            st.setInt(2, gestionVO.getIdEmpleado());
            st.setInt(3, gestionVO.getIdReserva());
            st.setInt(4, gestionVO.getIdGestion());
            st.executeUpdate();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
