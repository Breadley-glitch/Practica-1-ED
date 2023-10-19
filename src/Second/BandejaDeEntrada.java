package Second;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class BandejaDeEntrada{
	private DoubleList mensajes;


    public BandejaDeEntrada() {
        mensajes = new DoubleList();
    }

    public void enviarMensajes(Mensaje mensaje, long id) {
    	
    }

    public DoubleList getMensajes() {
        return mensajes;
    }

    public void recibirMensaje(Object mensaje) {
        mensajes.addFirst(mensaje);
    }

    public Object leerMensaje() {
        if (!mensajes.isEmpty()) {
            return mensajes.removeFirst();
        } else {
            return null;
        }
    }
    public void imprimirMensajes() {
        DoubleNode actual = mensajes.first();
        int i = 1;
        while (actual != null) {
            Mensaje mensaje = (Mensaje) actual.getData();
            System.out.println(i + ". Fecha: " + mensaje.getFecha() + ", Título: " + mensaje.getTitulo());
            actual = actual.getNext();
            i++;
        }
    }
    
    public void escribirMensajesEnArchivo(BufferedWriter writer) throws IOException {
        if (mensajes.isEmpty()) {
            writer.write("No hay mensajes en la bandeja de entrada.");
        } else {
            writer.newLine();
            int numMensaje = 1;
            DoubleNode actual = mensajes.first();

            while (actual != null) {
                Mensaje mensaje = (Mensaje) actual.getData();
                writer.write(numMensaje + ". Fecha: " + mensaje.getFecha() + ", Título: " + mensaje.getTitulo());
                writer.newLine();
                actual = actual.getNext();
                numMensaje++;
            }
        }
    }
}