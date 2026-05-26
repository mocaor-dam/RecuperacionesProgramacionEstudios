import utils.MiEntradaSalida;

import java.sql.SQLOutput;

public class ExamenMatrices {
    public static void main(String[] args) {
        String[][] matrizOculta = {
                {"?", "?", "?", "?"},
                {"?", "?", "?", "?"},
                {"?", "?", "?", "?"},
                {"?", "?", "?", "?"}
        };

        String[][] matrizVisible = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"}
        };

        int intentos = 6;

        int fila1 = 0;
        int columna1 = 0;
        int fila2 = 0;
        int columna2 = 0;

        int aciertos = 0;

        while (intentos > 0 && aciertos < 8) {
            imprimirMatriz(matrizOculta);
            fila1 = MiEntradaSalida.solicitarEnteroEnRango("Introduce tu primera fila(0-3)", 0,3);
            columna1 = MiEntradaSalida.solicitarEnteroEnRango("Introduce tu primera columna(0-3)", 0,3);

            matrizOculta[fila1][columna1] = matrizVisible[fila1][columna1];

            imprimirMatriz(matrizOculta);

            fila2 = MiEntradaSalida.solicitarEnteroEnRango("Introduce tu segunda fila(0-3)", 0,3);
            columna2 = MiEntradaSalida.solicitarEnteroEnRango("Introduce tu segunda columna(0-3)", 0,3);

            matrizOculta[fila2][columna2] = matrizVisible[fila2][columna2];


            imprimirMatriz(matrizOculta);


            if (matrizVisible[fila1][columna1].equals(matrizVisible[fila2][columna2])){
                System.out.println("Has encontrado una pareja!");
                aciertos++;
            } else {
                intentos--;
                System.out.println("Error, has perdido un intento, te quedan: " + intentos + " intentos.");

                matrizOculta[fila1][columna1] = "?";
                matrizOculta[fila2][columna2] = "?";
            }
        }
        if (aciertos == 8){
            System.out.println("\n ENHORABUENA!, has encontrado todas las parejas!. \nFIN DEL JUEGO");
        } else if (intentos == 0){
            System.out.println("Has agotado tus intentos, FIN DEL JUEGO");
            System.out.println("Esta era la solucion: ");
            imprimirMatriz(matrizVisible);
        }

    }


    public static void imprimirMatriz(String[][] matriz){
        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");

            }
            System.out.println();
        }
    }
}
