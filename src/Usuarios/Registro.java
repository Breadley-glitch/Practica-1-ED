package Usuarios;

import java.io.*;
import java.util.Arrays;

public class Registro {
    private Usuario[] usuarios;
    private int noRegistros;

    public Registro(int capacidadMaxima) {
        usuarios = new Usuario[capacidadMaxima];
        noRegistros = 0;
    }

    public int agregar(Usuario u) {
        if (noRegistros < usuarios.length && buscarPosicion(u.getId()) == -1) {
            usuarios[noRegistros] = u;
            noRegistros++;
            Arrays.sort(usuarios, 0, noRegistros); // Ordenar usuarios por número de identificación
            return 1; // Usuario agregado exitosamente
        } else if (noRegistros >= usuarios.length) {
            return 0; // Registro lleno
        } else {
            return -1; // Usuario con el mismo número de identificación ya existe
        }
    }

    public Usuario eliminar(long id) {
        int pos = buscarPosicion(id);
        if (pos != -1) {
            Usuario usuarioEliminado = usuarios[pos];
            for (int i = pos; i < noRegistros - 1; i++) {
                usuarios[i] = usuarios[i + 1];
            }
            usuarios[noRegistros - 1] = null;
            noRegistros--;
            return usuarioEliminado;
        }
        return null; // Usuario no encontrado
    }

    public int buscarPosicion(long id) {
        for (int i = 0; i < noRegistros; i++) {
            if (usuarios[i].getId() == id) {
                return i;
            }
        }
        return -1; // Usuario no encontrado
    }

    public Usuario buscarUsuario(long id) {
        int pos = buscarPosicion(id);
        if (pos != -1) {
            return usuarios[pos];
        }
        return null; // Usuario no encontrado
    
}
}