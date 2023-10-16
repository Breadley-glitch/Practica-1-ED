package Second;
import java.util.Date;

public class Mensaje {
	protected int id;
protected String titulo;
protected String cuerpo;
protected Date fecha;

public Mensaje(int id, String titulo, String cuerpo) {
    this.id = id;
    this.titulo = titulo;
    this.cuerpo = cuerpo;
    this.fecha = new Date();
}
public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getTitulo() {
    return titulo;
}

public void setTitulo(String titulo) {
    this.titulo = titulo;
}

public String getCuerpo() {
    return cuerpo;
}

public void setCuerpo(String cuerpo) {
    this.cuerpo = cuerpo;
}
public Date getFecha() {
    return fecha;
}
public void setFecha(Date fecha) {
    this.fecha = fecha;
}
}


