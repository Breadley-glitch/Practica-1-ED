package Third;
public class Usuario {
    String nombre;
    int identificacion;

    public Usuario(String nombre, int identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    int calcularClave() {
        int suma = 0;
        int numero = identificacion;
        while (numero != 0) {
            suma = suma + numero % 10;
            numero = numero / 10;
        }
        return suma;
     }
    @Override
    public String toString() {
        return "Nombre: " + this.nombre + ", Identificación: " + this.identificacion;
    }
  }