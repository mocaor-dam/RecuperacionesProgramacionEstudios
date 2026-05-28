package ExamenHerencias;

import exceptions.CumpleaniosException;
import utils.MiEntradaSalida2;

public class Gorron extends Invitado{

    private static final int HAMBRE_INICIAL = 90;

    private static final int MIN_ABURRIMIENTO_INICIAL = 0;
    private static final int MAX_ABURRIMIENTO_INICIAL = 50;

    public Gorron(String nombre) throws CumpleaniosException {
        super(nombre, HAMBRE_INICIAL, MiEntradaSalida2.generaAleatorioEntre(MIN_ABURRIMIENTO_INICIAL, MAX_ABURRIMIENTO_INICIAL, true));
    }

    public void robarComida() throws CumpleaniosException {
        setNivelHambre(getNivelHambre() - 5);
    }

   @Override
   public String reaccionar(Evento evento) throws CumpleaniosException {
       super.reaccionar(evento);
       String mensajeRetorno = null;
        switch (evento){
            case MUSICA_ALTA -> {
                robarComida();
                robarComida();
            }
            case MUSICA_BAJA, CHARLITA_COLOQUIAL -> {
                robarComida();
                setNivelAburrimiento(getNivelAburrimiento() + 30);
            }
            case BAILE -> {
                robarComida();
                robarComida();
                setNivelAburrimiento(getNivelAburrimiento() - 5);
            }
            case CORTE_TARTA -> {
                setNivelHambre(getNivelHambre() - 30); //come mas que el resto
            }
            case PINIATA -> {
                setNivelHambre(getNivelHambre() - 20);
                setNivelAburrimiento(getNivelAburrimiento() - 20);
            }
            case APERTURA_REGALOS -> {
                setNivelAburrimiento(getNivelAburrimiento() - 20);
            }
        }

        return mensajeRetorno;
   }

   @Override
    public boolean estaFueraDeJuego(){
        if (getNivelHambre() == 0){
            return true;
        }
        return false;
   }
}
