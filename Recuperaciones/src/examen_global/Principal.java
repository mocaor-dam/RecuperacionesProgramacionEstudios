package examen_global;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Principal {
    private List<Vehiculo> catalogo;

    public Principal() {
        this.catalogo = new ArrayList<>();
    }

    public static void main(String[] args) {
        Principal p = new Principal();
        p.inicializarDatos();

        System.out.println("--- FASE 1: PROBANDO TALLER (MATRICES) ---");
        Taller taller = new Taller();
        // Intentamos aparcar los 4 primeros vehículos del catálogo
        for (int i = 0; i < 4; i++) {
            taller.aparcarVehiculo(p.catalogo.get(i));
        }
        taller.mostrarEstadoTaller();
        System.out.println();

        System.out.println("--- FASE 2: CONSULTAS (STREAMS) ---");
        System.out.print("Media de kilómetros de los COCHES: ");
        System.out.println(p.mediaKilometrosCoches() + " km");

        System.out.println("\nMotos con cilindrada superior a 250cc:");
        p.mostrarMotosGranCilindrada();
    }

    private double mediaKilometrosCoches() {

       return catalogo.stream().filter(vehiculo -> vehiculo instanceof Coche coche).mapToInt(vehiculo -> vehiculo.getKilometros()).average().orElse(0.0);
        // Filtra para quedarte SOLO con los objetos que sean coches (instanceof Coche).
        // Saca la media de sus kilómetros y devuélvela. Si no hay coches, devuelve 0.0.
    }

    private void mostrarMotosGranCilindrada() {
        // TODO: Usa un Stream sobre la lista 'catalogo'.
        catalogo.stream().filter(vehiculo -> vehiculo instanceof Moto)// Filtra para quedarte SOLO con los vehículos que sean Moto (instanceof Moto).
                .filter(vehiculo -> ((Moto) vehiculo).getCilindrada() > 250)   // Y que ADEMÁS tengan una cilindrada superior a 250.
                .forEach(System.out::println);// Muéstralos por pantalla uno a uno.



    }

    private void inicializarDatos() {
        catalogo.add(new Coche("1234-BBB", "Seat Ibiza", 120000, 8000, false));
        catalogo.add(new Moto("5555-FFF", "Yamaha MT-07", 15000, 6500, 689));
        catalogo.add(new Coche("9876-LKP", "Toyota Corolla", 45000, 18000, true));
        catalogo.add(new Moto("1111-DDD", "Honda Scoopy", 8000, 3200, 125));
        catalogo.add(new Coche("4433-MXC", "Tesla Model 3", 95000, 35000, true));
    }
}