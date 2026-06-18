package simulacro_2_colecciones;

import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Atleta> listaAtletas = cargarDatosPrueba();

        System.out.println("=== EJERCICIO 1: BUSCAR ATLETA POR ID FEDERADO ===");
        buscarAtletaPorId(listaAtletas, "ATH-101"); // Existe
        buscarAtletaPorId(listaAtletas, "ATH-ERROR"); // No existe

        System.out.println("\n=== EJERCICIO 2: RECUENTO DE ATLETAS POR DISCIPLINA ===");
        mostrarRecuentoPorDisciplina(listaAtletas);

        System.out.println("\n=== EJERCICIO 3: ESFUERZO MEDIO DE ATLETAS NUEVOS (Menos de 1 año) ===");
        mostrarEsfuerzoMedioAtletasNuevos(listaAtletas);

        System.out.println("\n=== EJERCICIO 4: MÁXIMO RENDIMIENTO NETO ===");
        mostrarAtletasConMaximoRendimiento(listaAtletas);

        System.out.println("\n=== EJERCICIO 5: TOTAL CALORÍAS QUEMADAS EN EL CENTRO EN UN MES ===");
        YearMonth mesEvaluar = YearMonth.of(2026, 5);
        mostrarCaloriasTotalesMes(listaAtletas, mesEvaluar);

        System.out.println("\n=== EJERCICIO 6: LISTADO DE ATLETAS POR ANTIGÜEDAD Y APELLIDO ===");
        mostrarListadoPorAntiguedadAtletas(listaAtletas);
    }

    /**
     * 1. Buscar atleta por idFederado (0.5 puntos)
     * Si existe, imprime el atleta. Si no, muestra un mensaje de error por pantalla.
     */
    public static void buscarAtletaPorId(List<Atleta> atletas, String idFederado) {
        // TODO: Tu código aquí (.filter, .findFirst, .ifPresentOrElse)
        atletas.stream().filter(atleta -> atleta.getIdFederado().equals(idFederado))
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("No se ha encontrado un atleta con ese ID"));
    }

    /**
     * 2. Recuento por disciplinas (0.5 puntos)
     * Muestra cuántos atletas hay asignados a cada disciplina. (Agrupa e imprime el mapa).
     */
    public static void mostrarRecuentoPorDisciplina(List<Atleta> atletas) {
        // TODO: Tu código aquí (.collect, Collectors.groupingBy, Collectors.counting)
        Map<Disciplina, Long> resultado = atletas.stream().collect(Collectors.groupingBy(Atleta::getDisciplina, Collectors.counting()));
        resultado.forEach((disciplina, cantidad) -> System.out.println(disciplina + " : " + cantidad));
    }

    /**
     * 3. Esfuerzo medio de los atletas nuevos (1.5 puntos)
     * Porcentaje medio del 'indiceEsfuerzo' (de su ÚLTIMA sesión) de los atletas
     * cuyo primer entrenamiento registrado sea de hace menos de un año respecto a hoy (Junio 2026).
     */
    public static void mostrarEsfuerzoMedioAtletasNuevos(List<Atleta> atletas) {
        YearMonth fechaLimite = YearMonth.of(2025, 6);
        // TODO: Tu código aquí (.filter, .mapToDouble, .average, .orElse)

        double mediaEsfuerzo = atletas.stream().filter(atleta -> atleta.fechaPrimerEntrenamiento().isAfter(fechaLimite))
                .mapToDouble(atleta -> atleta.getUltimaSesion().getIndiceEsfuerzo()).average().orElse(0.0);
        System.out.println("La media de el esfuerzo es: " + mediaEsfuerzo);
    }

    /**
     * 4. Máximo rendimiento neto (1.5 puntos)
     * Muestra los datos del atleta o atletas (en caso de empate) con el 'rendimientoNeto'
     * más alto en su ÚLTIMA sesión.
     */
    public static void mostrarAtletasConMaximoRendimiento(List<Atleta> atletas) {
        // TODO: Tu código aquí (Paso 1: Sacar max double. Paso 2: Filtrar lista e imprimir)
       double rendimientoNetoMax = atletas.stream().mapToDouble(atleta -> atleta.getUltimaSesion().getRendimientoNeto()).max().orElse(0.0);

       atletas.stream().filter(atleta -> atleta.getUltimaSesion().getRendimientoNeto() == rendimientoNetoMax)
               .forEach(System.out::println);
    }

    /**
     * 5. Total calorías quemadas (1.5 puntos)
     * Dada una fecha específica, calcula el total de 'caloriasQuemadas' acumuladas
     * por todos los atletas en ese mes concreto.
     */
    public static void mostrarCaloriasTotalesMes(List<Atleta> atletas, YearMonth fecha) {
        // TODO: Tu código aquí (.flatMap para las sesiones, .filter por fecha, .mapToDouble, .sum)
        double totalCaloriasQuemadas = atletas.stream().flatMap(atleta -> atleta.getSesiones().stream())
                .filter(sesionEntrenamiento -> sesionEntrenamiento.getMesAnio().equals(fecha))
                .mapToDouble(SesionEntrenamiento::getCaloriasQuemadas).sum();
        System.out.println(totalCaloriasQuemadas);
    }

    /**
     * 6. Listado por antigüedad (1.5 puntos)
     * Muestra por pantalla todos los atletas ordenados del que empezó más antiguo al más nuevo.
     * En caso de empate, ordenados alfabéticamente por apellido.
     */
    public static void mostrarListadoPorAntiguedadAtletas(List<Atleta> atletas) {
        // TODO: Tu código aquí (.sorted con Comparator compuesto, .forEach)
        atletas.stream().sorted(Comparator.comparing(Atleta::fechaPrimerEntrenamiento)
                .thenComparing(Atleta::getApellido)).forEach(System.out::println);

    }

    private static List<Atleta> cargarDatosPrueba() {
        List<Atleta> list = new ArrayList<>();

        Atleta a1 = new Atleta("Moisés", "Cabanillas", "ATH-101", Disciplina.CROSSFIT);
        a1.agregarSesion(new SesionEntrenamiento(YearMonth.of(2024, 5), 800, 20));
        a1.agregarSesion(new SesionEntrenamiento(YearMonth.of(2026, 5), 900, 10)); // Última: neto = 810

        Atleta a2 = new Atleta("Sara", "Abad", "ATH-102", Disciplina.NATACION);
        a2.agregarSesion(new SesionEntrenamiento(YearMonth.of(2024, 5), 850, 15));
        a2.agregarSesion(new SesionEntrenamiento(YearMonth.of(2026, 5), 900, 10)); // Última: neto = 810 (Empate)

        Atleta a3 = new Atleta("Carlos", "Zambrano", "ATH-103", Disciplina.ATLETISMO);
        a3.agregarSesion(new SesionEntrenamiento(YearMonth.of(2025, 9), 500, 30)); // Atleta nuevo (< 1 año)
        a3.agregarSesion(new SesionEntrenamiento(YearMonth.of(2026, 5), 600, 25)); // Última

        list.add(a1); list.add(a2); list.add(a3);
        return list;
    }
}
