package ExamenHerencias;

import exceptions.CumpleaniosException;
import utils.MiEntradaSalida2;

public class Colega extends Invitado implements Regalador{

    private static final int MIN_HAMBRE_INICIAL = 50;
    private static final int MAX_HAMBRE_INICIAL = 70;

    private static final int MIN_ABURRIMIENTO_INICIAL = 0;
    private static final int MAX_ABURRIMIENTO_INICIAL = 50;

    private TipoRegalo regaloQueTrae;

    public Colega(String nombre) throws CumpleaniosException {
        super(nombre,
                MiEntradaSalida2.generaAleatorioEntre(MIN_HAMBRE_INICIAL, MAX_HAMBRE_INICIAL, true),
                MiEntradaSalida2.generaAleatorioEntre(MIN_ABURRIMIENTO_INICIAL, MAX_ABURRIMIENTO_INICIAL, true));

        if (MiEntradaSalida2.generaAleatorioEntre(1,2,true) == 2){
            regaloQueTrae = TipoRegalo.ROPA;
        } else {
            regaloQueTrae = TipoRegalo.JUGUETES;
        }
    }

    @Override
    public TipoRegalo darRegalo() {
        return this.regaloQueTrae;
    }
}
