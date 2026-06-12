package examen_objetos;

public class Deposito {
    private Cartucho[] cartuchos;

    public Deposito() {
        this.cartuchos = new Cartucho[5];
    }

    public boolean agregarCartucho(Cartucho cartucho) {
        for (int i = 0; i < cartuchos.length; i++) {
            if (cartuchos[i] == null) {
                cartuchos[i] = cartucho;
                return true;
            }
        }
        return false;
    }

    public double calcularPotenciaTotal() {
        double potenciaTotal = 0.0;
        for (int i = 0; i < cartuchos.length; i++) {
            if (cartuchos[i] != null) {
                potenciaTotal += cartuchos[i].getPotencia();
            }
        }
        return potenciaTotal;
    }

    public double calcularPesoTotal() {
        double pesoTotal = 0.0;
        for (int i = 0; i < cartuchos.length; i++) {
            if (cartuchos[i] != null) {
                pesoTotal += cartuchos[i].getPeso();
            }
        }
        return pesoTotal;
    }

    public int contarCartuchosDeTipo(String tipo) {
        int numCartuchos = 0;
        for (int i = 0; i < cartuchos.length; i++) {
            if (cartuchos[i] != null) {
                if (cartuchos[i].getTipo().equals(tipo)) {
                    numCartuchos++;
                }
            }
        }
        return numCartuchos;
    }

    public double calcularPesoCartuchoTipo(String tipo) {
        double pesoCartucho = 0.0;
        for (int i = 0; i < cartuchos.length; i++) {
            if (cartuchos[i] != null) {
                if (cartuchos[i].getTipo().equals(tipo)) {
                    pesoCartucho += cartuchos[i].getPeso();
                }
            }
        }
        return pesoCartucho;
    }
}
