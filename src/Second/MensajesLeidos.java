package Second;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class MensajesLeidos{
    private Queue mensajes;

    public MensajesLeidos() {
        mensajes = new Queue();
    }

    public void agregarMensaje(Object mensaje) {
        mensajes.enqueue(mensaje);
    }

    public Object obtenerSiguienteMensaje() {
        if (!mensajes.isEmpty()) {
            return mensajes.dequeue();
        } else {
            System.out.println("No hay más mensajes leídos.");
            return null;
        }
    }
    
    public void imprimirMensajes() {
        if (mensajes.isEmpty()) {
            System.out.println("No hay mensajes leídos.");
        } else {
            System.out.println("Mensajes leídos:");
            int numMensaje = 1;
            while (!mensajes.isEmpty()) {
                Object mensaje = mensajes.dequeue();
                if (mensaje instanceof Mensaje) {
                    System.out.println("Mensaje " + numMensaje + ": " + mensaje);
                    numMensaje++;
                }
            }
        }
    }
    
    public void imprimirMensajesSinEliminar() {
        if (mensajes.isEmpty()) {
            System.out.println("No hay mensajes leídos.");
        } else {
            System.out.println("Mensajes leídos:");
            int numMensaje = 1;
            // Crea una cola temporal para mantener los mensajes sin eliminarlos
            Queue tempQueue = new Queue();

            while (!mensajes.isEmpty()) {
                Object mensaje = mensajes.dequeue();
                if (mensaje instanceof Mensaje) {
                    Mensaje mensajeLeido = (Mensaje) mensaje;
                    System.out.println("Mensaje " + numMensaje + ": Fecha: " + mensajeLeido.getFecha() + ", Título: " + mensajeLeido.getTitulo());
                    numMensaje++;
                }
                // Guarda el mensaje en la cola temporal para que no se elimine
                tempQueue.enqueue(mensaje);
            }
            // Restablece la cola original con los mensajes
            mensajes = tempQueue;
        }
    }
    
    public void escribirMensajesEnArchivo(BufferedWriter writer) throws IOException {
        if (mensajes.isEmpty()) {
            writer.write("No hay mensajes leídos.");
        } else {
            writer.newLine();
            int numMensaje = 1;
            // Crear una cola temporal para mantener los mensajes sin eliminarlos
            Queue tempQueue = new Queue();

            while (!mensajes.isEmpty()) {
                Object mensaje = mensajes.dequeue();
                if (mensaje instanceof Mensaje) {
                    Mensaje mensajeLeido = (Mensaje) mensaje;
                    writer.write("Mensaje " + numMensaje + ": Fecha: " + mensajeLeido.getFecha() + ", Título: " + mensajeLeido.getTitulo());
                    writer.newLine();
                    numMensaje++;
                }
                // Guardar el mensaje en la cola temporal para que no se elimine
                tempQueue.enqueue(mensaje);
            }
            // Restablecer la cola original con los mensajes
            mensajes = tempQueue;
        }
    }

    }

