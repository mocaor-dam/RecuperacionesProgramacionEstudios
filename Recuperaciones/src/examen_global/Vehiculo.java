package examen_global;

public abstract class Vehiculo {
    private String matricula;
    private String marca;
    private int kilometros;
    private double precioBase;

    public Vehiculo(String matricula, String marca, int kilometros, double precioBase) {
        this.matricula = matricula;
        this.marca = marca;
        this.kilometros = kilometros;
        this.precioBase = precioBase;
    }

    public String getMatricula() { return matricula; }
    public String getMarca() { return marca; }
    public  int getKilometros() { return kilometros; }
    public double getPrecioBase() { return precioBase; }

    // Método abstracto: cada hijo lo implementará a su manera
    public abstract double calcularPrecioMantenimiento();

    @Override
    public String toString() {
        return "[%s] %s (%d km) - Precio: %.2f€".formatted(matricula, marca, kilometros, precioBase);
    }
}