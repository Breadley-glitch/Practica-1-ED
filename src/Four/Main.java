package Four;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
    	System.out.println("Helloworld");
        Grafo grafo = new Grafo();
        String ruta = "C:\\Users\\jossh\\eclipse-workspace\\FinalProject\\src\\Date.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String origen = partes[0];
                String destino = partes[1];
                int distancia = Integer.parseInt(partes[2]);
                int tiempo = Integer.parseInt(partes[3]);
                grafo.agregarCarretera(origen, destino, distancia, tiempo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        grafo.imprimirGrafo();
        grafo.crearMatrizAdyacencia();

    }
}