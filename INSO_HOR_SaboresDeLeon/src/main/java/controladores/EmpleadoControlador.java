package main.java.controladores;

import main.java.modelo.dao.*;
import main.java.modelo.vo.*;
import main.java.vista.EmpleadoVista;

import java.util.ArrayList;

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
    
    public void addReserva(ReservaVO r) {
    	ReservaDAO rDao = new ReservaDAO();
        try {
        	rDao.add(r);
            this.reservas.add(r);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateReserva(ReservaVO r) {
    	ReservaDAO rDao = new ReservaDAO();
        try {
            rDao.update(r);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ReservaVO getReserva(int id) {
        for (ReservaVO r : reservas) {
            if (r.getIdReserva() == id) {
                return r;
            }
        }
        return null;
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

