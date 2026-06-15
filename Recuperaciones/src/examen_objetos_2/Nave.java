package examen_objetos_2;

import exceptions.NaveException;

import java.awt.event.MouseMotionAdapter;
import java.util.IllegalFormatCodePointException;

public class Nave {
    private String nombre;
    private Deposito[] depositos;

    public Nave(String nombre) {
        this.nombre = nombre;
        this.depositos = new Deposito[3];
        cargarDepositosArray(depositos);
    }

    public void cargarDepositosArray(Deposito[] depositos){
        for (int i = 0; i < depositos.length; i++) {
            depositos[i] = new Deposito();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public boolean cargarDeposito(int indice, Cartucho cartucho) throws NaveException {
        if (indice > 2 || indice < 0){
            throw new NaveException("Tiene que estar entre 0 y 2");
        }
        return depositos[indice].agregarCartucho(cartucho);
    }

    public double calcularPotenciaTotalNave(){
       double potenciaTotal = 0.0;
        for (int i = 0; i < depositos.length; i++) {
            if (depositos[i] != null){
                potenciaTotal += depositos[i].calcularPotenciaTotal();
            }
        }
        return potenciaTotal;
    }

    public double calcularPesoTotalNave(){
        double pesoTotal = 0.0;
        for (int i = 0; i < depositos.length; i++) {
            if (depositos[i] != null){
                pesoTotal += depositos[i].calcularPesoTotal();
            }
        }
        return pesoTotal;
    }

    public boolean checkAntimateria(){
        for (int i = 0; i < depositos.length; i++) {
            if (depositos[i].contarCartuchosDeTipo("antimateria") >= 2){
                return true;
            }
        }
        return false;
    }

    public boolean hayUnaAntimateriaPorDeposito(){
        int contador = 0;
        int numAntimateria;
        for (int i = 0; i < depositos.length; i++) {
            if (depositos[i].contarCartuchosDeTipo("antimateria") == 1){
                contador++;
            }
        }
        if (contador == 3){
            return true;
        }
        return false;
    }

    public double calcularPesoPlasmaVerde(){
        double pesoVerde = 0.0;
        for (int i = 0; i < depositos.length; i++) {
            pesoVerde += depositos[i].calcularPesoCartuchoTipo("plasma verde");
        }
        return pesoVerde;
    }

    public void saltarHiperespacio() throws NaveException {
        if (checkAntimateria() == true){
            throw new NaveException("ERROR CRÍTICO: ¡EXPLOSIÓN!");
        }

        if (calcularPotenciaTotalNave() <= 1000){
            throw new NaveException("FALLO: Potencia insuficiente");
        }

        if (!hayUnaAntimateriaPorDeposito() && calcularPesoPlasmaVerde() > (calcularPesoTotalNave() / 2)){
            throw new NaveException("FALLO: Configuración química inestable");
        }
        System.out.println("SALTO A HIPERESPACIO INICIADO... BUEN VIAJE");
    }
}
