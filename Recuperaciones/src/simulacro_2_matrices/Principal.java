package simulacro_2_matrices;

import utils.MiEntradaSalida;
import utils.MiEntradaSalida2;

public class Principal {
    static void main(String[] args) {
        String[][] matrizVisible = {
                {"1","2","3","4"},
                {"5","6","7","8"},
                {"1","2","3","4"},
                {"5","6","7","8"}
        };

        String[][] matrizOculta = {
                {"?","?","?","?"},
                {"?","?","?","?"},
                {"?","?","?","?"},
                {"?","?","?","?"}
        };

       int aciertos = 0;

        int intentos = 6;

        int fila1 = 0;
        int col1 = 0;


        int fila2 = 0;
        int col2 = 0;

            while(intentos > 0 && aciertos < 8) {


                imprimirMatriz(matrizOculta);
                fila1 = MiEntradaSalida2.leerEnteroRango("Selecciona la primera fila(0-3): ", 0, 3);
                col1 = MiEntradaSalida2.leerEnteroRango("Selecciona tu primera columna(0-3): ", 0, 3);

                matrizOculta[fila1][col1] = matrizVisible[fila1][col1];

                imprimirMatriz(matrizOculta);

                fila2 = MiEntradaSalida2.leerEnteroRango("Selecciona la segunda fila(0-3): ", 0, 3);
                col2 = MiEntradaSalida2.leerEnteroRango("Selecciona la segunda columna(0-3): ", 0, 3);

                matrizOculta[fila2][col2] = matrizVisible[fila2][col2];

                imprimirMatriz(matrizOculta);


                if (matrizVisible[fila1][col1].equals(matrizVisible[fila2][col2])){
                    imprimirMatriz(matrizOculta);
                    System.out.println("Has acertado! no gastas intento");
                    aciertos++;
                } else {
                    intentos--;

                    System.out.println("Has fallado, malo. \n Te quedan " + intentos + " intentos");

                    matrizOculta[fila1][col1] = "?";
                    matrizOculta[fila2][col2] = "?";

                }


                if (aciertos == 8){
                    System.out.println("HAS GANADO!, el juego se termina \n FIN DEL JUEGO.");
                } else if (intentos == 0){
                    System.out.println("Has agotado todos los intentos, este era el resultado");
                    imprimirMatriz(matrizVisible);
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
