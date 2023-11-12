package Third;

public class BinarySearchTree extends BinaryTree{
	
	public BinarySearchTree() {
	super();
	}
	
	public Node find(int k) {
		return searchTree(k,this.root());
	}
	
	public Node searchTree(int key, Node v) {
		BSTEntry u = (BSTEntry) v.getData();	
		if (key == u.getKey()) {
			return v;
		}else if(key < u.getKey()) {
			return searchTree(key,v.getLeft());
		}else {
			return searchTree(key,v.getRight());
		}
	}
	
	public void insert(int k, Object e) {
	    BSTEntry O = new BSTEntry(k, e);
	    if (isEmpty()) {
	        super.addRoot(O);
	    } else {
	        addEntry(this.root(), O);
	    }
	}
	
	public void addEntry(Node v, BSTEntry o) {
	    BSTEntry temp = (BSTEntry) v.getData();
	    Node nD = new Node(o);
	    if (o.getKey() < temp.getKey()) {
	        if (hasLeft(v)) {
	            addEntry(left(v), o);
	        } else {
	            v.setLeft(nD);
	        }
	    } else {
	        if (hasRight(v)) {
	            addEntry(right(v), o);
	        } else {
	            v.setRight(nD);
	        }
	    }
	}
	
	public BSTEntry remove(int k) {
	    Node v = find(k);
	    BSTEntry temp = (BSTEntry) v.getData();
	    if (hasLeft(v) && hasRight(v)) {
	        // caso 2
	        Node w = predecesor(v);
	        v.setData(w.getData());
	        super.remove(w);
	    } else {
	        // caso 1
	        super.remove(v);
	    }
	    return temp;
	}

	
	public Node predecesor(Node v) {
	    Node temp = v.getLeft();
	    return maxNode(temp);
	}

	public Node maxNode(Node temp) {
	    if (hasRight(temp)) {
	        return maxNode(right(temp));
	    } else {
	        return temp;
	    }
	}
	
	public void Inorder(BinaryTree T, Node v) {
	    if (T.hasLeft(v)) {
	        Inorder(T, T.left(v));
	    }
	    visit(v);
	    if (T.hasRight(v)) {
	        Inorder(T, T.right(v));
	    }
	}
	
	public Object min(BinaryTree T, Node v) {
	    if (T.hasLeft(v)) {
	        return min(T, T.left(v));
	    } else {
	        return v.getData();
	    }
	}
	
	public Object max(BinaryTree T, Node v) {
	    if (T.hasRight(v)) {
	        return max(T, T.right(v));
	    } else {
	        return v.getData();
	    }
	}

	public void mostrarArbol(Node node, String prefix) {
	    if (node != null) {
	        mostrarArbol(node.getRight(), prefix + "    ");
	        System.out.println(prefix + node.getData().toString());
	        mostrarArbol(node.getLeft(), prefix + "    ");
	    }
	}


}
