package examen_global;

public class Moto extends Vehiculo {
    private int cilindrada; // Ejemplo: 125, 500, 600

    public Moto(String matricula, String marca, int kilometros, double precioBase, int cilindrada) {
        super(matricula, marca, kilometros, precioBase);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() { return cilindrada; }

    @Override
    public double calcularPrecioMantenimiento() {
        // TODO: El mantenimiento base de una moto es de 80€.
        double precioMantenimiento = 80.00;
        if (getCilindrada() > 500){
            precioMantenimiento += 40;
        }
        // Si la cilindrada es mayor de 500cc, se le suman 40€ más al coste.
        return precioMantenimiento;
    }


}