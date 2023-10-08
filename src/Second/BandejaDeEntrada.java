package Second;

public class BandejaDeEntrada {
	private DoubleList mensajes;
	
	public BandejaDeEntrada() {
		mensajes = new DoubleList();
	}
	
	public void enviarMensajes(long id, String titulo, String mensaje) {
		
	}
	
	public void recibirMensaje(Object mensaje) {
	        mensajes.addFisrt(mensaje);
	}
	 
	public Object leerMensaje(DoubleNode a) {
	    Object temp = mensajes.remove(a); 
		
	    return temp;	        
	        
	}
	
	
}
