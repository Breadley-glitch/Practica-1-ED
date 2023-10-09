package Second;

import java.util.ArrayList;

public class Registro {
    private ArrayList<Empleado> empleados;

    public Registro() {
        empleados = new ArrayList<>();
    }

    public Empleado nuevoEmpleado( long id, String nombre, String contrasena,Empleado administrador, Fecha fecha_Nac, String ciudad_Nac, Direccion direccion, long telefono, String email) {
        if (administrador.isAdministrador()) {
            Empleado nuevoEmpleado = new Empleado(id, nombre, contrasena);
            empleados.add(nuevoEmpleado);
            return nuevoEmpleado;
        } else {
            System.out.println("Acción no permitida. Solo los administradores pueden crear nuevos empleados.");
            return null;
        }
    }

    public void eliminarEmpleado(Empleado administrador, Empleado empleado) {
        if (administrador.isAdministrador()) {
            empleados.remove(empleado);
        } else {
            System.out.println("Acción no permitida. Solo los administradores pueden eliminar empleados.");
        }
    }

    public void cambiarContrasena(Empleado administrador, Empleado empleado, String nuevaContrasena) {
        if (administrador.isAdministrador()) {
            empleado.setContrasena(nuevaContrasena);
        } else {
            System.out.println("Acción no permitida. Solo los administradores pueden cambiar contraseñas.");
        }
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }
    public void imprimirEmpleados() {
        for (Empleado empleado : empleados) {
            System.out.println(empleado.toString());
        }
    }
}
