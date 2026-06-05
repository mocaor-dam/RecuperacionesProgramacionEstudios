package examen_global_2.herencias;

public class CuentaPlazoFijo extends Cuenta {
    private int mesesPenalizacion; // Meses que faltan para poder sacar dinero sin penalización

    public CuentaPlazoFijo(String iban, double saldoInicial, int mesesPenalizacion) {
        super(iban, saldoInicial);
        this.mesesPenalizacion = mesesPenalizacion;
    }

    @Override
    public boolean retirarDinero(double cantidad) {
        // TODO 2: RESTRICCIÓN POR CONDICIÓN DE ATRIBUTO
        // Una cuenta a plazo fijo NO permite que el saldo se quede en negativo (debe ser >= 0 siempre).
        //
        // REGLA EXTRA: Si 'mesesPenalizacion' es MAYOR que 0, se puede retirar el dinero,
        // pero se le aplica una penalización del 5% de la cantidad que se va a retirar.
        // Ejemplo: Si quiere sacar 100€, se le descuentan 105€ del saldo.
        //
        // Debes comprobar si el saldo es suficiente para cubrir la cantidad (más la penalización si aplica).
        // Si es viable: descuentas el total del saldo y devuelves true.
        // Si no da el saldo, devuelve false.

        double penalizacion = cantidad + (cantidad * 0.05);
        if (saldo >= 0) {
            if (cantidad <= saldo) {
                if (mesesPenalizacion > 0) {
                    if (saldo >= penalizacion){
                        saldo -= penalizacion;
                        return true;
                    }

                    return false;

                }
                saldo -= cantidad;
                return true;
            }

        }


        return false;
    }
}