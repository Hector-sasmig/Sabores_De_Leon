package modelo.vo;

public class EmpleadoVO {

    private int idEmpleado;
    private String nombre;
    private String apellido;
    private String dni;
    private int telefono;
    private String correo;
    private String tipo;
    private String contrasena;

    // Constructor con todos los campos menos el ID
    public EmpleadoVO(String nombre, String apellido, String dni, int telefono, String correo, String tipo, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.correo = correo;
        this.tipo = tipo;
        this.contrasena = contrasena;
    }

	// Constructor con ID incluido
    public EmpleadoVO(int idEmpleado, String nombre, String apellido, String dni, int telefono, String correo, String tipo, String contrasena) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.correo = correo;
        this.tipo = tipo;
        this.contrasena = contrasena;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    @Override
	public String toString() {
		return "EmpleadoVO [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", telefono=" + telefono + ", correo=" + correo + ", tipo=" + tipo + ", contrasena=" + contrasena
				+ "]";
	}
}
