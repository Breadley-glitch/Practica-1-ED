package Third;

public class Nodo {
    int clave;
    Object valor;
    Nodo izquierda, derecha;

    public Nodo(int item, Object valor) {
        clave = item;
        this.valor = valor;
        izquierda = derecha = null;
    }
}
