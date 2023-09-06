package Usuarios;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        Registro registro = new Registro(5);

        Usuario u1 = new Usuario(1, "Juan");
        Usuario u2 = new Usuario(2, "Maria");
        Usuario u3 = new Usuario(3, "Pedro");
        Usuario u4 = new Usuario(4, "Lucia");
        Usuario u5 = new Usuario(5, "Sofia");
        
        Fecha fecha1 = new Fecha(29,9,2003);
        Fecha fecha2 = new Fecha(20,8,2000);
        Fecha fecha3 = new Fecha(9,7,2003);
        Fecha fecha4 = new Fecha(1,6,2003);
        Fecha fecha5 = new Fecha(1,11,2003);
        
        Direccion direccion1 = new Direccion("Carrera",17,"La union","Barranquilla");
        
        u1.setEmail("elperro@unal.edu.co");
        u1.setCiudadNacimiento("Barranquilla");
        u1.setFechaNacimiento(fecha1);
        u1.setDireccion(direccion1);
        u1.setTelefono(315284677);
        

        System.out.println("Agregando usuarios...");
        System.out.println(registro.agregar(u3)); // true
        System.out.println(registro.agregar(u1)); // true
        System.out.println(registro.agregar(u2)); // true
        System.out.println(registro.agregar(u5)); // true
        System.out.println(registro.agregar(u4)); // true
        
        
        System.out.println("Final array después de agregar usuarios:");
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

        System.out.println("Final array después de remover user:");
        printRegistro(registro);

        System.out.println("Buscando un usuario existente...");
        String foundUser = registro.buscarUsuario(2);
        System.out.println(foundUser); 

        System.out.println("Buscando un usuario no existente...");
        String notFoundUser = registro.buscarUsuario(6);
        System.out.println(notFoundUser); 

        saveRegistroToFile(registro, "registro.txt");

        readRegistroFromFile("registro.txt");
    }

    private static void printRegistro(Registro registro) {
        for (Usuario usuario : registro.getRegistro()) {
            if (usuario != null) {
                System.out.println(usuario);
            }
        }
    }
    private static void saveRegistroToFile(Registro registro, String filename) {//
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Usuario usuario : registro.getRegistro()) {
                if (usuario != null) {
                    writer.write(usuario.getId() + ", " + usuario.getNombre() + ", ");
                    if (usuario.getFechaNacimiento() != null) {
                        writer.write(usuario.getFechaNacimiento().getDia() + "," + usuario.getFechaNacimiento().getMes() + "," + usuario.getFechaNacimiento().getAnio() + ", ");
                    } else {
                        writer.write("null, null, null, ");
                    }
                    writer.write(usuario.getCiudadNacimiento() + ", ");
                    if (usuario.getDireccion() != null) {
                        writer.write(usuario.getDireccion().getCalle() + ", " + usuario.getDireccion().getNoCalle() + ", " + usuario.getDireccion().getBarrio() + ", " + usuario.getDireccion().getCiudad() + ", ");
                    } else {
                        writer.write("null, null, null, null, ");
                    }
                    writer.write(usuario.getTelefono() + ", " + usuario.getEmail());
                    writer.newLine();
                }
            }
            System.out.println("Usuarios guardados en " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void readRegistroFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
	
