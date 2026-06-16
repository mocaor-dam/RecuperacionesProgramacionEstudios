package examen_herencias;

import exceptions.CumpleaniosException;
import utils.MiEntradaSalida2;

public class Familiar extends Invitado implements Regalador{
    private static final int MIN_HAMBRE = 30;
    private static final int MAX_HAMBRE = 60;
    private static final int MIN_ABURRIMIENTO = 0;
    private static final int MAX_ABURRIMIENTO = 50;


    private TipoRegalo regaloQueTrae;

    public Familiar(String nombre) {
        super(nombre,
                MiEntradaSalida2.generaAleatorioEntre(MIN_HAMBRE, MAX_HAMBRE, true),
                MiEntradaSalida2.generaAleatorioEntre(MIN_ABURRIMIENTO, MAX_ABURRIMIENTO, true));
        regaloAleatorio();

    }

    public void regaloAleatorio(){
        if (MiEntradaSalida2.generaAleatorioEntre(1,2,true) == 1){
            this.regaloQueTrae = TipoRegalo.DINERO;
        } else {
            this.regaloQueTrae = TipoRegalo.ROPA;
        }
    }

    public TipoRegalo getRegaloQueTrae() {
        return regaloQueTrae;
    }

    public void setRegaloQueTrae(TipoRegalo regaloQueTrae) {
        this.regaloQueTrae = regaloQueTrae;
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
            case MUSICA_ALTA -> {
                setAburrimiento(getAburrimiento() + 20);
                setHambre(getHambre() + 10);
            }
            case MUSICA_BAJA, CHARLITA_COLOQUIAL, APERTURA_REGALOS -> {
                setAburrimiento(getAburrimiento() - 20);
                setHambre(getHambre() + 10);
            }

            case BAILE -> {
                setAburrimiento(getAburrimiento() - 15);
                setHambre(getHambre() + 10);
            }

        }

    }

    @Override
    public TipoRegalo darRegalo() {
        return regaloQueTrae;
    }
}
