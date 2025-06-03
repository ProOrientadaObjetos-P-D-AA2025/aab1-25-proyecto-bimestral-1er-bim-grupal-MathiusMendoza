package modelo;
import java.time.LocalDate;

public class Visita {
    private LocalDate fecha;

    public Visita(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}