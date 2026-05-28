package ExamenHerencias;


import exceptions.*;
import utils.MiEntradaSalida2;

import java.util.ArrayList;
import java.util.Random;

public class MainAlumnos {
    private static final int ROPA_MAX = 4;

    public static void main(String[] args) {
        System.out.println("--- ¡COMIENZA EL CUMPLE DE LOLO! ---");


        Invitado[] invitados = new Invitado[10];

        // TODO 2: Rellena las primeras posiciones:
        int contador = 0;

        try {
            invitados[contador] = new Familiar("Tita Antonia");
            contador++;
            invitados[contador] = new Familiar("Mama");
            contador++;
            invitados[contador] = new Familiar("Hermana");
            contador++;

            invitados[contador] = new Colega("Kain");
            contador++;
            invitados[contador] = new Colega("Eric");
            contador++;
            invitados[contador] = new Colega("Javi");
            contador++;

            invitados[contador] = new Gorron("Er merodreja xd");
            contador++;


        } catch (CumpleaniosException e) {
            System.out.println(e.getMessage());
        }




        int ronda = 1;
        boolean fiestaSigue = true;
        boolean yaSeAbrieronRegalos = false;

        int contadorRopa = 0;

        // Bucle de la fiesta (máximo 10 rondas)
        while (fiestaSigue && ronda <= 10) {
            System.out.println("\n--- RONDA " + ronda + " ---");
            Evento eventoActual = obtenerEventoAleatorio();
            System.out.println("Evento: " + eventoActual);

            // Evitamos que se abran regalos dos veces
            while (eventoActual == Evento.APERTURA_REGALOS && yaSeAbrieronRegalos) {
                eventoActual = obtenerEventoAleatorio();
            }

            System.out.println("Evento: " + eventoActual);

            // TODO 3: Recorre el array de invitados
            for (int i = 0; i < invitados.length; i++) {
                // 1. Cuidado con las posiciones null del array.
                if (invitados[i] != null){
                    // 2. Verifica si el invitado sigue en la fiesta.
                    if (!invitados[i].estaFueraDeJuego()){
                        try {
                            // 3. Haz que reaccione al evento (gestiona las excepciones).
                            String mensajeRegalo = invitados[i].reaccionar(eventoActual);

                            // 4. Si es APERTURA_REGALOS y el invitado es regalador:
                            if (eventoActual == Evento.APERTURA_REGALOS && mensajeRegalo != null && invitados[i] instanceof Regalador) {
                                //    - Pide el regalo (imprímelo por pantalla).
                                System.out.println(mensajeRegalo);
                                if (mensajeRegalo.toUpperCase().contains("ROPA")) {
                                    contadorRopa++;
                                }
                                yaSeAbrieronRegalos = true;


                            }
                            if (invitados[i].estaFueraDeJuego()){
                                if (invitados[i] instanceof Gorron){
                                    System.out.println(invitados[i].getNombre() + " se va de la fiesta hasta arriba de comida. ¡Adiós pringaos!");
                                }
                                else if (invitados[i].getNivelHambre() >= 100) {
                                    System.out.println(invitados[i].getNombre() + " se ha ido hambriento.");
                                } else if (invitados[i].getNivelAburrimiento() >= 100) {
                                    System.out.println(invitados[i].getNombre() + " se va de la fiesta aburrido.");
                                }
                            }

                        } catch (CumpleaniosException e){
                            System.out.println(e.getMessage());
                        }


                    }


                }

            }


            // TODO 4: Chequeo de fin de fiesta
            // - Si se han regalado 4 prendas de ropa -> Mensaje de decepción.

            if (contadorRopa == 4){
                System.out.println("Han regalado 4 prendas de ropa esta fiesta es un asco. Se acabo la fiesta!");
                fiestaSigue = false;
            }

            int invitadosEnFiesta = 0;

            for (int i = 0; i < invitados.length; i++) {
                if (invitados[i] != null){
                    if (!invitados[i].estaFueraDeJuego()){
                        invitadosEnFiesta++;
                        if (invitadosEnFiesta == 0){
                            fiestaSigue = false;
                        }
                    }
                }
            }
            // - Si no queda nadie en la fiesta -> Fin con mensaje.

            ronda++;
        }
        System.out.println("--- FIN DE LA FIESTA ---");
    }

    private static Evento obtenerEventoAleatorio() {
        Evento[] eventos = Evento.values();
        int indiceAleatorio = MiEntradaSalida2.generaAleatorioEntre(0, eventos.length - 1, true);
       return eventos[indiceAleatorio];
    }
}