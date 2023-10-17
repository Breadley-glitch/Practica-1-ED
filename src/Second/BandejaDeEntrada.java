package Second;

public class BandejaDeEntrada extends Mensaje {
    private DoubleList mensajes;


    public BandejaDeEntrada() {
        super(0, "", "");
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
}