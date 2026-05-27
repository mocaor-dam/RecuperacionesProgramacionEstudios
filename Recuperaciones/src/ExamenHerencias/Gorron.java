package ExamenHerencias;

import exceptions.CumpleaniosException;
import utils.MiEntradaSalida2;

public class Gorron extends Invitado{

    private static final int HAMBRE_INICIAL = 90;

    private static final int MIN_ABURRIMIENTO_INICIAL = 0;
    private static final int MAX_ABURRIMIENTO_INICIAL = 50;

    public Gorron(String nombre) throws CumpleaniosException {
        super(nombre, HAMBRE_INICIAL, MiEntradaSalida2.generaAleatorioEntre(MIN_ABURRIMIENTO_INICIAL, MAX_ABURRIMIENTO_INICIAL, true)));
    }

    public void robarComida() throws CumpleaniosException {
        setNivelHambre(getNivelHambre() - 5);
    }
}
