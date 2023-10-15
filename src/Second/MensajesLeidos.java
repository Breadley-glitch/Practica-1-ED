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
        return mensajes.dequeue();
    }
}