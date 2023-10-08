package Second;
import java.util.ArrayList;

public class Registro {
    private ArrayList<Integer> ids;
    private ArrayList<String> contra;

    public Registro(){
        this.ids = new ArrayList<>();
        this.contra = new ArrayList<>();
    }

    public void Agregar(int id, String contra) {
        this.ids.add(id);
        this.contra.add(contra);
    }
    
    public void Eliminar(int id, String contra) {
    	
    }
}
