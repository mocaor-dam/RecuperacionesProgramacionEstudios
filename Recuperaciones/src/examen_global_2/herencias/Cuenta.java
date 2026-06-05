package examen_global_2.herencias;

public abstract class Cuenta {
    private String iban;
    protected double saldo; // protected para que las clases hijas puedan modificarlo directamente

    public Cuenta(String iban, double saldoInicial) {
        this.iban = iban;
        this.saldo = saldoInicial;
    }

    public String getIban() { return iban; }
    public double getSaldo() { return saldo; }

    // Método abstracto que cada cuenta implementará según sus restricciones
    public abstract boolean retirarDinero(double cantidad);

    public void ingresarDinero(double cantidad) {
        if (cantidad > 0) {
            this.saldo += cantidad;
        }
    }
}