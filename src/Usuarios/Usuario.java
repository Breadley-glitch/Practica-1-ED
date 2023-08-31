package Usuarios;
public class Usuario {
    private long id;
    private String nombre;
    private Fecha fecha_Nac;
    private String ciudad_Nac;
    private Direccion direccion;
    private long telefono;
    private String email;

    public Usuario(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Fecha getFechaNacimiento() {
        return fecha_Nac;
    }

    public void setFechaNacimiento(Fecha fecha_Nac) {
        this.fecha_Nac = fecha_Nac;
    }

    public String getCiudadNacimiento() {
        return ciudad_Nac;
    }

    public void setCiudadNacimiento(String ciudad_Nac) {
        this.ciudad_Nac = ciudad_Nac;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", fecha de nacimiento=" + fecha_Nac + ", ciudad de nacimiento=" + ciudad_Nac
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + "]";
	}
}



