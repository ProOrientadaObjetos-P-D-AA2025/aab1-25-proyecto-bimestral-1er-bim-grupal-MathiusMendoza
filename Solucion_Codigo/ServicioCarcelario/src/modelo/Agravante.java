package modelo;
public class Agravante {
    private String descripcion;
    private int castigoDias;

    public Agravante(String descripcion, int castigoDias) {
        this.descripcion = descripcion;
        this.castigoDias = castigoDias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCastigoDias() {
        return castigoDias;
    }

    @Override
    public String toString() {
        return descripcion + " (-" + castigoDias + " días visita)";
    }
}
