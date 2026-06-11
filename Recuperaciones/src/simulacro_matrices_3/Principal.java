package simulacro_matrices_3;

import utils.MiEntradaSalida;

public class Principal {

    static void main(String[] args) {
        String[][] matrizVisible = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"}
        };

        String[][] matrizOculta = {
                {"?", "?", "?", "?"},
                {"?", "?", "?", "?"},
                {"?", "?", "?", "?"},
                {"?", "?", "?", "?"}
        };

        int intentos = 6;
        int aciertos = 0;

        int fil1 = 0;
        int col1 = 0;
        int fil2 = 0;
        int col2 = 0;

        while (intentos > 0 && aciertos < 8) {

            imprimirMatriz(matrizOculta);

            fil1 = MiEntradaSalida.solicitarEnteroEnRango("Introduce la primera fila", 0, 3);
            col1 = MiEntradaSalida.solicitarEnteroEnRango("Introduce la primera columna", 0, 3);

            matrizOculta[fil1][col1] = matrizVisible[fil1][col1];

            imprimirMatriz(matrizOculta);

            fil2 = MiEntradaSalida.solicitarEnteroEnRango("Introduce la segunda fila", 0, 3);
            col2 = MiEntradaSalida.solicitarEnteroEnRango("Introduce la segunda columna", 0, 3);

            matrizOculta[fil2][col2] = matrizVisible[fil2][col2];

            imprimirMatriz(matrizOculta);
            if (fil1 != fil2 || col1 != col2) {
                if (matrizOculta[fil1][col1].equals(matrizOculta[fil2][col2])) {
                    System.out.println("HAS ACERTADO, no gastas intento!");
                    aciertos++;
                } else {
                    intentos--;
                    System.out.println("Has fallado, gastas un intento, intentos restantes: " + intentos);

                    matrizOculta[fil1][col1] = "?";
                    matrizOculta[fil2][col2] = "?";
                }
            }
            if (intentos == 0){
                System.out.println("Has gastado los intentos, FIN DEL JUEGO");
                System.out.println("Esta era la solucion: ");
                imprimirMatriz(matrizVisible);
            } else if (aciertos == 8){
                System.out.println("HAS GANADO, FIN DEL JUEGO");
            }


        }


    }

    public static void imprimirMatriz(String[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }


}
