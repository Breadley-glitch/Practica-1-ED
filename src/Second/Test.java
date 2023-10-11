package Second;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // Crear una nueva lista
        List myList = new List();
        Scanner scanner = new Scanner(System.in);

        Registro registro = new Registro();
        Empleado admin = new Empleado(1, "Admin", true, "admin123");
        registro.nuevoEmpleado(admin.getId(), admin.getNombre(), admin.getContrasena(), admin, null, null, null, 0, null);

        // El administrador crea un nuevo empleado
        Empleado nuevoEmpleado = registro.nuevoEmpleado(2, "Empleado", "emp123", admin, null, null, null, 0, null);

        // Imprimir los detalles del nuevo empleado
        if (nuevoEmpleado != null) {
            System.out.println("Nuevo empleado creado: " + nuevoEmpleado.getNombre());
        }
        // Imprimir los empleados guardados dentro de la lista
        registro.imprimirEmpleados();

        // Prueba de mensaje para el usuario admin
        String Testmensaje = "Este es un mensaje para el empleado.";
        nuevoEmpleado.getBandejaDeEntrada().recibirMensaje(Testmensaje);

        // Imprime el mensaje dentro de la bandeja de entrada de admin
        System.out.println(nuevoEmpleado.getBandejaDeEntrada().getMensajes());

        // Solicitar al usuario que ingrese el ID del empleado con el que desea iniciar sesión
        System.out.println("Ingrese el ID del empleado con el que desea iniciar sesión:");
        long id = scanner.nextLong();

        // Buscar al empleado en el registro
        Empleado empleado = null;
        for (Empleado e : registro.getEmpleados()) {
            if (e.getId() == id) {
                empleado = e;
                break;
            }
        }

        // Si se encontró al empleado, solicitar al usuario que ingrese la contraseña
        while (empleado != null) {
            System.out.println("Ingrese su contraseña:");
            String contrasena = scanner.next();

            // Si la contraseña es correcta, imprimir los mensajes en la bandeja de entrada del empleado
            if (empleado.getContrasena().equals(contrasena)) {
                System.out.println("Inicio de sesión exitoso. Bienvenido, " + empleado.getNombre() + ". Aquí aparecen los mensajes de la bandeja de entrada");
                Object mensaje = empleado.leerMensaje();
                while (mensaje != null) {
                    System.out.println("Mensaje: " + mensaje);
                    mensaje = empleado.leerMensaje();
                }
                break; // Romper el bucle si la contraseña es correcta
            } else {
                System.out.println("Contraseña incorrecta. Intente nuevamente.");
            }
        }

        if (empleado == null) {
            System.out.println("Empleado no encontrado.");
        }

        scanner.close();
    }
}
