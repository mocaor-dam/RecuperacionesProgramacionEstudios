package examen_objetos_2;

import examen_objetos.Cartucho;
import examen_objetos.Nave;
import exceptions.NaveException;

public class Principal {
    public static void main(String[] args) {
        /*
         Crearemos 5 instancias de naves y las cargaremos con cartuchos de distintos tipos y potencias.
         - La nave 1, "Enterprise", no podrá volar por contar con 2 cartuchos de antimateria en un mismo depósito.
           - Depósito 0: 2 cartuchos de antimateria, 1 de plasma verde
           - Depósito 1: 1 cartucho de plasma verde, 2 de plasma rojo
           - Depósito 2: 1 cartucho de plasma rojo, 1 de plasma verde

         - La nave 2, "Millennium Falcon", no podrá volar por no contar con un cartucho de antimateria en el último depósito
         ni tener más del 50% del peso de su combustible en plasma verde.
           - Depósito 0: 1 cartucho de antimateria, 2 de plasma verde
           - Depósito 1: 2 cartuchos de plasma rojo, 1 de plasma verde, 1 de antimateria
           - Depósito 2: 3 cartuchos de plasma rojo

         - La nave 3, "Serenity", podrá volar gracias a que más del 50% del peso de su combustible es de plasma verde

         - La nave 4 podrá volar por tener un cartucho de antimateria en cada depósito
         - La nave 5 no podrá volar por no tener potencia suficiente
         */

        examen_objetos.Nave enterprise = new examen_objetos.Nave("Enterprise");
        cargarDeposito(enterprise, 0, new examen_objetos.Cartucho[]{
                new examen_objetos.Cartucho("C1", "antimateria", 500, 50),
                new examen_objetos.Cartucho("C2", "antimateria", 500, 50),
                new examen_objetos.Cartucho("C3", "plasma verde", 300, 30)
        });
        cargarDeposito(enterprise, 1, new examen_objetos.Cartucho[]{
                new examen_objetos.Cartucho("C4", "plasma verde", 300, 30),
                new examen_objetos.Cartucho("C5", "plasma rojo", 200, 20),
                new examen_objetos.Cartucho("C6", "plasma rojo", 200, 20)
        });
        cargarDeposito(enterprise, 2, new examen_objetos.Cartucho[]{
                new examen_objetos.Cartucho("C7", "plasma rojo", 200, 20),
                new examen_objetos.Cartucho("C8", "plasma verde", 300, 30)
        });

        examen_objetos.Nave millenniumFalcon = new examen_objetos.Nave("Millennium Falcon");
        cargarDeposito(millenniumFalcon, 0, new examen_objetos.Cartucho[]{
                new examen_objetos.Cartucho("C9", "antimateria", 500, 50),
                new examen_objetos.Cartucho("C10", "plasma verde", 300, 30),
                new examen_objetos.Cartucho("C11", "plasma verde", 300, 30)
        });
        cargarDeposito(millenniumFalcon, 1, new examen_objetos.Cartucho[]{
                new examen_objetos.Cartucho("C12", "plasma rojo", 200, 20),
                new examen_objetos.Cartucho("C13", "plasma rojo", 200, 20),
                new examen_objetos.Cartucho("C14", "plasma verde", 300, 30),
                new examen_objetos.Cartucho("C15", "antimateria", 500, 50)
        });
        cargarDeposito(millenniumFalcon, 2, new examen_objetos.Cartucho[]{
                new examen_objetos.Cartucho("C16", "plasma rojo", 200, 20),
                new examen_objetos.Cartucho("C17", "plasma rojo", 200, 20),
                new examen_objetos.Cartucho("C18", "plasma rojo", 200, 20)
        });

        examen_objetos.Nave serenity = new examen_objetos.Nave("Serenity");
        cargarDeposito(serenity, 0, new examen_objetos.Cartucho[]{
                new examen_objetos.Cartucho("C19", "plasma verde", 300, 60),
                new examen_objetos.Cartucho("C20", "plasma verde", 300, 60)
        });
        cargarDeposito(serenity, 1, new examen_objetos.Cartucho[]{
                new examen_objetos.Cartucho("C21", "plasma verde", 300, 60),
                new examen_objetos.Cartucho("C22", "plasma rojo", 200, 20)
        });
        cargarDeposito(serenity, 2, new examen_objetos.Cartucho[]{
                new examen_objetos.Cartucho("C23", "plasma verde", 300, 60),
                new examen_objetos.Cartucho("C24", "plasma rojo", 200, 20)
        });


        examen_objetos.Nave planetExpress = new examen_objetos.Nave("Planet Express");
        cargarDeposito(planetExpress, 0, new examen_objetos.Cartucho[]{
                new examen_objetos.Cartucho("C25", "antimateria", 500, 50)
        });
        cargarDeposito(planetExpress, 1, new examen_objetos.Cartucho[]{
                new examen_objetos.Cartucho("C26", "antimateria", 500, 50)
        });
        cargarDeposito(planetExpress, 2, new examen_objetos.Cartucho[]{
                new examen_objetos.Cartucho("C27", "antimateria", 500, 50)
        });

        examen_objetos.Nave weakShip = new examen_objetos.Nave("Weak Ship");
        cargarDeposito(weakShip, 0, new examen_objetos.Cartucho[]{
                new examen_objetos.Cartucho("C28", "plasma rojo", 100, 20)
        });
        cargarDeposito(weakShip, 1, new examen_objetos.Cartucho[]{
                new examen_objetos.Cartucho("C29", "plasma rojo", 100, 20),
                new examen_objetos.Cartucho("C29-2", "plasma rojo", 100, 20),
                new examen_objetos.Cartucho("C29-3", "plasma rojo", 100, 20),
                new examen_objetos.Cartucho("C29-4", "plasma rojo", 100, 20),
                new examen_objetos.Cartucho("C29-5", "plasma rojo", 100, 20),
                new examen_objetos.Cartucho("C29-6", "plasma rojo", 100, 20),
        });
        cargarDeposito(weakShip, 2, new examen_objetos.Cartucho[]{
                new examen_objetos.Cartucho("C30", "plasma rojo", 100, 20)
        });

        probarNave(enterprise);
        probarNave(millenniumFalcon);
        probarNave(serenity);
        probarNave(planetExpress);
        probarNave(weakShip);


    }

    /**
     * Carga un depósito de la nave con los cartuchos proporcionados.
     * @param nave La nave a la que se le cargará el depósito.
     * @param depositoIndex Índice del depósito a cargar.
     * @param cartuchos Array de cartuchos a cargar en el depósito.
     */
    private static void cargarDeposito(examen_objetos.Nave nave, int depositoIndex, examen_objetos.Cartucho[] cartuchos) {
        try {
            for (Cartucho c : cartuchos) {
                boolean cargado = nave.cargarDeposito(depositoIndex, c);
                if (!cargado) {
                    System.out.println("No se pudo cargar el cartucho " + c.getId() + " en el depósito " + depositoIndex);
                }
            }
        } catch (NaveException e) {
            System.out.println("Error al cargar el depósito: " + e.getMessage());
        }
    }

    /**
     * Prueba si una nave puede saltar al hiperespacio e imprime el resultado.
     * @param nave La nave a probar.
     */
    private static void probarNave(Nave nave) {
        try {
            nave.saltarHiperespacio();
            System.out.printf("La nave %s ha saltado al hiperespacio correctamente.%n", nave.getNombre());
        } catch (NaveException e) {
            System.out.printf("La nave %s no puede saltar al hiperespacio: %s%n", nave.getNombre(), e.getMessage());
        }
    }
}
