package Usuarios;
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
        Registro registro = new Registro();
        Usuario u1 = new Usuario(1, "Juan");
        Usuario u2 = new Usuario(2, "Pedro");
        Usuario u3 = new Usuario(3, "Maria");

        // Agregar usuarios al registro
        registro.agregar(u1);
        registro.agregar(u2);
        registro.agregar(u3);

        // Verificar que los usuarios se agregaron correctamente
        ArrayList<Usuario> usuarios = registro.getRegistro();
        for (Usuario u : usuarios) {
            System.out.println(u.getNombre());
        }

        // Eliminar un usuario del registro
        //registro.eliminar(2);

        // Verificar que el usuario se eliminó correctamente
        usuarios = registro.getRegistro();
        for (Usuario u : usuarios) {
            System.out.println(u.getNombre());
        }
        
     // Buscar la posición de un usuario en el registro
        int posicion = registro.buscarPosicion(2);
        System.out.println("La posición de Pedro en el registro es: " + posicion);

        // Buscar un usuario en el registro por su ID
        Usuario usuario = registro.buscarUsuario(3);
        System.out.println("El usuario con ID 3 es: " + usuario.getNombre());
    }
    }
	



