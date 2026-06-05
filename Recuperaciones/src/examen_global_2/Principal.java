package examen_global_2;

import examen_global_2.herencias.Cuenta;
import examen_global_2.herencias.CuentaCorriente;
import examen_global_2.herencias.CuentaPlazoFijo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Principal {
    private List<Cuenta> cuentas;

    public Principal() {
        this.cuentas = new ArrayList<>();
    }

    public void mostrarCuentasCorrientesCriticas() {
        // TODO 3: STREAMS AVANZADOS
        // Tienes que usar la cinta transportadora sobre la lista 'cuentas' para:
        //
        // 1. FILTRAR: Quédate SOLO con las cuentas que sean de tipo CuentaCorriente (instanceof).
        // 2. FILTRAR: De esas cuentas corrientes, quédate SOLO con las que tengan un saldo
        //    estrictamente MENOR que 100€ (¡pueden ser saldos negativos también!).
        // 3. ORDENAR (.sorted): Ordena las cuentas resultantes de MENOR A MAYOR saldo.
        //    Pista para el comparador: Comparator.comparingDouble(Cuenta::getSaldo)
        // 4. TERMINAL (.forEach): Imprime por pantalla el IBAN y el Saldo de cada cuenta filtrada.
        //    Ejemplo de impresión: System.out.println("IBAN: " + c.getIban() + " - Saldo: " + c.getSaldo());

        cuentas.stream().filter(cuenta -> cuenta instanceof CuentaCorriente)
                .filter(cuenta -> cuenta.getSaldo()<100)
                .sorted(Comparator.comparingDouble(Cuenta::getSaldo))
                .forEach(cuenta -> System.out.println("IBAN: " + cuenta.getIban() + "  \n Saldo: " + cuenta.getSaldo()));
    }

    public static void main(String[] args) {
        Principal p = new Principal();
        p.inicializarDatos();

        System.out.println("--- PROBANDO STREAMS DE ALTA DIFICULTAD ---");
        System.out.println("Cuentas corrientes en estado crítico (Saldo < 100€) ordenadas de menor a mayor:");
        p.mostrarCuentasCorrientesCriticas();
    }

    private void inicializarDatos() {
        cuentas.add(new CuentaCorriente("ES21-1111", 500, 300));
        cuentas.add(new CuentaPlazoFijo("ES21-2222", 50, 2)); // Es plazo fijo, se ignora
        cuentas.add(new CuentaCorriente("ES21-3333", -150, 500)); // Crítica 1
        cuentas.add(new CuentaCorriente("ES21-4444", 20, 100));  // Crítica 2
        cuentas.add(new CuentaPlazoFijo("ES21-5555", -10, 0)); // Es plazo fijo, se ignora
        cuentas.add(new CuentaCorriente("ES21-6664", 1200, 600));
        cuentas.add(new CuentaCorriente("ES21-7777", -50, 200));  // Crítica 3
    }
}