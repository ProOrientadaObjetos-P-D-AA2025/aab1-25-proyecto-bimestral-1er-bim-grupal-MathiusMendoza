
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Clase Persona Privada de la Libertad (PPL) adaptada al estilo solicitado
public class PPL {
    private String nombre;
    private int edad;
    private String ocupacion;
    private String implicacion; // tipo de delito
    private boolean sentencia;
    private boolean colaboraJusticia;
    private double danioEconomico;
    private LocalDate fechaIngreso;
    private List<Delito> delitos = new ArrayList<>();
    private List<Visita> visitas = new ArrayList<>();
    private List<Agravante> agravantes = new ArrayList<>();

    public PPL(String nombre, int edad, String ocupacion, String implicacion, boolean sentencia, 
               boolean colaboraJusticia, double danioEconomico, LocalDate fechaIngreso) {
        this.nombre = nombre;
        this.edad = edad;
        this.ocupacion = ocupacion;
        this.implicacion = implicacion;
        this.sentencia = sentencia;
        this.colaboraJusticia = colaboraJusticia;
        this.danioEconomico = danioEconomico;
        this.fechaIngreso = fechaIngreso;
    }

    public void agregarDelito(Delito delito) {
        delitos.add(delito);
    }

    public void agregarVisita(Visita visita) {
        visitas.add(visita);
    }

    public void agregarAgravante(Agravante agravante) {
        agravantes.add(agravante);
    }

    public int calcularDiasVisitaPermitidos() {
        int dias = 4;
        for (Agravante a : agravantes) {
            dias -= a.getCastigoDias();
        }
        return Math.max(dias, 0);
    }

    public int calcularAumentoPena() {
        int dias = 0;
        for (Agravante a : agravantes) {
            dias += a.getCastigoDias() * 10;
        }
        return dias;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s\nEdad: %d\nOcupacion: %s\nDelito principal: %s\n"
                + "Sentencia: %s\nColabora con la justicia: %s\nDaño económico: $%.2f\nFecha ingreso: %s\n"
                + "Delitos: %d\nVisitas: %d\nAgravantes: %d\nDías visita permitidos: %d\nAumento de pena: %d días",
                nombre, edad, ocupacion, implicacion,
                (sentencia ? "Sí" : "No"),
                (colaboraJusticia ? "Sí" : "No"),
                danioEconomico, fechaIngreso,
                delitos.size(), visitas.size(), agravantes.size(),
                calcularDiasVisitaPermitidos(), calcularAumentoPena());
    }
}
