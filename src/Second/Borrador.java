package Second;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Borrador{
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
	    
	    public void imprimirMensajes() {
	        if (mensajes.isEmpty()) {
	            System.out.println("No hay mensajes en el borrador.");
	        } else {
	            System.out.println("Mensajes en el borrador:");
	            int numMensaje = 1;
	            
	            // Crear una pila temporal para mantener los mensajes sin alterar la original
	            Stack tempStack = new Stack();
	            
	            while (!mensajes.isEmpty()) {
	                Mensaje mensaje = (Mensaje) mensajes.top();
	                System.out.println("Mensaje " + numMensaje + ": " + mensaje);
	                numMensaje++;
	                
	                // Quitar el mensaje de la pila original y guardarlo en la temporal
	                tempStack.push(mensajes.pop());
	            }
	            // Restablecer la pila original con los mensajes en su orden original
	            while (!tempStack.isEmpty()) {
	                mensajes.push(tempStack.pop());
	            }
	        }
	    }
	    
	    public void escribirMensajesEnArchivo(BufferedWriter writer) throws IOException {
	        if (mensajes.isEmpty()) {
	            writer.write("No hay mensajes en el borrador.");
	        } else {
	            writer.newLine();
	            int numMensaje = 1;

	            // Crear una pila temporal para mantener los mensajes sin alterar la original
	            Stack tempStack = new Stack();

	            while (!mensajes.isEmpty()) {
	                Mensaje mensaje = (Mensaje) mensajes.top();
	                writer.write("Mensaje, " + numMensaje + ", id, " +mensaje.getId()+ ", Fecha, " + mensaje.getFecha() + ", Título, " + mensaje.getTitulo()+ ", Cuerpo, " + mensaje.getCuerpo());
	                writer.newLine();
	                numMensaje++;

	                // Quitar el mensaje de la pila original y guardarlo en la temporal
	                tempStack.push(mensajes.pop());
	            }
	            // Restablecer la pila original con los mensajes en su orden original
	            while (!tempStack.isEmpty()) {
	                mensajes.push(tempStack.pop());
	            }
	        }
	    }
	

}



