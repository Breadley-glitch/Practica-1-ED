package Second;

public class Registro{
		DoubleList Empleados;
		
	    public Registro() {
	    	Empleados = new DoubleList();
	    }
	    
	    public void newEmpleado(Empleado empleado) {
	        Empleados.addFirst(empleado);
	    }
	
	    
	    public Empleado nuevoEmpleado(Empleado nuevoEmpleado) {
	            Empleados.addFirst(nuevoEmpleado);
	            return nuevoEmpleado;
	      
	    }
	    
	    public void eliminarEmpleado(Empleado administrador, DoubleNode empleado) {
	            Empleados.remove(empleado);
	    }

	    public void cambiarContrasena(Empleado administrador, Empleado empleado, String nuevaContrasena) {
	        
	            empleado.setContrasena(nuevaContrasena);
	       
	    }
	    public DoubleList getEmpleados() {
	    	return Empleados;
	    }
	
	    public Empleado buscarEmpleadoPorId(long id) {
	        DoubleNode actual = Empleados.first();
	        while (actual != null) {
	            Empleado empleado = (Empleado) actual.getData();
	            if (empleado.getId() == id) {
	                return empleado;
	            }
	            actual = actual.getNext();
	        }
	        return null;
	    }
	    public void imprimirEmpleados() {
	        DoubleNode actual = Empleados.first();
	        while (actual != null) {
	            Empleado empleado = (Empleado) actual.getData();
	            System.out.println(empleado.toString());
	            actual = actual.getNext();
	        }
	    }
	    public void eliminarEmpleadoPorId(long id) {
	        DoubleNode actual = Empleados.first();
	        while (actual != null) {
	            Empleado empleado = (Empleado) actual.getData();
	            if (empleado.getId() == id) {
	                Empleados.remove(actual);
	                System.out.println("Empleado con ID " + id + " ha sido eliminado.");
	                return;
	            }
	            actual = actual.getNext();
	        }
	        System.out.println("No se encontró ningún empleado con el ID " + id + ".");
	    }
	    
	    public DoubleList obtenerDoubleListEmpleados() {
	        return Empleados;
	    }

	    
	    
	}
