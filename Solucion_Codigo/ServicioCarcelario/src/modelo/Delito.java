package modelo;
public class Delito {
    private String descripcion;
    private int gravedad;

    public Delito(String descripcion, int gravedad) {
        this.descripcion = descripcion;
        this.gravedad = gravedad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getGravedad() {
        return gravedad;
    }

    @Override
    public String toString() {
        return descripcion + " (Gravedad: " + gravedad + ")";
    }
}
