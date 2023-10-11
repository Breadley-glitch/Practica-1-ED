	package Second;
	
	import java.util.ArrayList;
	
	public class Registro {
	    private ArrayList<Empleado> empleados;
	    private ArrayList<Empleado> empleadoList;
	
	    public Registro() {
	        empleados = new ArrayList<>();
	        empleadoList = new ArrayList<>();
	    }
	    
	    public void newEmpleado(Empleado empleado) {
	        empleados.add(empleado);
	    }
	
	    
	    public Empleado nuevoEmpleado(Empleado empleado) {
	        if (empleado.isAdministrador()) {
	            empleados.add(empleado);
	            return empleado;
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
	
	    public ArrayList<Empleado> getEmpleadoList() {
	        return empleadoList;
	    }

	    public void addEmpleadoToList(Empleado empleado) {
	        empleadoList.add(empleado);
	    }
	    
	    public void imprimirEmpleados() {
	        for (Empleado empleado : empleadoList) {
	            System.out.println(empleado.toString());
	        }
	    }
	}
