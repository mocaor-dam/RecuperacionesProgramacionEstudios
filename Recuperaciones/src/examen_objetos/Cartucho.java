package examen_objetos;

public class Cartucho {
    private String id;
    private String tipo;
    private double potencia;
    private double peso;

    public Cartucho(String id, String tipo, double potencia, double peso) {
        this.id = id;
        this.tipo = tipo;
        this.potencia = potencia;
        this.peso = peso;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
