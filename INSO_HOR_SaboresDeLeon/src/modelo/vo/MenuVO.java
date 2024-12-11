package modelo.vo;

public class MenuVO {

    private int idMenu;
    private String primerPlato;
    private String segundoPlato;
    private String postre;
    private String bebida;
    private float precio;

    // Constructor sin ID
    public MenuVO(String primerPlato, String segundoPlato, String postre, String bebida, float precio) {
        this.primerPlato = primerPlato;
        this.segundoPlato = segundoPlato;
        this.postre = postre;
        this.bebida = bebida;
        this.precio = precio;
    }

    // Constructor con ID incluido
    public MenuVO(int idMenu, String primerPlato, String segundoPlato, String postre, String bebida, float precio) {
        this.idMenu = idMenu;
        this.primerPlato = primerPlato;
        this.segundoPlato = segundoPlato;
        this.postre = postre;
        this.bebida = bebida;
        this.precio = precio;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getPrimerPlato() {
        return primerPlato;
    }

    public void setPrimerPlato(String primerPlato) {
        this.primerPlato = primerPlato;
    }

    public String getSegundoPlato() {
        return segundoPlato;
    }

    public void setSegundoPlato(String segundoPlato) {
        this.segundoPlato = segundoPlato;
    }

    public String getPostre() {
        return postre;
    }

    public void setPostre(String postre) {
        this.postre = postre;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

	@Override
	public String toString() {
		return "MenuVO [idMenu=" + idMenu + ", primerPlato=" + primerPlato + ", segundoPlato=" + segundoPlato
				+ ", postre=" + postre + ", bebida=" + bebida + ", precio=" + precio + "]";
	}
}
