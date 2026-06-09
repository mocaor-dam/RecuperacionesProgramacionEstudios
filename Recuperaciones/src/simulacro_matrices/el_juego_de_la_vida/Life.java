package simulacro_matrices.el_juego_de_la_vida;

import java.util.Random;

public class Life {
    // 1. ATRIBUTOS SOLICITADOS
    private boolean[][] grid;  // El tablero del juego (true = viva, false = muerta)
    private int population;   // Número actual de células vivas
    private int generation;   // Contador de generaciones

    // CONSTRUCTOR: Inicializa la matriz según las filas y columnas dadas
    public Life(int filas, int columnas) {
        this.grid = new boolean[filas][columnas];
        this.population = 0;
        this.generation = 0;
    }

    public void fillRandom() {
        // TODO 1: LLENAR MATRIZ ALEATORIA
        // Recorre toda la matriz 'grid' y llena cada casilla con un valor aleatorio (true o false).
        // Pista para el azar: puedes usar 'new Random().nextBoolean()' o 'Math.random() < 0.5'.
        // ¡MUY IMPORTANTE!: Cada vez que asignes un 'true', incrementa el atributo 'population'.

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Random().nextBoolean();
                if (grid[i][j] == true) population++;
            }
        }
    }

    public int contarVecinos(int i, int j) {
        // TODO 2: EL "COCO" DEL EXAMEN (Contar vecinos vivos)
        // Debes contar cuántas de las 8 celdas que rodean a la posición (i, j) están VIVAS (true).
        // ¡CUIDADO CON LOS BORDES!: No puedes mirar posiciones fuera de la matriz.
        // Devuelve el número total de vecinos vivos.
        int vecinos = 0;
        for (int f = i - 1; f <= i + 1; f++) {
            for (int c = j - 1; c <= j + 1; c++) {
                if (f >= 0 && c >= 0 && f < grid.length && c < grid[f].length) {
                    if (f != i || c != j){
                        if (grid[f][c] == true){
                            vecinos++;
                        }
                    }
                }
            }
        }


        return vecinos;
    }


    public void siguienteGeneracion() {
        // 1. Crea la nueva matriz temporal. Pista:

        boolean[][] nextGrid = new boolean[grid.length][grid[0].length];



        // 2. Resetea la variable 'population' a 0 porque vamos a contar las nuevas células vivas del futuro.

        this.population = 0;

        // 3. Abre tus dos bucles for tradicionales (i y j) para recorrer 'grid'.

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int numVecinos = contarVecinos(i,j);

                if (grid[i][j] == true){
                    if (numVecinos == 2 || numVecinos == 3){
                        nextGrid[i][j] = true;
                        population++;
                    }
                } else if (numVecinos == 3){
                    nextGrid[i][j] = true;
                    population++;
                }
            }
        }

        generation++;

        grid = nextGrid;



        // Dentro de los bucles:
        // A. Guarda en una variable cuántos vecinos tiene la celda actual llamando a tu método anterior:
        //    int numVecinos = contarVecinos(i, j);

        // B. Aplica las reglas con ifs:
        //    - Si la celda original (grid[i][j]) está viva (true):
        //         Comprueba si numVecinos == 2 o numVecinos == 3. Si se cumple, nextGrid[i][j] = true y population++;
        //    - Si está muerta (false):
        //         Comprueba si numVecinos == 3. Si se cumple, nextGrid[i][j] = true y population++;

        // 4. Al salir de los bucles por completo:
        //    - Suma 1 al contador global 'generation' (generation++;).
        //    - Reemplaza el tablero viejo por el nuevo: grid = nextGrid;
    }



    // Métodos de control rápidos (0.1 puntos cada uno)
    public void init() {
        // TODO 3: REINICIAR
        // Llama a 'fillRandom()' para restablecer el tablero.
        fillRandom();
        // Reinicia 'generation' a 0.
        generation = 0;
    }

    public void tick() {
        // TODO 4: AVANZAR
        // Llama al método 'siguienteGeneracion()' (lo programaremos después).
        siguienteGeneracion();
    }
}