package Second;

public class BandejaDeEntrada {
	private DoubleList mensajes;
	
	public BandejaDeEntrada() {
		mensajes = new DoubleList();
	}
	
	public void enviarMensajes(long id, String titulo, String mensaje) {
		
	}
	public DoubleList getMensajes() {
        return mensajes;
    }
	public void recibirMensaje(Object mensaje) {
	        mensajes.addFisrt(mensaje);
	}
	 
	public Object leerMensaje() {
	    if (!mensajes.isEmpty()) {
	        return mensajes.removeFirst();
	    } else {
	        return null;
	    }
	}
}