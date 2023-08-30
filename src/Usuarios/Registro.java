package Usuarios;
import java.util.ArrayList;

import java.io.*;
import java.util.Arrays;

public class Registro implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
	private ArrayList<Usuario> registro = new ArrayList<Usuario>();
    private int noRegistro;
    
    public Registro(ArrayList<Usuario> registro, int noRegistro) {
        this.registro = registro;
        this.noRegistro = noRegistro;
    }
    
    public Registro() {
        this.registro = new ArrayList<Usuario>();
        this.noRegistro = 0;
    }
    
    public ArrayList<Usuario> getRegistro() {
        return registro;
    }

    public void setRegistro(ArrayList<Usuario> registro) {
        this.registro = registro;
    }

    public int getNoRegistro() {
        return noRegistro;
    }

    public void setNoRegistro(int noRegistro) {
        this.noRegistro = noRegistro;
    }
    
    public void RegistroMetod(int capacity) {
        this.registro.ensureCapacity(capacity);
    }
    
	public boolean agregar(Usuario u) {
		if (registro.contains(u)) {
			return false;
		}else {
			registro.add(u);
			return true;
		}
	}
	
	public Usuario eliminar(long id) {
	    int index = buscarPosicion(id);
	    if (index != -1) {
	        return registro.remove(index);
	    } else {
	        return null;
	    }
	}
	
	public int buscarPosicion(long id) {
        for (int i = 0; i < registro.size(); i++) {
            if (registro.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
	
    public Usuario buscarUsuario(long id) {
        for (Usuario usuario : registro) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }
	
}