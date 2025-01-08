package main.java.controladores;

import java.util.ArrayList;

import main.java.modelo.dao.MenuDAO;
import main.java.modelo.dao.ReservaDAO;
import main.java.modelo.vo.MenuVO;
import main.java.modelo.vo.ReservaVO;

public class EmpleadoControlador {
    private ArrayList<ReservaVO> reservas;
    private ArrayList<MenuVO> menus;

    // Constructor que recibe la vista
    public EmpleadoControlador() {
        ReservaDAO reservaDAO = new ReservaDAO();
        MenuDAO menuDAO = new MenuDAO();
        
        // Cargar los datos al inicializar el controlador
        try {
        	this.reservas = reservaDAO.getLista();
        	this.menus = menuDAO.getLista();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ReservaVO> getReservas() {
        ReservaDAO reservaDAO = new ReservaDAO();
        try {
            this.reservas = reservaDAO.getLista();
            return this.reservas;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ReservaVO getReserva(int id) {
        for (ReservaVO r : reservas) {
            if (r.getIdReserva() == id) {
                return r;
            }
        }
        return null;
    }
    
    public void aniadirReserva(ReservaVO r) {
    	ReservaDAO rDao = new ReservaDAO();
        try {
        	rDao.add(r);
            this.reservas.add(r);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void actualizarReserva(ReservaVO r) {
    	ReservaDAO rDao = new ReservaDAO();
        try {
            rDao.update(r);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void eliminarReserva(int id) {
    	//No se si va con id o con una reservaVO, ni idea
    }

    public ArrayList<MenuVO> getMenus() {
    	MenuDAO menuDAO = new MenuDAO();
        try {
            this.menus = menuDAO.getLista();
            return this.menus;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public MenuVO getMenu(int id) {
        for (MenuVO m : menus) {
            if (m.getIdMenu() == id) {
                return m;
            }
        }
        return null;
    }
}

