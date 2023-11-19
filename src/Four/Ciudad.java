package Four;

import java.util.*;

class Ciudad {
    String nombre;
    List<Carretera> carreteras;

    Ciudad(String nombre) {
        this.nombre = nombre;
        this.carreteras = new ArrayList<>();
    }
}