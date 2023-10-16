package Second;
import java.util.Scanner;

public class TestF {
    Scanner scanner = new Scanner(System.in);
    
    static void EnviarMensajes(Registro a) {
    System.out.println("Introduce la cédula del usuario al que quieres enviar el mensaje:");
    long idc = scanner.nextLong();
    Empleado empleadoExistente = registro.buscarEmpleadoPorId(idc);
    if (empleadoExistente == null) {
        System.out.println("ID inexistente. Prueba con otra ID.");
    } else {
        System.out.println("Introduce el título del mensaje:");
        String titulo = scanner.next();
        System.out.println("Introduce el mensaje:");
        String cuerpo = scanner.next();
        System.out.println("¿Qué te gustaría hacer con este mensaje?");
        System.out.println("1. Enviar");
        System.out.println("2. Descartar");
        System.out.println("3. Guardar como borrador");
        System.out.println("4. Ir al menu principal");

        int opcionMensaje = scanner.nextInt();
        scanner.nextLine();

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
            // Guardar el mensaje como borrador
            empleado.guardarBorrador(titulo, cuerpo);
            System.out.println("Mensaje guardado como borrador.");
            break;
       
        case 4:
            // Volver al menú principal
            System.out.println("Volviendo al menú principal...");
            continue;
        default:
           System.out.println("Opción no válida. Por favor, intenta de nuevo.");
        	
        }

    }
    }
}
