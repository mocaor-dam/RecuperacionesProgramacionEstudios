package ExamenHerencias;

import exceptions.CumpleaniosException;

public class Invitado {
    private String nombre;
    private int nivelHambre;
    private int nivelAburrimiento;

    public Invitado(String nombre, int nivelHambre, int nivelAburrimiento) throws CumpleaniosException {
        this.nombre = nombre;
        setNivelHambre(nivelHambre);
        setNivelAburrimiento(nivelAburrimiento);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivelHambre() {
        return nivelHambre;
    }

    public void setNivelHambre(int nivelHambre) throws CumpleaniosException {
        if (nivelHambre < 0){
            throw new CumpleaniosException("El nivel de hambre tiene que ser mayor que 0.");
        } else if (nivelHambre > 100) {
            throw new CumpleaniosException("El nivel de hambre tiene que ser menor que 100");
        }

        this.nivelHambre = nivelHambre;
    }

    public int getNivelAburrimiento() {
        return nivelAburrimiento;
    }

    public void setNivelAburrimiento(int nivelAburrimiento) throws CumpleaniosException {
        if (nivelAburrimiento < 0){
            throw new CumpleaniosException("El nivel de aburrimiento tiene que ser mayor que 0.");
        } else if (nivelAburrimiento > 100) {
            throw new CumpleaniosException("El nivel de aburrimiento tiene que ser menor que 100");
        }

        this.nivelAburrimiento = nivelAburrimiento;
    }
}
