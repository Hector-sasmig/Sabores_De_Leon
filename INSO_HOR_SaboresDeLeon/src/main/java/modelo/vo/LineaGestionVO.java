package main.java.modelo.vo;

public class LineaGestionVO {

    private int idLineaGestion;
    private int cantidadMenus;
    private int idGestion;
    private int idMenu;

    // Constructor con todos los campos menos el ID
    public LineaGestionVO(int cantidadMenus, int idGestion, int idMenu) {
        this.cantidadMenus = cantidadMenus;
        this.idGestion = idGestion;
        this.idMenu = idMenu;
    }

    // Constructor con ID incluido
    public LineaGestionVO(int idLineaGestion, int cantidadMenus, int idGestion, int idMenu) {
        this.idLineaGestion = idLineaGestion;
        this.cantidadMenus = cantidadMenus;
        this.idGestion = idGestion;
        this.idMenu = idMenu;
    }

    public int getIdLineaGestion() {
        return idLineaGestion;
    }

    public void setIdLineaGestion(int idLineaGestion) {
        this.idLineaGestion = idLineaGestion;
    }

    public int getCantidadMenus() {
        return cantidadMenus;
    }

    public void setCantidadMenus(int cantidadMenus) {
        this.cantidadMenus = cantidadMenus;
    }

    public int getIdGestion() {
        return idGestion;
    }

    public void setIdGestion(int idGestion) {
        this.idGestion = idGestion;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

	@Override
	public String toString() {
		return "LineaGestionVO [idLineaGestion=" + idLineaGestion + ", cantidadMenus=" + cantidadMenus + ", idGestion="
				+ idGestion + ", idMenu=" + idMenu + "]";
	}
}