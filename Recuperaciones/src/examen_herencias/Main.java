package examen_herencias;

import exceptions.*;
import utils.MiEntradaSalida2;

import java.util.Random;

public class Main {
    private static final int ROPA_MAX = 4;

    public static void main(String[] args) {
        System.out.println("--- ¡COMIENZA EL CUMPLE DE LOLO! ---");

        // TODO 1: Crea un Array de Invitados de tamaño 10.

        Invitado[] invitados = new Invitado[10];


        // TODO 2: Rellena las primeras posiciones:
        // - 3 Familiares (con nombres y stats aleatorios)

        invitados[0] = new Familiar("Tita Antonia");
        invitados[1] = new Familiar("Tito Antonio");
        invitados[2] = new Familiar("Primo Miguel");


        // - 3 Colegas (con nombres y stats aleatorios)
        invitados[3] = new Colega("Pepe");
        invitados[4] = new Colega("Paco");
        invitados[5] = new Colega("Jose");

        // - 1 Gorrón
        invitados[6] = new Gorron("Juanjo");
        // PISTA: Usa un contador para saber en qué posición del array insertas.


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
            // 1. Cuidado con las posiciones null del array.
            // 2. Verifica si el invitado sigue en la fiesta.
            // 3. Haz que reaccione al evento (gestiona las excepciones).
            // 4. Si es APERTURA_REGALOS y el invitado es regalador:
            //    - Pide el regalo (imprímelo por pantalla).

            for (int i = 0; i < invitados.length; i++) {

                if (invitados[i] != null) {
                    if (!invitados[i].estaFueraJuego()) {
                        invitados[i].reaccionar(eventoActual);
                        if (eventoActual.equals(Evento.APERTURA_REGALOS) && invitados[i] instanceof Regalador regalador) {
                            TipoRegalo regaloRecibido = regalador.darRegalo();
                            if (regaloRecibido.equals(TipoRegalo.ROPA)) {
                                contadorRopa++;
                            }
                        }
                    }
                }

            }


            // TODO 4: Chequeo de fin de fiesta
            // - Si se han regalado 4 prendas de ropa -> Mensaje de decepción.
            // - Si no queda nadie en la fiesta -> Fin con mensaje.
            int invitadosDentro = 0;
            for (int i = 0; i < invitados.length; i++) {
                if (invitados[i] != null && !invitados[i].estaFueraJuego()){
                    invitadosDentro++;
                }
            }
            if (contadorRopa == ROPA_MAX) {
                System.out.println("Esta fiesta es un rollo, SE ACABO LA FIESTA(se han regalado 4 prendas)");
                fiestaSigue = false;
            } else if (invitadosDentro == 0){
                System.out.println("Se ha ido todo el mundo");
                fiestaSigue = false;
            }


            ronda++;
        }
        System.out.println("--- FIN DE LA FIESTA ---");
    }

    private static Evento obtenerEventoAleatorio() {
        // TODO 5: Obtener un evento aleatorio
        //Rellenamos el array con los valores de Evento
        Evento[] eventos = Evento.values();
        //Generamos un aleatorio entre 0 y la longitud del array de eventos -1
        int indiceAleatorio = MiEntradaSalida2.generaAleatorioEntre(0, eventos.length - 1, true);
        //Devolvemos el evento que este en la posicion de evento aleatorio
        return eventos[indiceAleatorio];
    }
}