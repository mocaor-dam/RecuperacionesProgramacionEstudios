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
            nivelHambre = 0;
        } else if (nivelHambre > 100) {
            nivelHambre = 100;
        }

        this.nivelHambre = nivelHambre;
    }

    public int getNivelAburrimiento() {
        return nivelAburrimiento;
    }

    public void setNivelAburrimiento(int nivelAburrimiento) throws CumpleaniosException {
        if (nivelAburrimiento < 0){
            nivelAburrimiento = 0;
        } else if (nivelAburrimiento > 100) {
            nivelAburrimiento = 100;
        }

        this.nivelAburrimiento = nivelAburrimiento;
    }

    public String reaccionar(Evento evento) throws CumpleaniosException {
        if (evento != Evento.CORTE_TARTA && evento != Evento.PINIATA){
            setNivelHambre(getNivelHambre() + 10);
        }
        return null;
    }

    public boolean estaFueraDeJuego(){
        if (this.nivelHambre >= 100){
            return true;
        }
        if (this.nivelAburrimiento >= 100){
            return true;
        }
        return false;
    }

}
