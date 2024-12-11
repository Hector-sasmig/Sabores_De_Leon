package modelo.vo;

public class ReservaVO {

    private int idReserva;
    private String nombre;
    private String apellido;
    private String dni;
    private int telefono;
    private String correo;
    private int comensales;
    private String fechaHora;

    // Constructor sin ID
    public ReservaVO(String nombre, String apellido, String dni, int telefono, String correo, int comensales, String fechaHora) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.correo = correo;
        this.comensales = comensales;
        this.fechaHora = fechaHora;
    }

    // Constructor con ID incluido
    public ReservaVO(int idReserva, String nombre, String apellido, String dni, int telefono, String correo, int comensales, String fechaHora) {
        this.idReserva = idReserva;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.correo = correo;
        this.comensales = comensales;
        this.fechaHora = fechaHora;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getComensales() {
        return comensales;
    }

    public void setComensales(int comensales) {
        this.comensales = comensales;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

	@Override
	public String toString() {
		return "ReservaVO [idReserva=" + idReserva + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", telefono=" + telefono + ", correo=" + correo + ", comensales=" + comensales + ", fechaHora="
				+ fechaHora + "]";
	}
}