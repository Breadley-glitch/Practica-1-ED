package Four;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

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
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la primera ciudad:");
        String ciudadA = scanner.nextLine();

        System.out.println("Ingrese el nombre de la segunda ciudad:");
        String ciudadB = scanner.nextLine();

        if (grafo.estanConectadas(ciudadA, ciudadB)) {
            System.out.println("Las ciudades " + ciudadA + " y " + ciudadB + " están conectadas por una única carretera.");
        } else {
            System.out.println("Las ciudades " + ciudadA + " y " + ciudadB + " no están conectadas por una única carretera.");
        }
        
        
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la ciudad de origen:");
        String ciudadA1 = scanner1.nextLine();

        System.out.println("Ingrese el nombre de la ciudad de destino:");
        String ciudadB1 = scanner1.nextLine();

        List<String> camino = grafo.caminoMasCorto(ciudadA1, ciudadB1);

        if (camino.isEmpty()) {
            System.out.println("No hay un camino entre " + ciudadA1 + " y " + ciudadB1 + ".");
        } else {
            System.out.println("El camino más corto entre " + ciudadA1 + " y " + ciudadB1 + " es:");
            for (String ciudad : camino) {
                System.out.println("  " + ciudad);
            }
        }
        
        
        Scanner scanner2 = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la ciudad de origen:");
        String ciudadA2 = scanner.nextLine();

        System.out.println("Ingrese el nombre de la ciudad de destino:");
        String ciudadB2 = scanner.nextLine();

        List<String> camino2 = grafo.caminoMasCortoTiempo(ciudadA, ciudadB);

        if (camino.isEmpty()) {
            System.out.println("No hay un camino entre " + ciudadA2 + " y " + ciudadB2 + ".");
        } else {
            System.out.println("El camino más corto en tiempo entre " + ciudadA2 + " y " + ciudadB2 + " es:");
            for (String ciudad : camino2) {
                System.out.println("  " + ciudad);
            }
        }
    }
    
    void encontrarCaminoMasCortoTiempo() {
        
    }



}