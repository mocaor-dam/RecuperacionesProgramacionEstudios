package simulacro_matrices;

public class MapaJuego {

    private int[][] mapa = {
            {0, 15, 0, 30},
            {45, 0, 10, 5},
            {20, 80, 0, 0},
            {0, 5, 60, 12}
    };

    public boolean moverEnemigo(int filaOrigen, int colOrigen, int filaDestino, int colDestino) {
        // TODO 1: VALIDACIÓN Y MOVIMIENTO
        // Un enemigo que está en 'filaOrigen' y 'colOrigen' quiere moverse a 'filaDestino' y 'colDestino'.
        // Para que el movimiento sea válido se tienen que cumplir dos condiciones:
        //   1. En la casilla de ORIGEN tiene que haber un enemigo (fuerza > 0).
        //   2. En la casilla de DESTINO NO puede haber nadie (fuerza == 0).
        //
        // Si el movimiento es válido:
        //   - Copias la fuerza del enemigo a la casilla de destino.
        //   - Dejas la casilla de origen en 0 (vacía).
        //   - Devuelves true.
        // Si no es válido, no haces nada y devuelves false.


        if (mapa[filaOrigen][colOrigen] > 0 && mapa[filaDestino][colDestino] == 0) {
            mapa[filaDestino][colDestino] = mapa[filaOrigen][colOrigen];
            mapa[filaOrigen][colOrigen] = 0;
            return true;
        }


        return false;
    }

    public int contarEnemigosPeligrosos(int nivelFuerza) {
        // TODO 2: RECORRIDO COMPLETO CON FILTRO
        // Tienes que recorrer todo el mapa de arriba a abajo.
        // Cuenta cuántos enemigos tienen una fuerza ESTRICTAMENTE MAYOR que 'nivelFuerza'.
        // Devuelve el total de enemigos encontrados que cumplan la condición.

        int contador = 0;

        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                if (mapa[i][j] > nivelFuerza) {
                    contador++;
                }
            }

        }


        return contador;
    }

    public boolean hayEnemigoMasFuerteEnEsquinas(int fila, int col) {
        // TODO 3: COMPARACIÓN CON POSICIONES FIJAS
        // Te dan una posición cualquiera del mapa mediante 'fila' y 'col'.
        // Tienes que comprobar si el enemigo que está en esa casilla es MENOR
        // en fuerza que cualquiera de los enemigos que están en las 4 ESQUINAS del mapa.
        //
        // Las 4 esquinas del mapa son:
        //   - Esquina superior izquierda: [0][0]
        //   - Esquina superior derecha:   [0][3]
        //   - Esquina inferior izquierda: [3][0]
        //   - Esquina inferior derecha:   [3][3]
        //
        // Si el enemigo de la posición dada es MENOR que la esquina superior izquierda,
        // O menor que la superior derecha, O menor que la inferior izquierda, O menor que la inferior derecha...
        // debes devolver true (significa que hay un jefe más fuerte en las esquinas).
        // Si no es menor que ninguna, devuelves false.

        if (mapa[fila][col] < mapa[0][0]){
            return true;
        }

        if (mapa[fila][col] < mapa[0][3]){
            return true;
        }
        if (mapa[fila][col] < mapa[3][0]){
            return true;
        }
        if (mapa[fila][col] < mapa[3][3]){
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        MapaJuego juego = new MapaJuego();

        System.out.println("--- SIMULACRO DE MATRICES ---");

        // Prueba 1: Mover al enemigo de la fila 0, columna 1 (fuerza 15) a la fila 0, columna 2 (vacía)
        boolean movido = juego.moverEnemigo(0, 1, 0, 2);
        System.out.println("¿Movimiento 1 exitoso? (Debería ser true): " + movido);

        // Prueba 2: Intentar mover a una casilla ocupada (fila 1, col 0 tiene un 45, col 2 tiene un 10)
        boolean movidoFalso = juego.moverEnemigo(1, 0, 1, 2);
        System.out.println("¿Movimiento 2 exitoso? (Debería ser false): " + movidoFalso);

        // Prueba 3: Contar cuántos enemigos tienen más de 15 de fuerza
        // (En el mapa original hay: 30, 45, 20, 80, 60 -> Deberían ser 5)
        System.out.println("Enemigos peligrosos con fuerza > 15 (Deberían ser 5): " + juego.contarEnemigosPeligrosos(15));
    }
}




