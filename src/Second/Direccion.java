package Second;

public class Direccion {
private String calle;
private String noCalle;
private String nomenclatura;
private String barrio;
private String ciudad;

public Direccion(String calle, String noCalle, String barrio, String ciudad) {
    this.calle = calle;
    this.noCalle = noCalle;
    this.barrio = barrio;
    this.ciudad = ciudad;
}

public String getCalle() {
    return calle;
}

public void setCalle(String calle) {
    this.calle = calle;
}

public String getNoCalle() {
    return noCalle;
}

public void setNoCalle(String noCalle) {
    this.noCalle = noCalle;
}

public String getNomenclatura() {
    return nomenclatura;
}

public void setNomenclatura(String nomenclatura) {
    this.nomenclatura = nomenclatura;
}

public String getBarrio() {
    return barrio;
}

public void setBarrio(String barrio) {
    this.barrio = barrio;
}

public String getCiudad() {
    return ciudad;
}

public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
}

@Override
public String toString() {
    return "Dirección{" +
            "calle='" + calle + '\'' +
            ", noCalle=" + noCalle +
            ", nomenclatura='" + nomenclatura + '\'' +
            ", barrio='" + barrio + '\'' +
            ", ciudad='" + ciudad + '\'' +
            '}';
}

}
