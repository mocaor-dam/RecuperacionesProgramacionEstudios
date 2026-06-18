package simulacro_2_colecciones;

import java.time.YearMonth;

public class SesionEntrenamiento {
    private YearMonth mesAnio;
    private double caloriasQuemadas;
    private double indiceEsfuerzo; // Entre 0 y 100

    public SesionEntrenamiento(YearMonth mesAnio, double caloriasQuemadas, double indiceEsfuerzo) {
        this.mesAnio = mesAnio;
        this.caloriasQuemadas = caloriasQuemadas;
        this.indiceEsfuerzo = indiceEsfuerzo;
    }

    public YearMonth getMesAnio() { return mesAnio; }
    public double getCaloriasQuemadas() { return caloriasQuemadas; }
    public double getIndiceEsfuerzo() { return indiceEsfuerzo; }

    // Rendimiento neto de la sesión
    public double getRendimientoNeto() {
        return caloriasQuemadas * (1 - (indiceEsfuerzo / 100));
    }
}