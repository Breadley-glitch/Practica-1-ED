package Second;

public class MensajesLeidos extends Mensaje {
    private Queue mensajes;

    public MensajesLeidos() {
        super(0, "", "");
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
}