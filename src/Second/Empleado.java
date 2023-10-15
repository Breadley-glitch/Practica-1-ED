package Second;

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
    
    

    public Empleado(String nombre, long id, int dia, int mes, int ano, String ciudad, long tel, String correo, String calle, String num, String barrio, String city, String contrasena, String admin) {
    	this.nombre = nombre;
    	this.id = id;
    	this.fecha_Nac= new Fecha(dia,mes,ano);
    	this.ciudad_Nac=ciudad;
    	this.telefono=tel;
    	this.email=correo;
    	this.direccion= new Direccion(calle,num,barrio,city);
    	this.administrador = "administrador".equals(admin);
        this.contrasena=contrasena;
        this.bandejaDeEntrada = new BandejaDeEntrada();
        this.mensajesLeidos = new MensajesLeidos();
    }
    public Empleado(Long id, String nombre, String contrasena) {
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

    public void setId(Long id) {
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

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public boolean isAdministrador() {
    	return administrador;
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
		return "Empleado [nombre=" + nombre + ", id=" + id + ", fecha de nacimiento=" + fecha_Nac + ", ciudad de nacimiento=" + ciudad_Nac
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + "Admin=" +administrador+ "]";
	}

    public void crearEmpleado(Empleado administrador, Registro registro, Empleado nuevoEmpleado) {
        if (this.isAdministrador()) {
            registro.nuevoEmpleado(nuevoEmpleado);
        } else {
            System.out.println("Acción no permitida. Solo los administradores pueden crear nuevos empleados.");
        }
    }

    public void eliminarEmpleado(Empleado administrador, Registro registro, DoubleNode empleado) {
        if (this.isAdministrador()) {
            registro.eliminarEmpleado(administrador, empleado);
        } else {
            System.out.println("Acción no permitida. Solo los administradores pueden eliminar empleados.");
        }
    }

    public void cambiarContrasena(Empleado administrador, Registro registro, Empleado empleado, String nuevaContrasena) {
        if (this.isAdministrador()) {
            registro.cambiarContrasena(administrador, empleado, nuevaContrasena);
        } else {
            System.out.println("Acción no permitida. Solo los administradores pueden cambiar contraseñas.");
        }
    }
    
}


