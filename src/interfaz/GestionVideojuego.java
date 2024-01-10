package interfaz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dominio.Videojuego;

public class GestionVideojuego {

    private static final int AGREGAR_VIDEOJUEGO = 1;
    private static final int VER_VIDEOJUEGOS = 2;
    private static final int CAMBIAR_NOMBRE_VIDEOJUEGO = 3;
    private static final int CAMBIAR_CANTIDAD_JUGADORES = 4;
    private static final int VIDEOJUEGOS_NINTENDO = 5;
    private static final int SALIR = 6;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Videojuego> videojuegos = new ArrayList<>();

        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion) {
                case AGREGAR_VIDEOJUEGO:
                    agregarVideojuego(videojuegos, sc);
                    break;
                case VER_VIDEOJUEGOS:
                    listaVideojuegos(videojuegos);
                    break;
                case CAMBIAR_NOMBRE_VIDEOJUEGO:
                    cambiarNombreVideojuego(videojuegos, sc);
                    break;
                case CAMBIAR_CANTIDAD_JUGADORES:
                    cambiarJugadoresVideojuego(videojuegos, sc);
                    break;
                case VIDEOJUEGOS_NINTENDO:
                    verJuegosNintendo(videojuegos);
                    break;
                case SALIR:
                    mostrarMensajePorPantalla("Saliendo . . . ");
                    break;
                default:
                    mostrarMensajePorPantalla("Opción Inválida. Intente de nuevo.");
            }
        } while (opcion != SALIR);

        mostrarMensajePorPantalla("Gracias por utilizar el programa");
        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n------ Menú ------");
        System.out.println("1. Agregar Videojuego");
        System.out.println("2. Ver Videojuegos");
        System.out.println("3. Cambiar Nombre de Videojuego");
        System.out.println("4. Cambiar Cantidad de Jugadores");
        System.out.println("5. Ver Videojuegos de Nintendo");
        System.out.println("6. Salir");
        System.out.println("-------------------");
        System.out.print("Ingrese la opción que desee realizar: ");
    }

    private static void agregarVideojuego(List<Videojuego> lista, Scanner sc) {
        try {
            System.out.println("\n------ Agregar Videojuego ------");
            System.out.print("Ingrese el código del videojuego: ");
            int codigo = sc.nextInt();
            sc.nextLine();  // Consumir el salto de línea

            System.out.print("Ingrese el título del videojuego: ");
            String titulo = sc.nextLine();

            System.out.print("Ingrese la consola del videojuego: ");
            String consola = sc.nextLine();

            System.out.print("Ingrese la cantidad de jugadores del videojuego: ");
            int cantidadJugadores = sc.nextInt();
            sc.nextLine();  // Consumir el salto de línea

            System.out.print("Ingrese la categoría del videojuego: ");
            String categoria = sc.nextLine();

            Videojuego videojuego = new Videojuego(codigo, titulo, consola, cantidadJugadores, categoria);
            lista.add(videojuego);
            System.out.println("Videojuego agregado:\n" + videojuego.toString());
        } catch (Exception e) {
            System.out.println("Error al ingresar datos. Asegúrate de ingresar datos válidos.");
            sc.nextLine();  // Limpiar el buffer del scanner
        }
    }

    private static void listaVideojuegos(List<Videojuego> videojuegos) {
        if (videojuegos.isEmpty()) {
            System.out.println("\nNo hay videojuegos en la lista.");
        } else {
            System.out.println("\n------ Lista de Videojuegos ------");
            for (Videojuego vj : videojuegos) {
                System.out.println("--------------------------------------------------");
                System.out.println("Código: " + vj.getCodigo());
                System.out.println("Título: " + vj.getTitulo());
                System.out.println("Consola: " + vj.getConsola());
                System.out.println("Cantidad de Jugadores: " + vj.getCantidadJugadores());
                System.out.println("Categoría: " + vj.getCategoria());
            }
            System.out.println("--------------------------------------------------");
        }
    }

    private static void cambiarNombreVideojuego(List<Videojuego> videojuegos, Scanner sc) {
        if (videojuegos.isEmpty()) {
            System.out.println("\nNo hay videojuegos en la lista.");
        } else {
            try {
                System.out.println("\n------ Cambiar Nombre de Videojuego ------");
                System.out.print("Ingrese el código del videojuego cuyo nombre desea cambiar: ");
                listaVideojuegosPorCodigo(videojuegos);
                int codigo = sc.nextInt();
                sc.nextLine();  // Consumir el salto de línea

                Videojuego videojuego = buscarVideojuegoPorCodigo(videojuegos, codigo);

                if (videojuego != null) {
                    System.out.print("Ingrese el nuevo nombre del videojuego: ");
                    String nuevoNombre = sc.nextLine();
                    videojuego.setTitulo(nuevoNombre);
                    System.out.println("Nombre del videojuego cambiado correctamente.");
                } else {
                    System.out.println("No se encontró un videojuego con el código proporcionado.");
                }
            } catch (Exception e) {
                System.out.println("Error al ingresar datos. Asegúrate de ingresar datos válidos.");
                sc.nextLine();  // Limpiar el buffer del scanner
            }
        }
    }

    private static void cambiarJugadoresVideojuego(List<Videojuego> videojuegos, Scanner sc) {
        if (videojuegos.isEmpty()) {
            System.out.println("\nNo hay videojuegos en la lista.");
        } else {
            try {
                System.out.println("\n------ Cambiar Cantidad de Jugadores ------");
                System.out.print("Ingrese el código del videojuego cuya cantidad de jugadores desea cambiar: ");
                listaVideojuegosPorCodigo(videojuegos);
                int codigo = sc.nextInt();
                sc.nextLine();  // Consumir el salto de línea

                Videojuego videojuego = buscarVideojuegoPorCodigo(videojuegos, codigo);

                if (videojuego != null) {
                    System.out.print("Ingrese la nueva cantidad de jugadores del videojuego: ");
                    int nuevaCantidadJugadores = sc.nextInt();
                    videojuego.setCantidadJugadores(nuevaCantidadJugadores);
                    System.out.println("Cantidad de jugadores del videojuego cambiada correctamente.");
                } else {
                    System.out.println("No se encontró un videojuego con el código proporcionado.");
                }
            } catch (Exception e) {
                System.out.println("Error al ingresar datos. Asegúrate de ingresar datos válidos.");
                sc.nextLine();  // Limpiar el buffer del scanner
            }
        }
    }

    private static void verJuegosNintendo(List<Videojuego> videojuegos) {
        if (videojuegos.isEmpty()) {
            System.out.println("\nNo hay videojuegos de Nintendo cargados.");
        } else {
            System.out.println("\n------ Videojuegos de Nintendo ------");
            for (Videojuego vj : videojuegos) {
                if ("Nintendo".equalsIgnoreCase(vj.getConsola())) {
                    System.out.println("--------------------------------------------------");
                    System.out.println("Código: " + vj.getCodigo());
                    System.out.println("Título: " + vj.getTitulo());
                    System.out.println("Cantidad de Jugadores: " + vj.getCantidadJugadores());
                }
            }
            System.out.println("-------------------------------------");
        }
    }

    private static Videojuego buscarVideojuegoPorCodigo(List<Videojuego> videojuegos, int codigo) {
        for (Videojuego vj : videojuegos) {
            if (vj.getCodigo() == codigo) {
                return vj;
            }
        }
        return null;
    }

    private static void listaVideojuegosPorCodigo(List<Videojuego> videojuegos) {
        if (videojuegos.isEmpty()) {
            System.out.println("\nNo hay videojuegos en la lista.");
        } else {
            System.out.println("\n------ Lista de Videojuegos ------");
            for (Videojuego vj : videojuegos) {
                System.out.println("Nombre: " + vj.getTitulo() + "    Codigo: " + vj.getCodigo());
            }
            System.out.println("----------------------------------");
        }
    }

    private static void mostrarMensajePorPantalla(String mensaje) {
        System.out.println(mensaje);
    }
}