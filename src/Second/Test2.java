package Second;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Registro registro = new Registro();
        Scanner scanner = new Scanner(System.in);
        
        Empleado admin1 = new Empleado("Admin", 1, 1, 1, 2000, "CiudadAdmin", 1234567890L, "admin@empresa.com", "CalleAdmin", "1A", "BarrioAdmin", "CiudadAdmin", "admin123", "administrador");
        registro.newEmpleado(admin1);

        // Crear un usuario normal
        Empleado user = new Empleado(2L, "User", "user123");
        registro.newEmpleado(user);
        
        Empleado user2 = new Empleado(3L, "User2", "user123");
        registro.newEmpleado(user2);
        
        // Specify absolute file paths for Empleados.txt and Password.txt
        String empleadosFilePath ="C:/Users/jhon/Documents/GitHub/Practica-1-ED/Empleados.txt";
        String passwordFilePath ="C:/Users/jhon/Documents/GitHub/Practica-1-ED/Password.txt";
        try (BufferedReader passwordReader = new BufferedReader(new FileReader(passwordFilePath))) {
            String passwordLine;
            int lineCount = 0;
            while ((passwordLine = passwordReader.readLine()) != null) {
                // Read the corresponding line from Empleados.txt
                try (BufferedReader empleadosReader = new BufferedReader(new FileReader(empleadosFilePath))) {
                    String empleadosLine;
                    int currentLine = 0;
                    while ((empleadosLine = empleadosReader.readLine()) != null) {
                        if (currentLine == lineCount) {
                            String[] empleadosParts = empleadosLine.split(" ");
                            String[] passwordParts = passwordLine.split(" ");
                            if (empleadosParts.length <= 15 && passwordParts.length <= 3) {
                                String nombre = empleadosParts[0];
                                long id = Long.parseLong(empleadosParts[1]);
                                int dia = Integer.parseInt(empleadosParts[2]);
                                int mes = Integer.parseInt(empleadosParts[3]);
                                int ano = Integer.parseInt(empleadosParts[4]);
                                String ciudad = empleadosParts[5];
                                long tel = Long.parseLong(empleadosParts[6]);
                                String correo = empleadosParts[7];
                                String calle = empleadosParts[8];
                                String num = empleadosParts[9];
                                String barrio = empleadosParts[10];
                                String city = empleadosParts[11];
                                String contrasena = passwordParts[1]; // Read the password from Password.txt
                                String admin = passwordParts[2]; // Read the admin status

                                Empleado empleado = new Empleado(nombre, id, dia, mes, ano, ciudad, tel, correo, calle, num, barrio, city, contrasena, admin);
                                registro.newEmpleado(empleado);
                                // Print the employee object right after it's created
                                // System.out.println(empleado.toString());
                                break;
                            }
                        }
                        currentLine++;
                    }
                } catch (IOException e) {
                    System.err.println("Error reading Empleados.txt: " + e.getMessage());
                }

                lineCount++;
            }
        } catch (IOException e) {
            System.err.println("Error reading Password.txt: " + e.getMessage());
        }
        System.out.println("Por favor, introduce tu ID:");
        long id = scanner.nextLong();
        Empleado empleado = registro.buscarEmpleadoPorId(id);
        if (empleado == null) {
            System.out.println("No se encontró ningún empleado con este ID.");
            return;
        }
        System.out.println("Por favor, introduce tu contraseña:");
        String contrasena = scanner.next();
        if (!empleado.getContrasena().equals(contrasena)) {
            System.out.println("Contraseña incorrecta.");
            return;
        }
        System.out.println("¡Inicio de sesión exitoso! ¡Bienvenido, " + empleado.getNombre() + "!");
        while (true) {
            System.out.println("Por favor, selecciona una opción: " + empleado.getNombre());
            System.out.println("1. Leer mensaje");
            System.out.println("2. Ver mensajes leídos");
            if (empleado.isAdministrador()) {
                System.out.println("3. Crear nuevo empleado");
                System.out.println("4. Cambiar contraseña de empleado");
                System.out.println("5. Eliminar empleado");
            }
            System.out.println("6. Salir");
            
            int opcion = scanner.nextInt();
            
            // Your existing code...
            
            if (opcion == 3 && empleado.isAdministrador()) {
            	System.out.println("Introduce el nombre del nuevo empleado:");
                String nombre = scanner.next();
                System.out.println("Introduce el ID del nuevo empleado:");
                long idc = scanner.nextLong();
                System.out.println("Introduce la contraseña del nuevo empleado:");
                String contrasenac = scanner.next();
                
                Empleado nuevoEmpleado = new Empleado(id, nombre, contrasena);
                empleado.crearEmpleado(empleado, registro, nuevoEmpleado); 
                
            } else if (opcion == 4 && empleado.isAdministrador()) {
            	System.out.println("Introduce el ID del empleado al que quieres cambiar la contraseña:");
                long idEmpleado = scanner.nextLong();
                Empleado empleadoACambiar = registro.buscarEmpleadoPorId(idEmpleado);
                
                if (empleadoACambiar != null) {
                    System.out.println("Introduce la nueva contraseña:");
                    String nuevaContrasena = scanner.next();
                    empleado.cambiarContrasena(empleado, registro, empleadoACambiar, nuevaContrasena);
                } else {
                    System.out.println("No se encontró ningún empleado con este ID.");
                }
            } else if (opcion == 5 && empleado.isAdministrador()) {
                registro.imprimirEmpleados();

            } else if (opcion == 6) {
                break;
            } else {
                System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
        }
        
        scanner.close();
    } 
}
     
    
