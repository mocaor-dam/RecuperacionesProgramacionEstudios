package examen_herencias;

import exceptions.CumpleaniosException;

public abstract class Invitado {
    private String nombre;
    private int hambre;
    private int aburrimiento;


    public Invitado(String nombre, int hambre, int aburrimiento) {
        this.nombre = nombre;
        this.hambre = hambre;
        this.aburrimiento = aburrimiento;
    }

    public abstract void reaccionar(Evento evento);

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHambre() {
        return hambre;
    }

    public void setHambre(int hambre) {
        if (hambre > 100) {
            this.hambre = 100;
        }
        if (hambre < 0) {
            this.hambre = 0;
        }
        this.hambre = hambre;
    }

    public int getAburrimiento() {
        return aburrimiento;
    }

    public void setAburrimiento(int aburrimiento) {
        if (aburrimiento > 100) {
            aburrimiento = 100;
        }
        if (aburrimiento < 0) {
            aburrimiento = 0;
        }

        this.aburrimiento = aburrimiento;
    }


    public boolean estaFueraJuego(){
        if (getHambre() == 100){
            return true;
        } else if (getAburrimiento() == 100) {
            return true;
        }

        return false;
    }
}
