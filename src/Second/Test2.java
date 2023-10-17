package Second;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
        String empleadosFilePath ="src/Empleados.txt";
        String passwordFilePath ="src/Password.txt";
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
        
        
        //Interfaz
        while (true) {
            System.out.println("Por favor, introduce tu ID:");
            long id = scanner.nextLong();
            Empleado empleado = registro.buscarEmpleadoPorId(id);
            if (empleado == null) {
                System.out.println("No se encontró ningún empleado con este ID.");
                continue;
            }
            System.out.println("Por favor, introduce tu contraseña:");
            String contrasena = scanner.next();
            if (!empleado.getContrasena().equals(contrasena)) {
                System.out.println("Contraseña incorrecta.");
                continue;
            }
            System.out.println("¡Inicio de sesión exitoso! ¡Bienvenido, " + empleado.getNombre() + "!");
            
            boolean loggedIn = true;

            while (loggedIn) {
                System.out.println("Por favor, selecciona una opción: " + empleado.getNombre());
                System.out.println("1. Enviar mensaje");
                System.out.println("2. Bandeja de entrada");
                if (empleado.isAdministrador()) {
                    System.out.println("3. Crear nuevo empleado");
                    System.out.println("4. Cambiar contraseña de empleado");
                    System.out.println("5. Eliminar empleado");
                    System.out.println("6.Ver empleados");
                }
                System.out.println("7. Cerrar sesión");
                System.out.println("8. Salir");
                System.out.println("9. Bandeja de Leidos");
                System.out.println("10. Bandeja de Borrador");

                int opcion = scanner.nextInt();
                scanner.nextLine();
            switch (opcion) {

            	
            case 1:
                System.out.println("Introduce el id del usuario al que quieres enviar el mensaje:");
                long idc = scanner.nextLong();
                Empleado empleadoExistente = registro.buscarEmpleadoPorId(idc);
                if (empleadoExistente == null) {
                    System.out.println("ID inexistente. Prueba con otra ID.");
                    continue; // Vuelve al menú principal
                } else {
                    System.out.println("Introduce el título del mensaje:");
                    String titulo = scanner.next();
                    System.out.println("Introduce el mensaje:");
                    String cuerpo = scanner.next();
                    System.out.println("¿Qué te gustaría hacer con este mensaje?");
                    System.out.println("1. Enviar");
                    System.out.println("2. Descartar");
                    System.out.println("3. Guardar como borrador");
                    int opcionMensaje = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea pendiente
                    switch (opcionMensaje) {
                        case 1:
                            // Enviar el mensaje
                            empleado.redactarMensaje(registro, idc, titulo, cuerpo);
                            System.out.println("Mensaje enviado exitosamente.");
                            break;
                        case 2:
                            // Descartar el mensaje
                            System.out.println("Mensaje descartado.");
                            break;
                        case 3:
                            Mensaje mes = new Mensaje(id, titulo, cuerpo);
                            empleado.guardarBorrador(mes);
                            System.out.println("Mensaje guardado como borrador.");

                            // Get the Borrador object
                            Borrador borrador = empleado.getBandejaDeBorrador();
                            
                            // Get the draft messages from the Borrador
                            Stack mensajes = borrador.getMensajes();

                            System.out.println("Borrador:");
                            
                            // Iterate through and print the draft messages
                                Mensaje draftMessage = (Mensaje) mensajes.top();
                                System.out.println("Título: " + draftMessage.getTitulo());
                                System.out.println("Cuerpo: " + draftMessage.getCuerpo());
                                System.out.println();
                            
                            break;

                        default:
                            System.out.println("Opción no válida. Por favor, intenta de nuevo.");
                            break;
                    }
                }
                continue; // Vuelve al menú principal
             // ...

             case 2:
            	        System.out.println("Bandeja de entrada:");
            	        // Llamada al método para imprimir los mensajes en la bandeja de entrada
            	        empleado.getBandejaDeEntrada().imprimirMensajes();
            	        System.out.println("Por favor, introduce el número del mensaje que quieres leer:");
            	        int numeroMensaje = scanner.nextInt();
            	        scanner.nextLine(); // Consumir la nueva línea pendiente
            	        empleado.consultarBandejaDeEntrada(numeroMensaje);   
            	        
            	    continue; 
                    
                
             case 3:
            	    if (empleado.isAdministrador()) {
            	        System.out.println("Introduce el nombre del nuevo empleado:");
            	        String nombre = scanner.nextLine();
            	        System.out.println("Introduce el ID del nuevo empleado:");
            	        long idc1 = scanner.nextLong();
            	        // Verificar si el ID ya existe
            	        Empleado empleadoExistente1 = registro.buscarEmpleadoPorId(idc1);
            	        if (empleadoExistente1 != null) {
            	            System.out.println("ID existente. Prueba con otra ID.");
            	            continue; // Vuelve al menú principal
            	        } else {
            	            System.out.println("Introduce la contraseña del nuevo empleado:");
            	            String contrasenac = scanner.next();
            	            Empleado nuevoEmpleado = new Empleado(idc1, nombre, contrasenac);
            	            empleado.crearEmpleado(empleado, registro, nuevoEmpleado); 
            	            System.out.println("Empleado creado exitosamente.");

            	            // Actualizar Empleados.txt
            	            try (FileWriter empleadosWriter = new FileWriter(empleadosFilePath, true);
            	                 BufferedWriter empleadosBufferedWriter = new BufferedWriter(empleadosWriter)) {
            	                empleadosBufferedWriter.write(nombre + " " + idc1 + " 0 0 0 null 0 null null null null null");
            	                empleadosBufferedWriter.newLine();
            	            } catch (IOException e) {
            	                System.err.println("Error writing to Empleados.txt: " + e.getMessage());
            	            }

            	            // Actualizar Password.txt
            	            try (FileWriter passwordWriter = new FileWriter(passwordFilePath, true);
            	                 BufferedWriter passwordBufferedWriter = new BufferedWriter(passwordWriter)) {
            	                passwordBufferedWriter.write(idc1 + " " + contrasenac + " empleado");
            	                passwordBufferedWriter.newLine();
            	            } catch (IOException e) {
            	                System.err.println("Error writing to Password.txt: " + e.getMessage());
            	            }
            	        }
            	    } else {
            	        System.out.println("No tienes permisos para realizar esta acción.");
            	    }
            	    continue;

        
            
                
        case 4:
            if (empleado.isAdministrador()) {
                System.out.println("Introduce el ID del empleado al que quieres cambiar la contraseña:");
                long idEmpleado = scanner.nextLong();
                Empleado empleadoACambiar = registro.buscarEmpleadoPorId(idEmpleado);
                
                if (empleadoACambiar != null) {
                    System.out.println("Introduce la nueva contraseña:");
                    String nuevaContrasena = scanner.nextLine();
                    empleado.cambiarContrasena(empleado, registro, empleadoACambiar, nuevaContrasena);
                    System.out.println("Contraseña cambiada exitosamente.");
                } else {
                    System.out.println("No se encontró ningún empleado con este ID.");
                }
            } else {
                System.out.println("No tienes permisos para realizar esta acción.");
            }
            continue; // Vuelve al menú principal

        case 5:
            if (empleado.isAdministrador()) {
                System.out.println("Introduce el ID del empleado que quieres eliminar:");
                long idEmpleado = scanner.nextLong();
                registro.eliminarEmpleadoPorId(idEmpleado);
                System.out.println("Empleado eliminado exitosamente.");
            } else {
                System.out.println("No tienes permisos para realizar esta acción.");
            }
            continue; // Vuelve al menú principal
        case 6:
            if (empleado.isAdministrador()) {
                System.out.println("Lista de empleados:");
                registro.imprimirEmpleados();
            } else {
                System.out.println("No tienes permisos para realizar esta acción.");
            }
            continue;
        case 7:
        	System.out.println("Cerrando sesión...");
        	loggedIn =false;
        	break;
        case 8:
            System.out.println("Saliendo...");
            System.exit(0);
        case 9:
        	System.out.println("Bandeja de Leídos:");
        	empleado.getMensajesLeidos().imprimirMensajes();
        	break;
        case 10:
            Borrador borrador = empleado.getBandejaDeBorrador(); // Get the Borrador object from the employee
            System.out.println("Borrador:");
            
            // Get the draft messages from the Borrador
            Stack mensajes = borrador.getMensajes();

            // Iterate through and print the draft messages
            
                Mensaje draftMessage = (Mensaje) mensajes.top();
                System.out.println("Título: " + draftMessage.getTitulo());
                System.out.println("Cuerpo: " + draftMessage.getCuerpo());
                System.out.println();
            
            break;





            	} 
            }
        }    
    } 
}