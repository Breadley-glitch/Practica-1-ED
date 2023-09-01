package Usuarios;

public class Test {
    public static void main(String[] args) {
        Registro registro = new Registro(5);

        Usuario u1 = new Usuario(1, "Juan");
        Usuario u2 = new Usuario(2, "Maria");
        Usuario u3 = new Usuario(3, "Pedro");
        Usuario u4 = new Usuario(4, "Lucia");
        Usuario u5 = new Usuario(5, "Sofia");

        System.out.println("Agregando usuarios...");
        System.out.println(registro.agregar(u3)); // true
        System.out.println(registro.agregar(u1)); // true
        System.out.println(registro.agregar(u2)); // true
        System.out.println(registro.agregar(u5)); // true
        System.out.println(registro.agregar(u4)); // true

        System.out.println("Final array after adding users:");
        printRegistro(registro);

        System.out.println("Intentando agregar un usuario con un ID ya existente...");
        System.out.println(registro.agregar(u1)); // false

        System.out.println("Intentando agregar un usuario cuando el registro está lleno...");
        System.out.println(registro.agregar(new Usuario(6, "Carlos"))); // false

        System.out.println("Eliminando un usuario...");
        Usuario removedUser = registro.eliminar(3);
        if (removedUser != null) {
            System.out.println(removedUser.getNombre()); // Pedro
        } else {
            System.out.println("No se encontró un usuario con el ID especificado.");
        }

        System.out.println("Final array after removing user:");
        printRegistro(registro);

        System.out.println("Buscando un usuario existente...");
        String foundUser = registro.buscarUsuario(2);
        System.out.println(foundUser); // Usuario [id=2, nombre=Maria, ...]

        System.out.println("Buscando un usuario no existente...");
        String notFoundUser = registro.buscarUsuario(6);
        System.out.println(notFoundUser); // No se encontró un usuario con el ID especificado.
    }

    private static void printRegistro(Registro registro) {
        for (Usuario usuario : registro.getRegistro()) {
            if (usuario != null) {
                System.out.println(usuario);
            }
        }
    }
}
