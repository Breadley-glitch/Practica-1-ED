package Second;
import java.util.ArrayList;

public class Empleado {
	private long id;
    private String nombre;
    private Fecha fecha_Nac;
    private String ciudad_Nac;
    private Direccion direccion;
    private long telefono;
    private String email;
    private boolean administrador;
    private BandejaDeEntrada bandejaDeEntrada;
    private MensajesLeidos mensajesLeidos;
    private String contrasena;

    public Empleado(long id, String nombre, boolean admin, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.administrador= admin;
        this.contrasena=contrasena;
        this.bandejaDeEntrada = new BandejaDeEntrada();
        this.mensajesLeidos = new MensajesLeidos();
    }
    public Empleado(long id, String nombre, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena=contrasena;
        this.bandejaDeEntrada = new BandejaDeEntrada();
        this.mensajesLeidos = new MensajesLeidos();
    }
    public String getContrasena() {
    	return contrasena;
    }
    public void setContrasena(String contrasena) {
    	this.contrasena = contrasena;
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
    
    public boolean isAdministrador() {
    	return administrador ==true;
    }
    
    public BandejaDeEntrada getBandejaDeEntrada() {
    	return bandejaDeEntrada;
    }
    
    public MensajesLeidos getMensajesLeidos() {
        return mensajesLeidos;
    }
    
    public Object leerMensaje() {
        Object mensaje = bandejaDeEntrada.leerMensaje();
        if (mensaje != null) {
            mensajesLeidos.agregarMensaje(mensaje);
        }
        return mensaje;
    }
        
    public void enviarMensaje(Empleado destinatario, Object mensaje) {
        destinatario.getBandejaDeEntrada().recibirMensaje(mensaje);
    }
    public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", fecha de nacimiento=" + fecha_Nac + ", ciudad de nacimiento=" + ciudad_Nac
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + "]";
	}
}


