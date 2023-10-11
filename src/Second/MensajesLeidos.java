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
        return mensajes.dequeue();
    }
}