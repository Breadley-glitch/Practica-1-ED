package Third;
public class Test {
	public static void main(String[] args) {
	    BinarySearchTree bst = new BinarySearchTree();

	    Usuario juan = new Usuario("Juan", 10101013);
	    bst.insert(juan.calcularClave(), juan);

	    Usuario pablo = new Usuario("Pablo", 10001011);
	    bst.insert(pablo.calcularClave(), pablo);

	    Usuario maria = new Usuario("Maria", 10101015);
	    bst.insert(maria.calcularClave(), maria);

	    Usuario ana = new Usuario("Ana", 1010000);
	    bst.insert(ana.calcularClave(), ana);

	    Usuario diana = new Usuario("Diana", 10111105);
	    bst.insert(diana.calcularClave(), diana);

	    Usuario mateo = new Usuario("Mateo", 10110005);
	    bst.insert(mateo.calcularClave(), mateo);
	    
	    Usuario Breadley = new Usuario("Breadley",1193536108);
	    bst.insert(Breadley.calcularClave(), Breadley);

	    // Ahora puedes probar los diferentes métodos del árbol binario de búsqueda.
	    // Por ejemplo, puedes imprimir el árbol en orden.
	
	bst.Inorder(bst, bst.root());
	// Mostrar el árbol
    bst.mostrarArbol(bst.root(), "");

    // Buscar un objeto dada la clave
    Node node = bst.find(juan.calcularClave());
    System.out.println("Buscando clave " + juan.calcularClave() + ": " + node.getData());

    // Valor máximo y mínimo
    System.out.println("Valor máximo: " + bst.max(bst, bst.root()));
    System.out.println("Valor mínimo: " + bst.min(bst, bst.root()));

    // Eliminar un objeto dada la clave
    bst.remove(pablo.calcularClave());

    // Mostrar el árbol después de eliminar
    bst.mostrarArbol(bst.root(), "");

    // Recorrido inorder
    System.out.println("Recorrido Inorder:");
    bst.Inorder(bst, bst.root());
}
	}
	
