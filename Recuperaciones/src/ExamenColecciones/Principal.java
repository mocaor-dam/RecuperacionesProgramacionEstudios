package ExamenColecciones;

import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private List<Empleado> empleados;

    public Principal() {
        empleados = new ArrayList<>();
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.inicializarEmpleados();

        // Este empleado obviamente existe
        principal.buscarEmpleado(principal.empleados.getFirst().getDni());

        // Este empleado no existe
        principal.buscarEmpleado("12345678A");
        System.out.println();

        System.out.println("#############");
        System.out.println("Número de empleados por departamento:");
        principal.mostrarNumeroEmpleadosPorDepartamento();
        System.out.println();

        System.out.println("#############");
        System.out.printf("Porcentaje de retención para los trabajadores que llevan menos de 1 año trabajando: %.2f€%n",
                principal.porcentajeRetencionTrabajadoresNuevos());
        System.out.println();

        System.out.println("#############");
        principal.empleadosQueMasCobran();
        System.out.println();

        System.out.println("#############");
        System.out.println("Coste total en salarios");
        principal.costeTotalSalarios(YearMonth.of(2024, 12));
        System.out.println();

        System.out.println("#############");
        System.out.println("Todos los empleados ordenados por antigüedad");
        principal.mostrarTodosEmpleadosOrdenados();
        System.out.println();


    }

    private void buscarEmpleado(String dni) {
      empleados.stream().filter(empleado -> empleado.getDni().equals(dni))
              .findFirst().ifPresentOrElse(empleado -> System.out.println(empleado), () -> System.out.println("No se ha encontrado un empleado con DNI: " + dni));



    }

    private void mostrarNumeroEmpleadosPorDepartamento() {
        double mediaSalarioBase = empleados.stream().mapToDouble(empleado -> empleado.getUltimaNomina().getSalarioBase()).average().orElse(0.0);

        Map<TDepartamento, Long> resultado = empleados.stream().collect(Collectors.groupingBy(Empleado::getDepartamento, Collectors.averagingDouble(Empleado::getUltimaNomina)));

        resultado.forEach((departamento, cantidad) -> System.out.println(departamento + " : " + cantidad));
    }

    private double porcentajeRetencionTrabajadoresNuevos() {
        YearMonth fechaHace1anio = YearMonth.now().minusMonths(12);

        return  empleados.stream().filter(empleado -> empleado.fechaPrimeraNomina().isAfter(fechaHace1anio))
                .mapToDouble(empleado -> empleado.getUltimaNomina().getPorcentajeRetencion())
                .average().orElse(0.0);
    }

    private void empleadosQueMasCobran() {
        double salarioMaximo = empleados.stream().mapToDouble(empleado -> empleado.getUltimaNomina().getSalarioBase()).max().orElse(0.0);

        empleados.stream().filter(empleado -> empleado.getUltimaNomina().getSalarioBase() == salarioMaximo).forEach(System.out::println);
    }

    private void costeTotalSalarios(YearMonth fecha) {
       double totalSalarios = empleados.stream().flatMap(empleado -> empleado.nominas.stream())
               .filter(nomina -> nomina.getMes().equals(fecha)).mapToDouble(Nomina::getSalarioBase).sum();

        System.out.println(totalSalarios);

    }


    private void mostrarTodosEmpleadosOrdenados() {
        empleados.stream().sorted(Comparator.comparing(Empleado::fechaPrimeraNomina)).forEach(System.out::println);
    }

    public void inicializarEmpleados() {
        Random random = new Random();

        // Configuración para generar 5 empleados por cada departamento
        for (TDepartamento dept : TDepartamento.values()) {
            // Los departamentos tendrán entre 3 y 7 empleados
            int numEmpleados = random.nextInt(5) + 3;
            for (int i = 1; i <= numEmpleados; i++) {
                String nombre = "Empleado " + i + "_" + dept.name().charAt(0);
                String apellido = "Apellido " + (random.nextInt(10) + i);
                String dni = (random.nextInt(90000000) + 10000000) + "X";

                Empleado emp = new Empleado(nombre, apellido, dni, dept);

                // Generamos entre 5 y 30 nóminas para cada uno
                // Algunos empezarán hace 30 meses, otros hace solo 5
                int numNominas = random.nextInt(26) + 5;
                YearMonth mesInicio = YearMonth.now().minusMonths(numNominas);

                for (int m = 0; m < numNominas; m++) {
                    YearMonth mesNomina = mesInicio.plusMonths(m);
                    // Salarios entre 1500 y 3500
                    double salarioBase = 1500 + (random.nextDouble() * 2000);
                    // Retenciones entre 10% y 22%
                    double retencion = 10 + (random.nextDouble() * 12);

                    emp.getNominas().add(new Nomina(mesNomina, salarioBase, retencion));
                }
                empleados.add(emp);
            }
        }
    }
}
