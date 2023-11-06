package Third;

public class ArbolBinarioBusqueda {
    Nodo raiz;

    void insertar(int clave, Object valor) {
        raiz = insertarRec(raiz, clave, valor);
    }

    Nodo insertarRec(Nodo raiz, int clave, Object valor) {
        if (raiz == null) {
            raiz = new Nodo(clave, valor);
            return raiz;
        }
        if (clave < raiz.clave)
            raiz.izquierda = insertarRec(raiz.izquierda, clave, valor);
        else if (clave > raiz.clave)
            raiz.derecha = insertarRec(raiz.derecha, clave, valor);
        return raiz;
    }

    void eliminar(int clave) {
        raiz = eliminarRec(raiz, clave);
    }

    Nodo eliminarRec(Nodo raiz, int clave) {
        if (raiz == null)  return raiz;
        if (clave < raiz.clave)
            raiz.izquierda = eliminarRec(raiz.izquierda, clave);
        else if (clave > raiz.clave)
            raiz.derecha = eliminarRec(raiz.derecha, clave);
        else {
            if (raiz.izquierda == null)
                return raiz.derecha;
            else if (raiz.derecha == null)
                return raiz.izquierda;
            raiz.clave = minValor(raiz.derecha);
            raiz.derecha = eliminarRec(raiz.derecha, raiz.clave);
        }
        return raiz;
    }

    int minValor(Nodo raiz) {
        int minv = raiz.clave;
        while (raiz.izquierda != null) {
            minv = raiz.izquierda.clave;
            raiz = raiz.izquierda;
        }
        return minv;
    }

    void inorder()  {
        inorderRec(raiz);
    }

    void inorderRec(Nodo raiz) {
        if (raiz != null) {
            inorderRec(raiz.izquierda);
            System.out.println(raiz.clave);
            inorderRec(raiz.derecha);
        }
    }
    void mostrarArbol(Nodo nodo, String prefijo) {
        if (nodo != null) {
            mostrarArbol(nodo.derecha, prefijo + "    ");
            System.out.println(prefijo + nodo.clave);
            mostrarArbol(nodo.izquierda, prefijo + "    ");
        }
    }
    void recorridoInorder()  {
        recorridoInorderRec(raiz);
    }
    
    void recorridoInorderRec(Nodo nodo) {
        if (nodo != null) {
            recorridoInorderRec(nodo.izquierda);
            System.out.println(nodo.clave);
            recorridoInorderRec(nodo.derecha);
        }
    }
    
}
