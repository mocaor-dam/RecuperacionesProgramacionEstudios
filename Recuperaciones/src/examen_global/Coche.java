package examen_global;

public class Coche extends Vehiculo {
    private boolean esHibrido;

    public Coche(String matricula, String marca, int kilometros, double precioBase, boolean esHibrido) {
        super(matricula, marca, kilometros, precioBase);
        // TODO: Invoca al constructor de la clase padre (Vehiculo)
        this.esHibrido = esHibrido;
    }

    public boolean isEsHibrido() { return esHibrido; }

    @Override
    public double calcularPrecioMantenimiento() {
        // TODO: El mantenimiento de un coche base es de 150€.
        double precioMantenimiento = 150.00;
        // Si el coche tiene más de 100.000 km, se le suman 50€ más.
        if (getKilometros() > 100000){
            precioMantenimiento += 50;
        }
        // Si además esHibrido es true, se le hace un descuento de 30€ al total.

        if (esHibrido){
            precioMantenimiento -= 30;
        }
        return precioMantenimiento;
    }
}