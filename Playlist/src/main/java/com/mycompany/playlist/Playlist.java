/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.playlist;

/**
 *
 * @author Usuario
 */
import java.util.Scanner;

public class Playlist {
    
    public static void limpiarPantalla() {
        // Imprime 5 líneas vacías para y que "limpiar la terminal" (solo se ve un poquito mejor)
        //gemini resolvió porq en netbeans no hay manera de limpiar la terminal
        for (int i = 0; i < 5; i++) {
            System.out.println();
        }
    }
    
    public static void main (String[] args) {
        
        Lista playlist = new Lista();
        Pila historial = new Pila();
         
        Scanner escaner = new Scanner(System.in);
        boolean salir = false;
        int opcionEscogida;
        
        //ciclo while del menú
        while (!salir) {
            System.out.println("¡Bienvenido al súper reproductor unimarista!");
            System.out.println("Selecciona una de las siguientes opciones:");
            System.out.println("1. Agregar canción al final de la playlist");
            System.out.println("2. Agregar una canción a continuación");
            System.out.println("3. Reproducir la playlist");
            System.out.println("4. Ver canciones en cola");
            System.out.println("5. Ver historial de canciones");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            try {
                String entrada = escaner.nextLine();
                opcionEscogida = Integer.parseInt(entrada);

                switch (opcionEscogida) {
                    case 1:
                        //agregar al final de la playlist
                        System.out.print("Nombre de la canción: ");
                        String nombreFinal = escaner.nextLine();
                        playlist.AgregarCancionFinal(new Nodo(nombreFinal));
                        limpiarPantalla();
                        break;

                    case 2:
                    //insertar la siguiente canción
                        System.out.print("Nombre de la canción: ");
                        String nombreSiguiente = escaner.nextLine();
                        playlist.ReproducirAContinuacion(new Nodo(nombreSiguiente));
                        limpiarPantalla();
                        break;

                    case 3:
                    //reproducir la playlist con un control integrado
                        if (playlist.cabeza == null) {
                            System.out.println("No hay canciones para reproducir. Agrega alguna :)");}
                        else 
                        {
                            boolean reproductor = true;
        
                            while (reproductor && playlist.cabeza != null)
                            {
                                limpiarPantalla();
                                System.out.println("++++ REPRODUCTOR UNIMARISTA ++++");
                                System.out.println("SONANDO AHORA");
                                //usamos el método que está en la clase lista para mostrar la canción
                                playlist.MostrarCancionActual(); 
                                System.out.println("\n---------------------------");
                                System.out.println("Controles del reproductor:");
                                System.out.println("[1] Siguiente canción");
                                System.out.println("[2] Anterior canción");
                                System.out.println("[3] Regresar al menú principal");
                                System.out.println("---------------------------");
                                System.out.print("\n¿Qué deseas hacer, unimarista?: ");
                                
                                String elegido = escaner.nextLine();
                                int accion = Integer.parseInt(elegido);

                                switch (accion)
                                {
                                    case 1:
                                        playlist.ReproducirSiguiente(historial);
                                        //pausa para continuar
                                        System.out.println("Presiona Enter para continuar");
                                        escaner.nextLine(); 
                                        break;

                                    case 2:
                                        playlist.ReproducirAnterior(historial);
                                        System.out.println("Presiona Enter para continuar");
                                        escaner.nextLine();
                                        break;

                                    case 3:
                                        System.out.println("Saliendo del reproductor :)");
                                        reproductor = false;
                                        break;

                                    default:
                                        System.out.println("Opción no válida.");
                                }
                            }
                        }
                        limpiarPantalla();
                        break;

                    case 4:
                        //mostrar las canciones que quedan en cola
                        playlist.MostrarListaDeReproduccion();
                        limpiarPantalla();
                        break;

                    case 5:
                        //mostrar el historial de canciones escuchadas
                        historial.MostrarHistorial();
                        limpiarPantalla();
                        break;

                    case 6:
                        //salir del programa
                        salir = true;
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
                
            //por si no es un número válido
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingresa un número válido.");
            //por si hay algun otro error
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
        escaner.close();
    }
}