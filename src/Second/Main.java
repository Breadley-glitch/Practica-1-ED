package Second;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // Ruta al archivo Joss.txt
        String archivoJoss = "Joss.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(archivoJoss))) {
            String linea;
            Mensaje mensaje = null;

            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("Mensaje, ")) {
                    // Separar la línea en partes usando coma como delimitador
                    String[] partes = linea.split(", ");

                    // Extraer los valores de la línea
                    long id = Long.parseLong(partes[3]);
                    String fechaStr = partes[5];
                    String titulo = partes[7];
                    String cuerpo = partes[9];

                    // Convertir la fecha de texto a objeto Date
                    Date fecha = convertirFecha(fechaStr);

                    // Crear un nuevo mensaje con los valores extraídos
                    mensaje = new Mensaje(id, titulo, cuerpo, fecha);
                } else if (mensaje != null) {
                    // Agregar el mensaje a la bandeja de entrada o a otra estructura
                    // (Debes adaptar esto a tu estructura específica)
                    // Ejemplo: empleado.getBandejaDeEntrada().recibirMensaje(mensaje);
                    System.out.println(mensaje.toString());

                    // Reiniciar el mensaje para el próximo conjunto de datos
                    mensaje = null;
                }
            }

            // Comprobar si quedó un mensaje sin imprimir al final del archivo
            if (mensaje != null) {
                // Agregar el mensaje a la bandeja de entrada o a otra estructura
                // (Debes adaptar esto a tu estructura específica)
                // Ejemplo: empleado.getBandejaDeEntrada().recibirMensaje(mensaje);
                System.out.println(mensaje.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
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


