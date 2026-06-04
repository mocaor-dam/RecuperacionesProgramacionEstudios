package examen_global;

public class Taller {
    // Matriz de 3 filas (calles) y 4 columnas (plazas por calle)
    private Vehiculo[][] plazas;

    public Taller() {
        this.plazas = new Vehiculo[3][4]; // Inicialmente todas las posiciones son null
    }

    public boolean aparcarVehiculo(Vehiculo v) {
        // TODO: Recorre la matriz plazas mediante bucles for anidados.
        for (int i = 0; i < plazas.length; i++) {
            for (int j = 0; j < plazas[i].length ; j++) {
                if (plazas[i][j] == null){
                    plazas[i][j] = v;
                    return true;
                }
            }
        }
        // Busca la PRIMERA posición que esté libre (es decir, que sea == null).
        // Si la encuentras, guardas el vehículo 'v' en esa posición y devuelves true.
        // Si recorres to do el taller y no hay ningún hueco libre, devuelves false.
        return false;
    }

    public void mostrarEstadoTaller() {
        // Imprime la cuadrícula para ver qué hay aparcado
        for (int i = 0; i < plazas.length; i++) {
            System.out.print("Calle " + i + " -> ");
            for (int j = 0; j < plazas[i].length; j++) {
                if (plazas[i][j] == null) {
                    System.out.print("[ LIBRE ] ");
                } else {
                    String tipo = (plazas[i][j] instanceof Coche) ? "Coche" : "Moto";
                    System.out.print("[" + tipo + ":" + plazas[i][j].getMatricula() + "] ");
                }
            }
            System.out.println();
        }
    }
}