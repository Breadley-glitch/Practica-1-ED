package Four;
import java.util.*;


class Grafo {
    Map<String, Ciudad> ciudades;
    List<String> nombresCiudades;

    Grafo() {
        this.ciudades = new HashMap<>();
        this.nombresCiudades = new ArrayList<>();
    }

    void agregarCarretera(String origen, String destino, int distancia, int tiempo) {
        Ciudad ciudadOrigen = this.ciudades.getOrDefault(origen, new Ciudad(origen));
        Ciudad ciudadDestino = this.ciudades.getOrDefault(destino, new Ciudad(destino));

        ciudadOrigen.carreteras.add(new Carretera(ciudadDestino, distancia, tiempo));
        ciudadDestino.carreteras.add(new Carretera(ciudadOrigen, distancia, tiempo));

        this.ciudades.put(origen, ciudadOrigen);
        this.ciudades.put(destino, ciudadDestino);

        if (!this.nombresCiudades.contains(origen)) {
            this.nombresCiudades.add(origen);
        }
        if (!this.nombresCiudades.contains(destino)) {
            this.nombresCiudades.add(destino);
        }
    }

    void imprimirGrafo() {
        for (Ciudad ciudad : this.ciudades.values()) {
            System.out.println("Ciudad: " + ciudad.nombre);
            for (Carretera carretera : ciudad.carreteras) {
                System.out.println("  Carretera a " + carretera.destino.nombre + ", Distancia: " + carretera.distancia + ", Tiempo: " + carretera.tiempo);
            }
        }
    }

    void crearMatrizAdyacencia() {
        int n = this.nombresCiudades.size();
        int[][] matriz = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(matriz[i], Integer.MAX_VALUE);
            matriz[i][i] = 0;
        }

        for (Ciudad ciudad : this.ciudades.values()) {
            int indiceOrigen = this.nombresCiudades.indexOf(ciudad.nombre);
            for (Carretera carretera : ciudad.carreteras) {
                int indiceDestino = this.nombresCiudades.indexOf(carretera.destino.nombre);
                matriz[indiceOrigen][indiceDestino] = carretera.distancia;
            }
        }

        System.out.print("      ");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-10s ", this.nombresCiudades.get(i));
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.printf("%-10s ", this.nombresCiudades.get(i));
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF       ");
                } else {
                    System.out.printf("%-10d ", matriz[i][j]);
                }
            }
            System.out.println();
        }
    }
    
    
    boolean estanConectadas(String ciudadA, String ciudadB) {
        Ciudad ciudadOrigen = this.ciudades.get(ciudadA);
        if (ciudadOrigen == null) {
            System.out.println("La ciudad " + ciudadA + " no existe en el grafo.");
            return false;
        }

        for (Carretera carretera : ciudadOrigen.carreteras) {
            if (carretera.destino.nombre.equals(ciudadB)) {
                return true;
            }
        }

        return false;
    }
    
    List<String> caminoMasCorto(String ciudadA, String ciudadB) {
        Map<String, Integer> distancias = new HashMap<>();
        Map<String, String> predecesores = new HashMap<>();
        PriorityQueue<Ciudad> cola = new PriorityQueue<>(Comparator.comparingInt(ciudad -> distancias.get(ciudad.nombre)));

        for (String nombreCiudad : this.nombresCiudades) {
            distancias.put(nombreCiudad, Integer.MAX_VALUE);
        }
        distancias.put(ciudadA, 0);

        cola.add(this.ciudades.get(ciudadA));

        while (!cola.isEmpty()) {
            Ciudad ciudadActual = cola.poll();

            for (Carretera carretera : ciudadActual.carreteras) {
                int distanciaAlternativa = distancias.get(ciudadActual.nombre) + carretera.distancia;
                if (distanciaAlternativa < distancias.get(carretera.destino.nombre)) {
                    distancias.put(carretera.destino.nombre, distanciaAlternativa);
                    predecesores.put(carretera.destino.nombre, ciudadActual.nombre);
                    cola.add(carretera.destino);
                }
            }
        }

        List<String> camino = new ArrayList<>();
        for (String ciudad = ciudadB; ciudad != null; ciudad = predecesores.get(ciudad)) {
            camino.add(ciudad);
        }
        Collections.reverse(camino);

        return camino;
    }
    
    List<String> caminoMasCortoTiempo(String ciudadA, String ciudadB) {
        Map<String, Integer> tiempos = new HashMap<>();
        Map<String, String> predecesores = new HashMap<>();
        PriorityQueue<Ciudad> cola = new PriorityQueue<>(Comparator.comparingInt(ciudad -> tiempos.get(ciudad.nombre)));

        for (String nombreCiudad : this.nombresCiudades) {
            tiempos.put(nombreCiudad, Integer.MAX_VALUE);
        }
        tiempos.put(ciudadA, 0);

        cola.add(this.ciudades.get(ciudadA));

        while (!cola.isEmpty()) {
            Ciudad ciudadActual = cola.poll();

            for (Carretera carretera : ciudadActual.carreteras) {
                int tiempoAlternativo = tiempos.get(ciudadActual.nombre) + carretera.tiempo;
                if (tiempoAlternativo < tiempos.get(carretera.destino.nombre)) {
                    tiempos.put(carretera.destino.nombre, tiempoAlternativo);
                    predecesores.put(carretera.destino.nombre, ciudadActual.nombre);
                    cola.add(carretera.destino);
                }
            }
        }

        List<String> camino = new ArrayList<>();
        for (String ciudad = ciudadB; ciudad != null; ciudad = predecesores.get(ciudad)) {
            camino.add(ciudad);
        }
        Collections.reverse(camino);

        return camino;
    }




}
