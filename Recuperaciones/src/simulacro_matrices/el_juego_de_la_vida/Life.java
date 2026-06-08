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
    }

    public int contarVecinos(int i, int j) {
        // TODO 2: EL "COCO" DEL EXAMEN (Contar vecinos vivos)
        // Debes contar cuántas de las 8 celdas que rodean a la posición (i, j) están VIVAS (true).
        // ¡CUIDADO CON LOS BORDES!: No puedes mirar posiciones fuera de la matriz.
        // Devuelve el número total de vecinos vivos.
        return 0;
    }

    // Métodos de control rápidos (0.1 puntos cada uno)
    public void init() {
        // TODO 3: REINICIAR
        // Llama a 'fillRandom()' para restablecer el tablero.
        // Reinicia 'generation' a 0.
    }

    public void tick() {
        // TODO 4: AVANZAR
        // Llama al método 'siguienteGeneracion()' (lo programaremos después).
    }
}