package examen_herencias;

import utils.MiEntradaSalida2;

public class Gorron extends Invitado{

    private static final int HAMBRE_INICIAL = 90;

    private static final int MIN_ABURRIMIENTO = 0;
    private static final int MAX_ABURRIMIENTO = 50;


    public Gorron(String nombre) {
        super(nombre, HAMBRE_INICIAL, MiEntradaSalida2.generaAleatorioEntre(MIN_ABURRIMIENTO, MAX_ABURRIMIENTO, true));
    }

    public void robarComida(){
        setHambre(getHambre() - 5);
    }

    @Override
    public void reaccionar(Evento evento) {
        switch (evento){
            case CORTE_TARTA -> {
                setHambre(getHambre() - 30);
            }
            case PINIATA -> {
                setAburrimiento(getAburrimiento() - 20);
                setHambre(getHambre()- 20);
            }
            case MUSICA_ALTA -> {
                robarComida();
                robarComida();
            }
            case MUSICA_BAJA, CHARLITA_COLOQUIAL -> {
                setAburrimiento(getAburrimiento() + 30);
                robarComida();
            }
            case BAILE -> {
                robarComida();
                robarComida();
                setAburrimiento(getAburrimiento() - 5);
            }
            case APERTURA_REGALOS -> {
                setAburrimiento(getAburrimiento() - 20);
                setHambre(getHambre() + 10);
            }
        }
    }

    @Override
    public boolean estaFueraJuego(){
        if (getHambre() == 0){
            return true;
        }
        return false;
    }
}
