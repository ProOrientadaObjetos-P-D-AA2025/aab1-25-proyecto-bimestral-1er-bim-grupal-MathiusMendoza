package principal;
import modelo.*;
import servicio.Estadistica;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<PPL> listaPPL = new ArrayList<>();

        System.out.print("Ingrese el número de PPLs a registrar: ");
        int total = sc.nextInt(); sc.nextLine();

        for (int i = 0; i < total; i++) {
            System.out.println("--- Registro PPL #" + (i + 1) + " ---");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Edad: ");
            int edad = sc.nextInt(); sc.nextLine();
            System.out.print("Ocupación: ");
            String ocupacion = sc.nextLine();
            System.out.print("Delito principal: ");
            String implicacion = sc.nextLine();
            System.out.print("Sentencia (true/false): ");
            boolean sentencia = sc.nextBoolean();
            System.out.print("Colabora con la justicia (true/false): ");
            boolean justicia = sc.nextBoolean();
            System.out.print("Daño económico (0 si no aplica): ");
            double danio = sc.nextDouble();
            System.out.print("Año de ingreso: ");
            int anio = sc.nextInt();
            System.out.print("Mes de ingreso: ");
            int mes = sc.nextInt();
            System.out.print("Día de ingreso: ");
            int dia = sc.nextInt(); sc.nextLine();
            LocalDate fecha = LocalDate.of(anio, mes, dia);

            PPL ppl = new PPL(nombre, edad, ocupacion, implicacion, sentencia, justicia, danio, fecha);

            System.out.print("Cantidad de delitos: ");
            int delitos = sc.nextInt(); sc.nextLine();
            for (int d = 0; d < delitos; d++) {
                System.out.print("Descripción del delito: ");
                String desc = sc.nextLine();
                System.out.print("Gravedad (1 a 5): ");
                int g = sc.nextInt(); sc.nextLine();
                ppl.agregarDelito(new Delito(desc, g));
            }

            System.out.print("Cantidad de visitas: ");
            int visitas = sc.nextInt();
            for (int v = 0; v < visitas; v++) {
                System.out.print("Año visita: "); int va = sc.nextInt();
                System.out.print("Mes: "); int vm = sc.nextInt();
                System.out.print("Día: "); int vd = sc.nextInt();
                ppl.agregarVisita(new Visita(LocalDate.of(va, vm, vd)));
            }

            System.out.print("Cantidad de agravantes: ");
            int agravantes = sc.nextInt(); sc.nextLine();
            for (int ag = 0; ag < agravantes; ag++) {
                System.out.print("Descripción del agravante: ");
                String desc = sc.nextLine();
                System.out.print("Días de castigo: ");
                int dias = sc.nextInt(); sc.nextLine();
                ppl.agregarAgravante(new Agravante(desc, dias));
            }

            listaPPL.add(ppl);
        }

        Estadistica.generarResumen(listaPPL);
    }
}
