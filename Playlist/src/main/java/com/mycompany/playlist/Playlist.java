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
            System.out.println("4. Reproducir la canción anterior");
            System.out.println("5. Ver canciones en cola");
            System.out.println("6. Ver historial de canciones");
            System.out.println("7. Salir");
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
                    //reproducir la playlist
                        if (playlist.cabeza == null) {
                            System.out.println("No hay canciones para reproducir.");
                        } else {
                            //se identifica la canción actual, que sería la cabeza de la lista
                            Nodo cancionActual = playlist.cabeza;
                            
                            System.out.println("Reproduciendo: " + cancionActual.cancion + " en el reproductor unimarista");
                            System.out.println("La canción finalizó");

                            //se avanza a la siguiente canción una vez finalizada la canción
                            playlist.cabeza = playlist.cabeza.siguiente;
                            
                            //si no hay canciones, dejar vacía la cola
                            if (playlist.cabeza == null) {
                                playlist.cola = null;
                            }

                            //para que el nodo no apunte a nada antes de moverlo
                            cancionActual.siguiente = null; 

                            //lo movemos a la pila del historial
                            historial.Apilar(cancionActual);
                        }
                        limpiarPantalla();
                        break;

                    case 4:
                        //reproducir la canción anterior
                        
                        //recupero la canción que recién se movió al historial
                        Nodo cancionRecuperada = historial.Desapilar();
                        
                        if (cancionRecuperada != null) {
                            //se coloca la canción en la playlist para que sea la siguiente en reproducirse
                            playlist.AgregarCancionComienzo(cancionRecuperada);
                            System.out.println("Regresaste a la canción: " + cancionRecuperada.cancion);
                        }
                        limpiarPantalla();
                        break;

                    case 5:
                        //mostrar las canciones que quedan en cola
                        playlist.MostrarListaDeReproduccion();
                        limpiarPantalla();
                        break;

                    case 6:
                        //mostrar el historial de canciones escuchadas
                        historial.MostrarHistorial();
                        limpiarPantalla();
                        break;

                    case 7:
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