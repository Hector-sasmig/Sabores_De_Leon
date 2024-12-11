package modelo.vo;

public class GestionVO {

    private int idGestion;
    private float precioTotal;
    private int idEmpleado;
    private int idReserva;

    // Constructor con todos los campos menos el ID
    public GestionVO(float precioTotal, int idEmpleado, int idReserva) {
        this.precioTotal = precioTotal;
        this.idEmpleado = idEmpleado;
        this.idReserva = idReserva;
    }

    // Constructor con ID incluido
    public GestionVO(int idGestion, float precioTotal, int idEmpleado, int idReserva) {
        this.idGestion = idGestion;
        this.precioTotal = precioTotal;
        this.idEmpleado = idEmpleado;
        this.idReserva = idReserva;
    }

    public int getIdGestion() {
        return idGestion;
    }

    public void setIdGestion(int idGestion) {
        this.idGestion = idGestion;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

	@Override
	public String toString() {
		return "GestionVO [idGestion=" + idGestion + ", precioTotal=" + precioTotal + ", idEmpleado=" + idEmpleado
				+ ", idReserva=" + idReserva + "]";
	}
}
