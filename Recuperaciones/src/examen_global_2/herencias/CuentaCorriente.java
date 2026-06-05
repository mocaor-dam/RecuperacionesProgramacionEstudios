package examen_global_2.herencias;

public class CuentaCorriente extends Cuenta {
    private double limiteDescubierto; // El dinero máximo que el banco le deja deber (en negativo)

    public CuentaCorriente(String iban, double saldoInicial, double limiteDescubierto) {
        super(iban, saldoInicial);
        this.limiteDescubierto = limiteDescubierto; // Ejemplo: 500 (significa que puede llegar hasta -500€)
    }

    @Override
    public boolean retirarDinero(double cantidad) {
        // TODO 1: RESTRICCIÓN DE SALDO CON DESCUBIERTO
        // Una cuenta corriente permite retirar dinero siempre que el saldo resultante
        // no sea menor que el límite de descubierto en negativo.
        // Ejemplo: Si saldo es 100 y límite es 500, puedes sacar hasta 600€ (saldo quedaría en -500).
        //
        // REGLA EXTRA: Si el saldo final se queda por debajo de 0 (números rojos),
        // se le resta una comisión fija de 15€ adicionales al saldo por haber descubierto la cuenta.
        //
        // Si la operación es viable: descuentas el dinero (y la comisión si aplica), y devuelves true.
        // Si no hay saldo + límite suficiente para cubrir la cantidad, no se hace nada y devuelve false.

        double saldoResultante = saldo - cantidad;

        if (saldoResultante >= -limiteDescubierto){
            if (saldoResultante < 0){
                saldo = saldoResultante - 15;
                return true;
            }
            saldo = saldoResultante;
            return true;
        }

        return false;
    }
}
