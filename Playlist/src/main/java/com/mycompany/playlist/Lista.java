package com.mycompany.playlist;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Lista {
    public Nodo cabeza;
    public Nodo cola;
    
    public Lista (){
        this.cabeza = null;
        this.cola = null;
    }
    
    //agregar canción al comienzo
    public void AgregarCancionComienzo(Nodo cancion)
    {
        if(this.cabeza == null){
            this.cabeza = cancion;
            this.cola = cancion;
            return;
        }
        else{
            cancion.siguiente = this.cabeza;
            this.cabeza = cancion;
        }
    }
    
    //agregar canción al final
    public void AgregarCancionFinal(Nodo cancion)
    {
        if(this.cabeza == null){
            this.cabeza = cancion;
            this.cola = cancion;
            return;
        }
        else{
            Nodo colaActual = this.cola;
            colaActual.siguiente = cancion;
            this.cola = cancion;
        }
        System.out.println("Añadida la canción " + cancion.cancion +" al final de la lista");
    }
    
    //añadir canción siguiente
    public void AgregarCancionSiguiente(Nodo cancion)
    {
        if(this.cabeza == null ){
            this.cabeza = cancion;
            this.cola = cancion;            
            return;
        }
        else {
          cancion.siguiente = this.cabeza.siguiente;
          this.cabeza.siguiente = cancion;
          if (this.cola == this.cabeza){
              this.cola = cancion;
          }
        }
        System.out.println("Añadida la canción " + cancion.cancion +" después de la canción actual");
    }
    
    //reproducir la siguiente canción (si es que hay)
    public void ReproducirSiguiente(Pila historial){
        Nodo cancionSiguiente = this.cabeza.siguiente;
        if (this.cabeza == null){
            System.out.println("Error, no hay canciones en la lista de reproducción");
        return;
        }
        historial.Apilar(this.cabeza);
        this.cabeza = cancionSiguiente;
        System.out.println("Se acabó la canción.");
            
        if (this.cabeza == null){
        this.cola = null;
        System.out.println("Se terminó la lista de reproducción actual.");
        }
    }
    
    //reproducir la canción anterior regresándola del historial
    public void ReproducirAnterior(Pila historial){
        {
        Nodo cancionAnterior = historial.Desapilar();
        if (cancionAnterior != null ) {
            this.AgregarCancionComienzo(cancionAnterior);
            System.out.println("Regresaste a la canción: " + cancionAnterior.cancion);}
        else{
            System.out.println("No hay canciones anteriores en el historial.");}
        }
    }
    
    //mostrar la canción actual en el reproductor
    public void MostrarCancionActual(){
        if (cabeza == null){
            System.out.println("Error, la lista de reproducción esta vacía");
        }
        else {
            System.out.println("La canción actual es: "+ this.cabeza.cancion);
        }
    }
    
    //mostrar la lista de canciones en cola
    public void MostrarListaDeReproduccion(){
        if(this.cabeza == null ){
            System.out.println("No hay canciones en cola");
        }
        else {
            int contador = 0;
            System.out.println("Lista de reproducción");
            Nodo actual = this.cabeza;
            while (actual != null){
                contador += 1;
                System.out.println(contador +". " + actual.cancion );
                actual = actual.siguiente;
            }
        }
    }
}
