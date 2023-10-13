	package Second;
	
	public class Registro {
	    DoubleList Empleados;
		
	    public Registro() {
	    	Empleados = new DoubleList();
	    }
	    
	    public void newEmpleado(Empleado empleado) {
	        Empleados.addFirst(empleado);
	    }
	
	    
	    public Empleado nuevoEmpleado(Empleado empleado) {
	        if (empleado.isAdministrador()) {
	            Empleados.addFirst(empleado);
	            return empleado;
	        } else {
	            System.out.println("Acción no permitida. Solo los administradores pueden crear nuevos empleados.");
	            return null;
	        }
	    }
	    
	     //DoubleNode empleado. Verificarlo.
	    public void eliminarEmpleado(Empleado administrador, DoubleNode empleado) {
	        if (administrador.isAdministrador()) {
	            Empleados.remove(empleado);
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
	    
	    public DoubleList getEmpleados() {
	    	return Empleados;
	    }
	
	    
	    
	}
