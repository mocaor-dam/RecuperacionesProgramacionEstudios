package SimulacroMascotas.app;

import SimulacroMascotas.model.Mascota;
import SimulacroMascotas.model.TEspecie;
import SimulacroMascotas.model.Vacuna;
import org.w3c.dom.ls.LSOutput;

import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private List<Mascota> mascotas;

    public Principal() {
        this.mascotas = new ArrayList<>();
    }

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.inicializarMascotas();

        System.out.println("#############");
        System.out.println("Buscar mascota por Chip:");
        principal.buscarMascotaPorChip("CHIP-PERRO-1");
        principal.buscarMascotaPorChip("CHIP-FALSO");
        System.out.println();

        System.out.println("#############");
        System.out.println("Mascotas ordenadas por edad:");
        principal.mostrarMascotasOrdenadasPorEdad();
        System.out.println();

        System.out.println("#############");
        System.out.println("Gasto total en vacunas para un mes concreto:");
        principal.gastoTotalVacunasMes(YearMonth.of(2025, 6));
        System.out.println();

        System.out.println("#############");
        System.out.println("Cantidad de mascotas por especie:");
        principal.mostrarCantidadMascotasPorEspecie();
        System.out.println();
    }

    private void buscarMascotaPorChip(String chip) {
        mascotas.stream().filter(mascota -> mascota.getChip().equals(chip))
                .findFirst().ifPresentOrElse(mascota -> System.out.println(mascota), () -> System.out.println("No se ha encontrado una mascota con Chip: " + chip));
    }

    private void mostrarMascotasOrdenadasPorEdad() {
        mascotas.stream().sorted(Comparator.comparing(Mascota::getEdad)).forEach(System.out::println);
    }

    private void gastoTotalVacunasMes(YearMonth mes) {
       double total = mascotas.stream().flatMap(mascota -> mascota.getVacunas().stream())
               .filter(vacuna -> vacuna.getFecha().equals(mes))
               .mapToDouble(Vacuna::getCoste).sum();

        System.out.println(total);
    }

    private void mostrarCantidadMascotasPorEspecie() {
       Map<TEspecie,Long> mascotasPorEspecie = mascotas.stream().collect(Collectors.groupingBy(Mascota::getEspecie, Collectors.counting()));

       mascotasPorEspecie.forEach((especie, cantidad) -> System.out.println(especie + " : " + cantidad));
    }

    public void inicializarMascotas() {
        Random random = new Random();
        // Generamos datos aleatorios para probar el sistema
        for (TEspecie esp : TEspecie.values()) {
            for (int i = 1; i <= 3; i++) {
                String chip = "CHIP-" + esp.name() + "-" + i;
                String nombre = "Mascota " + i + "_" + esp.name().charAt(0);
                int edad = random.nextInt(12) + 1;

                Mascota m = new Mascota(chip, nombre, esp, edad);

                // Entre 1 y 4 vacunas por mascota
                int numVacunas = random.nextInt(4) + 1;
                for (int v = 0; v < numVacunas; v++) {
                    YearMonth fecha = YearMonth.of(2025, random.nextInt(12) + 1);
                    double coste = 20 + random.nextDouble() * 50; // Coste entre 20 y 70
                    m.getVacunas().add(new Vacuna("Vacuna-" + (v + 1), fecha, coste));
                }
                mascotas.add(m);
            }
        }
    }
}
