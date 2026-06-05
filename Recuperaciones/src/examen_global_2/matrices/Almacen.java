package examen_global_2.matrices;

public class Almacen {
    // Matriz de 4 estanterías (filas) con 5 huecos cada una (columnas)
    private int[][] estanterias = {
            {10, 20, 0, 15, 30},
            {5,  0,  8,  12, 0},
            {40, 50, 10, 20, 30},
            {0,  15, 25, 0,  10}
    };

    public int[] buscarUltimoPaqueteGrande(int pesoMinimo) {
        // TODO 1: RECORRIDO AL REVÉS

        // Tienes que recorrer la matriz DESDE LA ÚLTIMA POSICIÓN (abajo a la derecha)
        // HASTA LA PRIMERA (arriba a la izquierda).
        // Busca el primer paquete que pese MÁS o IGUAL que 'pesoMinimo'.
        // En cuanto lo encuentres, debes devolver un array de dos posiciones: {fila, columna}.
        // Si recorres toda la matriz y no encuentras ninguno, devuelve null.


        for (int i = estanterias.length -1; i >= 0; i--) {
            for (int j = estanterias[i].length -1; j >= 0; j--) {

                if (estanterias[i][j] >= pesoMinimo){
                    return new int[]{i,j};
                }

            }
        }




        return null;
    }

    public int filaMasPesada() {
        // TODO 2: OPERACIÓN POR FILAS
        // Tienes que calcular cuál de las 4 estanterías (filas) acumula más peso en total.
        // Sumas los pesos de la fila 0, luego la fila 1, etc.
        // El método debe devolver el NÚMERO DE LA FILA (0, 1, 2 o 3) que sea la más pesada.

        int fila1 = 0;
        int fila2 = 0;
        int fila3 = 0;
        int fila4 = 0;

        for (int i = 0; i < estanterias.length; i++) {
            for (int j = 0; j < estanterias[i].length; j++) {
                if (i == 0){
                    fila1 += estanterias[i][j];
                }

                if (i == 1){
                    fila2 += estanterias[i][j];
                }

                if (i == 2){
                    fila3 += estanterias[i][j];
                }

                if (i == 3){
                    fila4 += estanterias[i][j];
                }


            }


        }


        if (fila1 >= fila2){
            if (fila1>=fila3){
                if (fila1>=fila4){
                    return 0;
                }
            }
        }

        if (fila2 >= fila1){
            if (fila2>=fila3){
                if (fila2>=fila4){
                    return 1;
                }
            }
        }

        if (fila3 >= fila1){
            if (fila3>=fila2){
                if (fila3>=fila4){
                    return 2;
                }
            }
        }

        if (fila4 >= fila1){
            if (fila4>=fila2){
                if (fila4>=fila3){
                    return 3;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Almacen a = new Almacen();

        System.out.println("--- PROBANDO MATRICES DE ALTA DIFICULTAD ---");
        // El último paquete que pesa 40kg o más empezando por el final debería ser el de la fila 2, columna 4 (el 30 no, el 20 no... el 30 no, el 20 no, el 10 no, el 50 sí!)
        int[] pos = a.buscarUltimoPaqueteGrande(45);
        if(pos != null) {
            System.out.println("Último paquete grande encontrado en: Fila " + pos[0] + ", Columna " + pos[1]);
        }

        System.out.println("La estantería (fila) que más pesa es la número: " + a.filaMasPesada());
    }
}