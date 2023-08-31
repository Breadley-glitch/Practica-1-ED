package Usuarios;
import java.util.ArrayList;

import java.io.*;
import java.util.Arrays;

public class Registro implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
	private Usuario[] registro;
    private int noRegistro;
    
    
    public Usuario[] getRegistro() {
        return registro;
    }

    public void setRegistro(Usuario[] registro) {
        this.registro = registro;
    }

    public int getNoRegistro() {
        return noRegistro;
    }

    public void setNoRegistro(int noRegistro) {
        this.noRegistro = noRegistro;
    }
    
    public Registro(int capacity) {
    	this.noRegistro = capacity;
        //Usuario[] arr = new Usuario[noRegistro];
    }
    
    public boolean agregar(Usuario u) {
		boolean contains = false;
		for (Usuario usuario : registro) {
			if (usuario != null && usuario.equals(u)) {
				contains = true;
				break;
			}
		}
		
		if (contains || noRegistro >= registro.length) {
			return false;
		} else {
			registro[noRegistro] = u;
			noRegistro++;
			organizarUsuario();
			return true;
		}
	}
    
	public void organizarUsuario() {
		for (int i = 0; i < noRegistro - 1; i++) {
			for (int j = i + 1; j < noRegistro; j++) {
				if (registro[i].getId() > registro[j].getId()) {
					Usuario temp = registro[i];
					registro[i] = registro[j];
					registro[j] = temp;
				}
			}
		}
	}
	
	
	public Usuario eliminar(long id) {
	    int index = buscarPosicion(id);
	    if (index != -1) {
	        Usuario removedUser = registro[index];
	        for (int i = index; i < noRegistro - 1; i++) {
	        	registro[i] = registro[i + 1];
	        }
	        noRegistro--;
	        organizarUsuario();
	        return removedUser;
	    } else {
	        return null;
	    }
	}
	
	public int buscarPosicion(long id) {
        for (int i = 0; i < noRegistro; i++) {
            if (registro[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }
	
	public String buscarUsuario(long id) {
        for (int i = 0; i < noRegistro; i++) {
            if (registro[i].getId() == id) {
                return registro[i].toString();
            }
        }
        return "No se encontró un usuario con el ID especificado.";
    }
	
}