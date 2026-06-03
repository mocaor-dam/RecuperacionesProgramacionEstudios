package SimulacroMascotas.model;

import java.time.YearMonth;

public class Vacuna {
    private String nombre;
    private YearMonth fecha;
    private double coste;

    public Vacuna(String nombre, YearMonth fecha, double coste) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.coste = coste;
    }

    public String getNombre() {
        return nombre;
    }

    public YearMonth getFecha() {
        return fecha;
    }

    public double getCoste() {
        return coste;
    }
}
