package examen_objetos;

import exceptions.NaveException;

public class Nave {
    private String nombre;
    private Deposito[] depositos;

    public Nave(String nombre) {
        this.nombre = nombre;
        this.depositos = new Deposito[3];
        rellenarDepositos(depositos);
    }

    public void rellenarDepositos(Deposito[] depositos) {
        for (int i = 0; i < depositos.length; i++) {
            depositos[i] = new Deposito();
        }
    }

    public boolean cargarDeposito(int indice, Cartucho cartucho) throws NaveException {
        if (indice > 2 || indice < 0){
            throw new NaveException("Introduce un indice con un valor valido (0-2)");
        }
        return depositos[indice].agregarCartucho(cartucho);
    }

    public double calcularPotenciaTotal(){
        double potenciaTotal = 0.0;
        for (int i = 0; i < depositos.length; i++) {
            potenciaTotal += depositos[i].calcularPotenciaTotal();
        }
        return potenciaTotal;
    }

    public double calcularPesoTotal(){
        double pesoTotal = 0.0;
        for (int i = 0; i < depositos.length; i++) {
           pesoTotal += depositos[i].calcularPesoTotal();
        }
        return pesoTotal;
    }

    public boolean checkAntimateria(){
        for (int i = 0; i < depositos.length; i++) {
            if (depositos[i].contarCartuchosDeTipo("antimateria") > 1){
                return true;
            }
        }
        return false;
    }

    public double calcularPesoPlasmaVerde(){
        double pesoPlasmaVerde = 0.0;
        for (int i = 0; i < depositos.length; i++) {
           pesoPlasmaVerde += depositos[i].calcularPesoCartuchoTipo("plasma verde");
        }
        return pesoPlasmaVerde;
    }

    public boolean hayUnaAntimateriaPorDeposito(){
        int contador = 0;
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

    public void saltarHiperespacio() throws NaveException {
        if (checkAntimateria() == true){
            throw new NaveException("Error critico: EXPLOSION!");
        }
        if (calcularPotenciaTotal() <= 1000){
            throw new NaveException("Fallo: Potencia Insuficiente");
        }
        if (!hayUnaAntimateriaPorDeposito() && calcularPesoPlasmaVerde() <= (calcularPesoTotal() / 2)){
            throw new NaveException("FALLO: Configuracion quimica inestable");
        }
        System.out.println("SALTO A HIPERESPACIO INICIADO... BUEN VIAJE");
    }


    public String getNombre() {
        return nombre;
    }
}
