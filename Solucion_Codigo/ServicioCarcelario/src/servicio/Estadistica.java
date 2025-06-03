package servicio;
import modelo.PPL;
import java.util.List;

public class Estadistica {
    public static void generarResumen(List<PPL> pplList) {
        System.out.println("=== RESUMEN DE CONTROL CARCELARIO ===");
        for (PPL p : pplList) {
            System.out.println(p);
            System.out.println("-----------------------------------");
        }
    }
}
