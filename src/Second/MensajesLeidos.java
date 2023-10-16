package Second;

public class MensajesLeidos {
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

}