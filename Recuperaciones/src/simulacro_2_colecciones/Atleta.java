package simulacro_2_colecciones;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Atleta {
    private String nombre;
    private String apellido;
    private String idFederado;
    private Disciplina disciplina;
    private List<SesionEntrenamiento> sesiones;

    public Atleta(String nombre, String apellido, String idFederado, Disciplina disciplina) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idFederado = idFederado;
        this.disciplina = disciplina;
        this.sesiones = new ArrayList<>();
    }

    public void agregarSesion(SesionEntrenamiento s) { this.sesiones.add(s); }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getIdFederado() { return idFederado; }
    public Disciplina getDisciplina() { return disciplina; }
    public List<SesionEntrenamiento> getSesiones() { return sesiones; }

    // Devuelve la fecha de su primer entrenamiento registrado
    public YearMonth fechaPrimerEntrenamiento() {
        return sesiones.stream()
                .map(SesionEntrenamiento::getMesAnio)
                .min(YearMonth::compareTo)
                .orElse(null);
    }

    // Devuelve su sesión de entrenamiento más reciente
    public SesionEntrenamiento getUltimaSesion() {
        return sesiones.stream()
                .max(Comparator.comparing(SesionEntrenamiento::getMesAnio))
                .orElse(null);
    }

    @Override
    public String toString() {
        return "%s %s (%s) - %s".formatted(nombre, apellido, idFederado, disciplina);
    }
}
