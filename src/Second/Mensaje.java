package Second;
import java.util.Date;

public class Mensaje {
protected long id;
protected String titulo;
protected String cuerpo;
protected Date fecha;

public Mensaje(long id, String titulo, String cuerpo) {
    this.id = id;
    this.titulo = titulo;
    this.cuerpo = cuerpo;
    this.fecha = new Date();
}

public Mensaje(long id, String titulo, String cuerpo, Date fecha) {
    this.id = id;
    this.titulo = titulo;
    this.cuerpo = cuerpo;
    this.fecha = fecha;
}
public long getId() {
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

@Override
public String toString() {
    return "Mensaje{" +
            "id=" + id +
            ", titulo='" + titulo + '\'' +
            ", cuerpo='" + cuerpo + '\'' +
            ", fecha=" + fecha +
            '}';
}

}


