package examen_herencias;

import utils.MiEntradaSalida;
import utils.MiEntradaSalida2;

public class Colega extends Invitado implements Regalador{
    private static final int MIN_HAMBRE = 50;
    private static final int MAX_HAMBRE = 70;

    private static final int MIN_ABURRIMIENTO = 0;
    private static final int MAX_ABURRIMIENTO = 50;

    private TipoRegalo regaloQueTrae;

    public Colega(String nombre) {
        super(nombre,
                MiEntradaSalida2.generaAleatorioEntre(MIN_HAMBRE, MAX_HAMBRE, true),
                MiEntradaSalida2.generaAleatorioEntre(MIN_ABURRIMIENTO, MAX_ABURRIMIENTO, true));
        regaloAleatorio();
    }

    public void regaloAleatorio(){
        if (MiEntradaSalida2.generaAleatorioEntre(1,2,true) == 1){
            this.regaloQueTrae = TipoRegalo.JUGUETES;
        } else {
            this.regaloQueTrae = TipoRegalo.ROPA;
        }
    }

    @Override
    public void reaccionar(Evento evento) {

        switch (evento){
            case CORTE_TARTA -> {
                setHambre(getHambre() - 20);
            }
            case PINIATA -> {
                setHambre(getHambre() - 10);
                setAburrimiento(getAburrimiento() - 20);
            }
            case MUSICA_ALTA, BAILE -> {
                setAburrimiento(getAburrimiento() - 30);
                setHambre(getHambre() + 10);
            }
            case MUSICA_BAJA -> {
                setHambre(getHambre() + 10);
                setAburrimiento(getAburrimiento() + 30);
            }
            case CHARLITA_COLOQUIAL, APERTURA_REGALOS -> {
                setAburrimiento(getAburrimiento() - 20);
                setHambre(getHambre() + 10);
            }
        }

    }

    @Override
    public TipoRegalo darRegalo() {
        return regaloQueTrae;
    }
}
