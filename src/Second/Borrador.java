package Second;

public class Borrador {
	    private Stack mensajes;

	    public Borrador() {
	        mensajes = new Stack();
	    }

	    public void agregarBorrador(Mensaje mensaje) {
	        mensajes.push(mensaje);
	    }

	    public Mensaje obtenerUltimoBorrador() {
	        return (Mensaje) mensajes.top();
	    }

	    public Mensaje enviarUltimoBorrador() {
	        return (Mensaje) mensajes.pop();
	    }
	}


