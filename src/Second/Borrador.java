package Second;

public class Borrador {
	    private Stack mensajes;

	    public Borrador() {
	        mensajes = new Stack();
	    }

	    public void agregarBorrador(Mensaje mensaje) {
	        mensajes.push(mensaje);
	    }

	    public Object obtenerUltimoBorrador() {
	        return mensajes.top();
	    }

	    public Mensaje enviarUltimoBorrador() {
	        return (Mensaje) mensajes.pop();
	    }
	    public Stack getMensajes() {
	    	return mensajes;
	    }
	}


