package Second;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Test2 {
    public static void main(String[] args) {
        Registro registro = new Registro();

        // Specify absolute file paths for Empleados.txt and Password.txt
        String empleadosFilePath = "C:/Users/jossh/OneDrive/Documents/GitHub/Practica-1-ED/Empleados.txt";
        String passwordFilePath = "C:/Users/jossh/OneDrive/Documents/GitHub/Practica-1-ED/Password.txt";

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
                            if (empleadosParts.length >= 15 && passwordParts.length >= 3) {
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
                                registro.addEmpleadoToList(empleado); // Store the employee in empleadoList
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

        // Print the list of employees created from empleadoList
        ArrayList<Empleado> employeesList = registro.getEmpleadoList(); // Use getEmpleadoList
        System.out.println("List of Employees:");
        for (Empleado employee : employeesList) {
            System.out.println(employee.toString());
        }

        // The rest of your code to handle login and other operations.
    }
}

