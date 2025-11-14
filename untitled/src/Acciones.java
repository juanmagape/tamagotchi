import java.util.Scanner;

public class Acciones {

       static int energia = 20;
       static int hambre = 20;
       static int felicidad = 20;
       static int dinero = 20;
       static int cantidadComida = 5;
       static boolean jugar = true;

    public static void acciones(Scanner print, String skin, String nombre) throws InterruptedException {

        if (energia == 0 || hambre == 0 || felicidad == 0) {
            System.out.println("El tamagotchi ha muerto");
            jugar = false;
        }

        while (jugar) {

            System.out.println("\nQue quieres hacer?\n");

            System.out.println("1 - Dar de comer");
            System.out.println("2 - Jugar");
            System.out.println("3 - Dormir");
            System.out.println("4 - Tienda");
            System.out.println("5 - Ver estado");
            System.out.println("6 - Salir");

            int eleccionAccion = print.nextInt();

            switch (eleccionAccion) {
                case 1:
                    System.out.println("Has escogido la opción: Dar de comer");
                    System.out.println("Cantidad de comida" + cantidadComida);

                    if (cantidadComida == 0) {
                        System.out.println("No tienes comida, ves a comprarla a la tienda");
                    } else {
                        System.out.println("Le has dado de comer");
                        cantidadComida -= 1;

                        hambre += 3;
                        energia -= 1;
                    }

                    Thread.sleep(1000);
                    break;
                case 2:
                    System.out.println("Has escogido la opción: Jugar");
                    System.out.println("Que juego quieres jugar? (1: Dados / 2: Piedra Papel Tijera)");
                    int eleccionJuego = print.nextInt();
                    if (eleccionJuego == 1) {
                        dados();
                    } else if (eleccionJuego == 2) {
                        piedraPapelTijera(print);
                    } else {
                        System.out.println("Número introducido incorrecto");
                    }

                    Thread.sleep(1000);
                    break;
                case 3:
                    System.out.println("Has escogido la opción dormir");
                    System.out.println("La energia aumenta +4 y la felicidad se reduce -1");

                    energia += 4;
                    felicidad -= 1;

                    Thread.sleep(1000);
                    break;
                case 4:
                    System.out.println("Tienda");

                    System.out.println("Bienvenido a la tienda");
                    System.out.println("Quieres comprar comida? (1: Si / 2: No)");
                    System.out.println("Dinero actual: " + dinero);
                    System.out.println("Comida: 3 monedas");
                    int eleccionTienda = print.nextInt();

                    if (eleccionTienda == 1) {
                        System.out.println("Cuanta cantidad de comida quieres comprar?");
                        int cantidadCompra = print.nextInt();

                        if (cantidadCompra * 3 > dinero) {
                            System.out.println("No tienes suficiente dinero");
                        } else {
                            System.out.println("Comida comprada");
                            cantidadComida += cantidadCompra;
                        }
                    }

                    Thread.sleep(1000);
                    break;
                case 5:
                    System.out.println("Estadisticas actuales: \n");

                    System.out.println(energia);
                    System.out.println(hambre);
                    System.out.println(felicidad);
                    System.out.println(dinero);

                    if (felicidad > 7 && hambre > 4 && energia > 5) {
                        System.out.println(skin + nombre + ": Feliz y activo");
                    } else if (energia > 7 && hambre < 5) {
                        System.out.println(skin + nombre + ": Está hiperactivo");
                    } else if (felicidad <= 3 && energia <= 3 && hambre <= 3){
                        System.out.println(skin + nombre + "Está en las ultimas");
                    }

                    if (hambre <= 3) {
                        System.out.println(skin + nombre + ": Tiene hambre, deberias darle de comer");
                    }
                    if (energia <= 3) {
                        System.out.println(skin + nombre + ": Está muy cansado, necesita dormir");
                    }
                    if (felicidad <= 3) {
                        System.out.println(skin + nombre + ": Está triste, juega con él");
                    }

                    Thread.sleep(1000);
                    break;
                case 6:
                    System.out.println("Saliendo del programa");
                    jugar = false;
                    Thread.sleep(1000);
                    break;
            }
        }
    }

    public static void dados() throws InterruptedException {

        int jugador = (int) (Math.random() * 6) + 1;
        int tamagotchi = (int) (Math.random() * 6) + 1;

        if (jugador > tamagotchi) {
            System.out.println("Has ganado!");
            System.out.println("+2 de felicidad | +3 monedas | -2 de energia");

            felicidad += 2;
            dinero += 3;
            energia -= 2;

            Thread.sleep(1000);
        } else if (jugador < tamagotchi) {
            System.out.println("Has perdido!");
            System.out.println("-1 de Felicidad");
            Thread.sleep(1000);

            felicidad -= 1;

        } else {
            System.out.println("Empate, no ha pasado nada");
            Thread.sleep(1000);
        }

    }

    public static void piedraPapelTijera(Scanner print) throws InterruptedException {
        System.out.println("Introduce tu jugada");
        System.out.println("1 - Piedra");
        System.out.println("2 - Papel");
        System.out.println("3 - Tijera");

        int jugada = print.nextInt();
        int jugadaTama = (int) (Math.random() * 2) + 1;
        Thread.sleep(1000);

        System.out.println(jugada);
        System.out.println(jugadaTama);
        Thread.sleep(1000);

        if (jugada == jugadaTama) {
            System.out.println("Empate, no ha pasado nada");
            Thread.sleep(1000);
        } else if (jugada == 1 && jugadaTama == 3 || jugada == 2 && jugadaTama == 1 || jugada == 3 && jugadaTama == 2){
            System.out.println("Has ganado!");
            System.out.println("+2 de felicidad | +3 monedas | -2 de energia");

            felicidad += 2;
            dinero += 3;
            energia -= 2;

            Thread.sleep(1000);

        } else {
            System.out.println("Has perdido!");
            System.out.println("-1 de Felicidad");

            felicidad -= 1;

            Thread.sleep(1000);

        }
    }

}
