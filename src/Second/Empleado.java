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
    private Borrador borrador;
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
        this.borrador = new Borrador();
    }
    public Empleado(Long id, String nombre, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_Nac= new Fecha(0,0,0);
    	this.ciudad_Nac=null;
    	this.telefono=0;
    	this.email=null;
    	this.direccion= new Direccion(null,null,null,null);
    	this.administrador = "administrador".equals("Empleado");
        this.contrasena=contrasena;
        this.bandejaDeEntrada = new BandejaDeEntrada();
        this.mensajesLeidos = new MensajesLeidos();
        this.borrador = new Borrador();
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
		return "Empleado [nombre=" + nombre + ", id=" + id + ", contraseña=" +contrasena+", fecha de nacimiento=" + fecha_Nac + ", ciudad de nacimiento=" + ciudad_Nac
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + ",Admin=" +administrador+ "]";
	}

    public void crearEmpleado(Empleado administrador, Registro registro, Empleado nuevoEmpleado) {
            registro.nuevoEmpleado(nuevoEmpleado);

    }

    public void eliminarEmpleado(Empleado administrador, Registro registro, DoubleNode empleado) {
            registro.eliminarEmpleado(administrador, empleado);
       
    }

    public void cambiarContrasena(Empleado administrador, Registro registro, Empleado empleado, String nuevaContrasena) {
            registro.cambiarContrasena(administrador, empleado, nuevaContrasena);
        }  
    public void redactarMensaje(Registro registro, long idUsuario, String titulo, String cuerpo) {
        Empleado destinatario = registro.buscarEmpleadoPorId(idUsuario);
        if (destinatario != null) {
            Mensaje mensaje = new Mensaje((int) this.id, titulo, cuerpo); 
            enviarMensaje(destinatario, mensaje);
        } else {
            System.out.println("No se encontró ningún usuario con esta cédula.");
        }
        
    
    }        
    public void leerMensaje(int numero) {
        DoubleNode actual = bandejaDeEntrada.getMensajes().first();
        for (int i = 1; i < numero; i++) {
            if (actual != null) {
                actual = actual.getNext();
            } else {
                System.out.println("No existe un mensaje con este número.");
                return;
            }
        }
        if (actual != null) {
            Mensaje mensaje = (Mensaje) actual.getData();
            System.out.println("Fecha: " + mensaje.getFecha() + ", Título: " + mensaje.getTitulo() + ", Cuerpo: " + mensaje.getCuerpo());
            // Añadir el mensaje a la cola de mensajes leídos
            mensajesLeidos.agregarMensaje(mensaje);
            // Eliminar el mensaje de la bandeja de entrada
            bandejaDeEntrada.getMensajes().remove(actual);
        } else {
            System.out.println("No existe un mensaje con este número.");
        }
    }
    public void consultarBandejaDeEntrada(int numeroMensaje) {
        DoubleNode actual = bandejaDeEntrada.getMensajes().first();
        int i = 1;
        while (actual != null) {
            Mensaje mensaje = (Mensaje) actual.getData();
            System.out.println(i + ". Fecha: " + mensaje.getFecha() + ", Título: " + mensaje.getTitulo());
            actual = actual.getNext();
            i++;
        }
        leerMensaje(numeroMensaje);

    }
    public void guardarBorrador(Mensaje mensaje) {
        borrador.agregarBorrador(mensaje);
    }

    
    public Borrador getBandejaDeBorrador() {
        return borrador;
    }
    

}


