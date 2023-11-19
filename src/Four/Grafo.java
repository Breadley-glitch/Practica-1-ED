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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] == Integer.MAX_VALUE) {
                    System.out.print("000 ");
                } else {
                    System.out.print(matriz[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
