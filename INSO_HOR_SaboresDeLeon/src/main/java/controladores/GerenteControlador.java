package main.java.controladores;

import java.util.ArrayList;

import main.java.modelo.dao.EmpleadoDAO;
import main.java.modelo.dao.LineaGestionDAO;
import main.java.modelo.dao.MenuDAO;
import main.java.modelo.vo.EmpleadoVO;
import main.java.modelo.vo.LineaGestionVO;
import main.java.modelo.vo.MenuVO;


public class GerenteControlador {

	private ArrayList<MenuVO> menus;
	private ArrayList<LineaGestionVO> lineaGestion;
	private ArrayList<EmpleadoVO> empleados;
	
	public GerenteControlador() {
        MenuDAO menuDAO = new MenuDAO();
        LineaGestionDAO lineaGestionDAO = new LineaGestionDAO();
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        
     // Cargar los datos al inicializar el controlador
        try {
        	this.menus = menuDAO.getLista();
        	this.lineaGestion = lineaGestionDAO.getLista();
        	this.empleados = empleadoDAO.getLista();


        } catch (Exception e) {
            e.printStackTrace();
        } 
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
    
    public void aniadirMenu(MenuVO m) {
    	MenuDAO mDao = new MenuDAO();
        try {
        	mDao.add(m);
            this.menus.add(m);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void actualizarMenu(MenuVO m) {
    	MenuDAO mDao = new MenuDAO();
        try {
            mDao.update(m);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void eliminarMenu(int id) {
		MenuDAO mDao= new MenuDAO();
		try {
			mDao.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
    }
    
    public ArrayList<EmpleadoVO> getEmpleados() {
    	EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        try {
            this.empleados = empleadoDAO.getLista();
            return this.empleados;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public EmpleadoVO getEmpleado(int id) {
        for (EmpleadoVO e : empleados) {
            if (e.getIdEmpleado() == id) {
                return e;
            }
        }
        return null;
    }
    
    public void aniadirEmpleado(EmpleadoVO em) {
    	EmpleadoDAO eDao = new EmpleadoDAO();
        try {
        	eDao.add(em);
            this.empleados.add(em);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void actualizarEmpleado(EmpleadoVO em) {
    	EmpleadoDAO eDao = new EmpleadoDAO();
        try {
            eDao.update(em);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void eliminarEmpleado(int id) {
    	
    }
}
