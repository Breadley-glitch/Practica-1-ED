package Second;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Registro registro = new Registro();
        Scanner scanner = new Scanner(System.in);
              
        // Specify absolute file paths for Empleados.txt and Password.txt
        String empleadosFilePath ="src/Empleados.txt";
        String passwordFilePath ="src/Password.txt";
        String empleado1FilePath= "C:\\Users\\jossh\\OneDrive\\Documents\\GitHub\\Practica-1-ED\\Camila-Jimenez.txt";
        String empleado2FilePath= "C:\\Users\\jossh\\OneDrive\\Documents\\GitHub\\Practica-1-ED\\Jhon.txt";
        String empleado3FilePath= "C:\\Users\\jossh\\OneDrive\\Documents\\GitHub\\Practica-1-ED\\Joss.txt";
        String empleado4FilePath ="C:\\Users\\jossh\\OneDrive\\Documents\\GitHub\\Practica-1-ED\\Juan.txt";
        
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
        
        Empleado empleadoPorID = registro.buscarEmpleadoPorId(1);
        Empleado empleadoPorID2 = registro.buscarEmpleadoPorId(29);
        Empleado empleadoPorID3 = registro.buscarEmpleadoPorId(13);
        Empleado empleadoPorID4 = registro.buscarEmpleadoPorId(8);
        
        //empleadoPorID.redactarMensaje(registro, 0, empleado2FilePath, empleado3FilePath);;
        //empleadoPorID.getBandejaDeEntrada().recibirMensaje(null);
        //empleadoPorID.getBandejaDeBorrador().agregarBorrador(null);
        //empleadoPorID.getMensajesLeidos().agregarMensaje(null);
        
        //empleadoPorID2.redactarMensaje(registro, 0, empleado2FilePath, empleado3FilePath);;
        //empleadoPorID2.getBandejaDeEntrada().recibirMensaje(null);
        //empleadoPorID2.getBandejaDeBorrador().agregarBorrador(null);
        //empleadoPorID2.getMensajesLeidos().agregarMensaje(null);
        
        //empleadoPorID3.redactarMensaje(registro, 0, empleado2FilePath, empleado3FilePath);;
        //empleadoPorID3.getBandejaDeEntrada().recibirMensaje(null);
        //empleadoPorID3.getBandejaDeBorrador().agregarBorrador(null);
        //empleadoPorID3.getMensajesLeidos().agregarMensaje(null);
        
        
        try (BufferedReader br = new BufferedReader(new FileReader(empleado2FilePath))) {
            String linea;
            Mensaje mensaje = null;
            
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("MensajeB, ") || linea.startsWith("MensajeL, ") || linea.startsWith("MensajeD, ")) {
                    String[] partes = linea.split(", ");
                    
                    // Comprobar el tipo de mensaje (Bandeja de Entrada, Mensajes Leídos, Mensajes en Borrador)
                    String tipoMensaje = partes[0];
                    long id = Long.parseLong(partes[3]);
                    String fechaStr = partes[5];
                    String titulo = partes[7];
                    String cuerpo = partes[9];
                    
                    Date fecha = convertirFecha(fechaStr);
                    
                    // Crear un nuevo mensaje con los valores extraídos
                    mensaje = new Mensaje(id, titulo, cuerpo, fecha);
                    System.out.println("Tipo de mensaje: " + tipoMensaje);


                    // Procesar el mensaje según su tipo
                    if (tipoMensaje.equals("MensajeB")) {
                        empleadoPorID3.getBandejaDeEntrada().recibirMensaje(mensaje);
                        System.out.println("Agregado" );
                    } else if (tipoMensaje.equals("MensajeL")) {
                        System.out.println("Agregado" );
                        empleadoPorID3.getMensajesLeidos().agregarMensaje(mensaje);
                    } else if (tipoMensaje.equals("MensajeD")) {
                        System.out.println("Agregado" );
                        empleadoPorID3.guardarBorrador(mensaje);
                    }
                    
                    System.out.println(mensaje.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        try (BufferedReader br = new BufferedReader(new FileReader(empleado1FilePath))) {
            String linea;
            Mensaje mensaje = null;
            
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("MensajeB, ") || linea.startsWith("MensajeL, ") || linea.startsWith("MensajeD, ")) {
                    String[] partes = linea.split(", ");
                    
                    // Comprobar el tipo de mensaje (Bandeja de Entrada, Mensajes Leídos, Mensajes en Borrador)
                    String tipoMensaje = partes[0];
                    long id = Long.parseLong(partes[3]);
                    String fechaStr = partes[5];
                    String titulo = partes[7];
                    String cuerpo = partes[9];
                    
                    Date fecha = convertirFecha(fechaStr);
                    
                    // Crear un nuevo mensaje con los valores extraídos
                    mensaje = new Mensaje(id, titulo, cuerpo, fecha);

                    // Procesar el mensaje según su tipo
                    if (tipoMensaje.equals("MensajeB")) {
                        System.out.println("Agregado" );
                        empleadoPorID.getBandejaDeEntrada().recibirMensaje(mensaje);
                    } else if (tipoMensaje.equals("MensajeL")) {
                        System.out.println("Agregado" );
                        empleadoPorID.getMensajesLeidos().agregarMensaje(mensaje);
                    } else if (tipoMensaje.equals("MensajeD")) {
                        System.out.println("Agregado" );
                        empleadoPorID.getBandejaDeBorrador().agregarBorrador(mensaje);
                    }
                    
                    System.out.println(mensaje.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(empleado3FilePath))) {
            String linea;
            Mensaje mensaje = null;
            
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("MensajeB, ") || linea.startsWith("MensajeL, ") || linea.startsWith("MensajeD, ")) {
                    String[] partes = linea.split(", ");
                    
                    // Comprobar el tipo de mensaje (Bandeja de Entrada, Mensajes Leídos, Mensajes en Borrador)
                    String tipoMensaje = partes[0];
                    long id = Long.parseLong(partes[3]);
                    String fechaStr = partes[5];
                    String titulo = partes[7];
                    String cuerpo = partes[9];
                    
                    Date fecha = convertirFecha(fechaStr);
                    
                    // Crear un nuevo mensaje con los valores extraídos
                    mensaje = new Mensaje(id, titulo, cuerpo, fecha);

                    // Procesar el mensaje según su tipo
                    if (tipoMensaje.equals("MensajeB")) {
                        System.out.println("Agregado" );
                        empleadoPorID2.getBandejaDeEntrada().recibirMensaje(mensaje);
                    } else if (tipoMensaje.equals("MensajeL")) {
                        System.out.println("Agregado" );
                        empleadoPorID2.getMensajesLeidos().agregarMensaje(mensaje);
                    } else if (tipoMensaje.equals("MensajeD")) {
                        System.out.println("Agregado" );
                        empleadoPorID2.getBandejaDeBorrador().agregarBorrador(mensaje);
                    }
                    
                    System.out.println(mensaje.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        try (BufferedReader br = new BufferedReader(new FileReader(empleado4FilePath))) {
            String linea;
            Mensaje mensaje = null;
            
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("MensajeB, ") || linea.startsWith("MensajeL, ") || linea.startsWith("MensajeD, ")) {
                    String[] partes = linea.split(", ");
                    
                    // Comprobar el tipo de mensaje (Bandeja de Entrada, Mensajes Leídos, Mensajes en Borrador)
                    String tipoMensaje = partes[0];
                    long id = Long.parseLong(partes[3]);
                    String fechaStr = partes[5];
                    String titulo = partes[7];
                    String cuerpo = partes[9];
                    
                    Date fecha = convertirFecha(fechaStr);
                    
                    // Crear un nuevo mensaje con los valores extraídos
                    mensaje = new Mensaje(id, titulo, cuerpo, fecha);
                    System.out.println("Tipo de mensaje: " + tipoMensaje);


                    // Procesar el mensaje según su tipo
                    if (tipoMensaje.equals("MensajeB")) {
                        empleadoPorID4.getBandejaDeEntrada().recibirMensaje(mensaje);
                        System.out.println("Agregado" );
                    } else if (tipoMensaje.equals("MensajeL")) {
                        System.out.println("Agregado" );
                        empleadoPorID4.getMensajesLeidos().agregarMensaje(mensaje);
                    } else if (tipoMensaje.equals("MensajeD")) {
                        System.out.println("Agregado" );
                        empleadoPorID4.guardarBorrador(mensaje);
                    }
                    
                    System.out.println(mensaje.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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
                // Check if the inbox is empty
                if (empleado.getBandejaDeEntrada().getMensajes().isEmpty()) {
                    System.out.println("No tienes mensajes en tu bandeja de entrada.");
                } else {
                    // Call the method to print the messages in the inbox
                    empleado.getBandejaDeEntrada().imprimirMensajes();
                    System.out.println("Por favor, introduce el número del mensaje que quieres leer:");
                    int numeroMensaje = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    empleado.consultarBandejaDeEntrada(numeroMensaje);
                }
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
             	    // Consume the newline character
             	    scanner.nextLine();

             	    Empleado empleadoACambiar = registro.buscarEmpleadoPorId(idEmpleado);

             	    if (empleadoACambiar != null) {
             	        System.out.println("Introduce la nueva contraseña:");
             	        String nuevaContrasena = scanner.nextLine(); // Read the password with nextLine()
             	        empleado.cambiarContrasena(empleado, registro, empleadoACambiar, nuevaContrasena);
             	        System.out.println("Contraseña cambiada exitosamente.");

             	        // Save the changes to "Password.txt"
             	        try (BufferedReader passwordReader = new BufferedReader(new FileReader(passwordFilePath));
             	             FileWriter tempPasswordFile = new FileWriter("temp_Password.txt");
             	             BufferedWriter tempPasswordWriter = new BufferedWriter(tempPasswordFile)) {

             	            String passwordLine;
             	            while ((passwordLine = passwordReader.readLine()) != null) {
             	                String[] parts = passwordLine.split(" ");
             	                long currentId = Long.parseLong(parts[0]);
             	                String newPassword = parts[1];
             	                String userType = parts[2];

             	                if (currentId == idEmpleado) {
             	                    // Update the password for the specified ID
             	                    newPassword = nuevaContrasena;
             	                }

             	                // Write the updated line to the temporary file
             	                tempPasswordWriter.write(currentId + " " + newPassword + " " + userType);
             	                tempPasswordWriter.newLine();
             	            }
             	        } catch (IOException e) {
             	            System.err.println("Error updating Password.txt: " + e.getMessage());
             	        }

             	        // Replace the original Password.txt with the temporary file
             	        try {
             	            Files.deleteIfExists(Paths.get(passwordFilePath)); // Delete the original file
             	            Files.move(Paths.get("temp_Password.txt"), Paths.get(passwordFilePath)); // Rename the temporary file
             	        } catch (IOException e) {
             	            System.err.println("Error updating Password.txt: " + e.getMessage());
             	        }
             	    } else {
             	        System.out.println("No se encontró ningún empleado con este ID.");
             	    }
             	} else {
             	    System.out.println("No tienes permisos para realizar esta acción.");
             	}
             	continue;

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

            DoubleList empleadosDoubleList = registro.obtenerDoubleListEmpleados();
            DoubleNode actual = empleadosDoubleList.first();

            while (actual != null) {
                Empleado empleado1 = (Empleado) actual.getData();
                String nombreArchivo = empleado1.getNombre() + ".txt";

                try (FileWriter fileWriter = new FileWriter(nombreArchivo);
                     BufferedWriter writer = new BufferedWriter(fileWriter)) {

                    // Imprimir información del empleado
                    writer.write("Información del empleado:");
                    writer.newLine();
                    writer.write(empleado1.toString());
                    writer.newLine();
                    writer.newLine();

                    // Imprimir mensajes de BandejaDeEntrada
                    writer.write("Mensajes en Bandeja de Entrada:");
                    writer.newLine();
                    empleado1.getBandejaDeEntrada().escribirMensajesEnArchivo(writer);
                    writer.newLine();

                    // Imprimir mensajes de MensajesLeidos
                    writer.write("Mensajes Leídos:");
                    writer.newLine();
                    empleado1.getMensajesLeidos().escribirMensajesEnArchivo(writer);
                    writer.newLine();

                    // Imprimir mensajes del Borrador
                    writer.write("Mensajes en Borrador:");
                    writer.newLine();
                    empleado1.getBandejaDeBorrador().escribirMensajesEnArchivo(writer);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                actual = actual.getNext();
            }

            System.exit(0);
            break;



        case 9:
        	System.out.println("Bandeja de Leídos:");
        	empleado.getMensajesLeidos().imprimirMensajes();
        	break;
        case 10:
            Borrador borrador = empleado.getBandejaDeBorrador(); // Get the Borrador object from the employee
            Stack mensajes = borrador.getMensajes(); // Get the draft messages from the Borrador

            if (mensajes.isEmpty()) {
                System.out.println("No tienes borradores.");
                break;
            }

            System.out.println("Borrador:");
            
            // Iterate through and print the draft messages
            Mensaje draftMessage = (Mensaje) mensajes.top();
            System.out.println("Título: " + draftMessage.getTitulo());
            System.out.println("Cuerpo: " + draftMessage.getCuerpo());
            System.out.println();

            // Ask the user what they want to do with the draft message
            System.out.println("¿Qué te gustaría hacer con este mensaje?");
            System.out.println("1. Enviar");
            System.out.println("2. Descartar");
            int opcionMensaje = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea pendiente

            switch (opcionMensaje) {
                case 1:
                	System.out.println("ID de la persona que quieres agregar");
                    // You'll need to ask for the recipient's ID and use it here
                    long idc1 = scanner.nextLong();
                    empleado.redactarMensaje(registro, idc1, draftMessage.getTitulo(), draftMessage.getCuerpo());
                    System.out.println("Mensaje enviado exitosamente.");
                    break;
                case 2:
                    // Discard the message
                    mensajes.pop(); // Remove the message from the top of the stack
                    System.out.println("Mensaje descartado.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
                    break;
            }
            break;




            	} 
            }
        }    
    }
    
    
    private static Date convertirFecha(String fechaString) {
        fechaString = fechaString.replace(" COT", "");
        SimpleDateFormat formato = new SimpleDateFormat("E MMM dd HH:mm:ss yyyy", Locale.ENGLISH);
        try {
            return formato.parse(fechaString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}