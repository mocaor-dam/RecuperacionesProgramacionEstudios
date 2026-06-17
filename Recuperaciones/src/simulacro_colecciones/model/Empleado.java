package simulacro_colecciones.model;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Empleado {
    public String nombre;
    public String apellido;
    public String dni;
    public TDepartamento departamento;
    public List<Nomina> nominas;

    public Empleado(String nombre, String apellido, String dni, TDepartamento departamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.departamento = departamento;
        this.nominas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public TDepartamento getDepartamento() {
        return departamento;
    }

    public List<Nomina> getNominas() {
        return nominas;
    }

    @Override
    public String toString() {
        return "%s %s (%s) - Departamento: %s".formatted(nombre, apellido, dni, departamento);
    }

    public YearMonth fechaPrimeraNomina() {
        // TODO: Implementar
        // Debe devolver el mes de la nómina más antigua.
        // Puedes usar .orElse(null) si usas un Stream

        return nominas.stream().min(Comparator.comparing(Nomina::getMes)).map(nomina -> nomina.getMes()).orElse(null);
    }

    public Nomina getUltimaNomina() {
        // TODO: Implementar
        // Debe devolver el objeto Nomina más reciente.
        // Puedes usar .orElse(null) si usas un Stream
        return nominas.stream().max(Comparator.comparing(Nomina::getMes)).orElse(null);
    }

}
