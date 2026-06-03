package SimulacroMascotas.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Mascota {
    private String chip;
    private String nombre;
    private TEspecie especie;
    private int edad;
    private List<Vacuna> vacunas;

    public Mascota(String chip, String nombre, TEspecie especie, int edad) {
        this.chip = chip;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.vacunas = new ArrayList<>();
    }

    public String getChip() {
        return chip;
    }

    public String getNombre() {
        return nombre;
    }

    public TEspecie getEspecie() {
        return especie;
    }

    public int getEdad() {
        return edad;
    }

    public List<Vacuna> getVacunas() {
        return vacunas;
    }

    @Override
    public String toString() {
        return "%s - %s (%s, %d años)".formatted(chip, nombre, especie, edad);
    }

    public Vacuna getVacunaMasCara() {
        return vacunas.stream().max(Comparator.comparing(Vacuna::getCoste)).orElse(null);

    }
}