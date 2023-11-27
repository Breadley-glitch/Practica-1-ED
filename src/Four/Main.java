package Four;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	    Grafo grafo = new Grafo();
	    String ruta = "C:\\Users\\jhon\\eclipse-workspace\\Final\\src\\Date.txt";

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
	    Scanner scanner = new Scanner(System.in);
	    boolean continuar = true;

	    while (continuar) {
	        System.out.println("Seleccione una opción:");
	        System.out.println("1. Determinar si dos ciudades están conectadas por una única carretera");
	        System.out.println("2. Determinar el camino más corto entre dos ciudades (distancia)");
	        System.out.println("3. Determinar el camino más corto entre dos ciudades (tiempo)");
	        System.out.println("4. Salir");
	        System.out.println("5. Grafos");
	        System.out.println("6. Matriz");


	        int opcion = scanner.nextInt();
	        scanner.nextLine();  // Consumir la línea restante

	        switch (opcion) {
	            case 1:
	            	System.out.println("Ingrese el nombre de la primera ciudad:");
	                String ciudadA = scanner.nextLine();

	                System.out.println("Ingrese el nombre de la segunda ciudad:");
	                String ciudadB = scanner.nextLine();

	                if (grafo.estanConectadas(ciudadA, ciudadB)) {
	                    System.out.println("Las ciudades " + ciudadA + " y " + ciudadB + " están conectadas por una única carretera.");
	                } else {
	                    System.out.println("Las ciudades " + ciudadA + " y " + ciudadB + " no están conectadas por una única carretera.");
	                }
	                break;
	            case 2:
	                System.out.println("Ingrese el nombre de la ciudad de origen:");
	                String ciudadA1 = scanner.nextLine();

	                System.out.println("Ingrese el nombre de la ciudad de destino:");
	                String ciudadB1 = scanner.nextLine();

	                List<String> camino = grafo.caminoMasCorto(ciudadA1, ciudadB1);

	                if (camino.isEmpty()) {
	                    System.out.println("No hay un camino entre " + ciudadA1 + " y " + ciudadB1 + ".");
	                } else {
	                    System.out.println("El camino más corto entre " + ciudadA1 + " y " + ciudadB1 + " es:");
	                    for (String ciudad : camino) {
	                        System.out.println("  " + ciudad);
	                    }
	                }
	                break;

	            case 3:
	                System.out.println("Ingrese el nombre de la ciudad de origen:");
	                String ciudadA2 = scanner.nextLine();

	                System.out.println("Ingrese el nombre de la ciudad de destino:");
	                String ciudadB2 = scanner.nextLine();

	                List<String> camino2 = grafo.caminoMasCortoTiempo(ciudadA2, ciudadB2);

	                if (camino2.isEmpty()) {
	                    System.out.println("No hay un camino entre " + ciudadA2 + " y " + ciudadB2 + ".");
	                } else {
	                    System.out.println("El camino más corto en tiempo entre " + ciudadA2 + " y " + ciudadB2 + " es:");
	                    for (String ciudad : camino2) {
	                        System.out.println("  " + ciudad);
	                    }
	                }
	                break;
	    
	            case 4:
	                continuar = false;
	                System.out.println("Has salido del programa. ¡Hasta la próxima!");
	                break;
	            default:
	                System.out.println("Opción no válida. Por favor, intente de nuevo.");
	                
	            case 5:
	                System.out.println("Imprimiendo el grafo:");
	                grafo.imprimirGrafo();
	                break;

	            case 6:
	                System.out.println("Creando e imprimiendo la matriz de adyacencia:");
	                grafo.crearMatrizAdyacencia();
	                break;
	        }
	        
	        
	    }
	    

	    scanner.close();
	}

}