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
    
    public void AgregarCancionComienzo(Nodo cancion){
        if(this.cabeza == null){
            this.cabeza = cancion;
            this.cola = cancion;
            return;
        }
        else{
            cancion.siguiente = this.cabeza;
            this.cabeza = cancion;
        }
        System.out.println("Añadida la canción " + cancion.cancion +" al comienzo de la lista");
    }
    
    public void AgregarCancionFinal(Nodo cancion){
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
    public void ReproducirAContinuacion(Nodo cancion){
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
    public void ReproducirSiguiente(Pila historial){
        if (this.cabeza == null){
            System.out.println("Error, no hay canciones en la lista de reproducción");
        }
        else {
            System.out.println("Se acabó la canción: " + this.cabeza.cancion);
            Nodo cancionSiguiente = this.cabeza.siguiente;
            if(cancionSiguiente != null){
                System.out.println("Reproduciendo la siguiente canción: " + cancionSiguiente.cancion);
            }
            historial.Apilar(this.cabeza);
            this.cabeza = cancionSiguiente;
            
            if (this.cabeza == null){
                this.cola = null;
                System.out.println("Se terminó la lista de reproducción actual.");
            }
        }
    }
    public void ReproducirAnterior(Pila historial){
        Nodo cancionAnterior = historial.Desapilar();
        if (cancionAnterior != null ) {
            this.AgregarCancionComienzo(cancionAnterior);
        }
    }
    
    public void MostrarCancionActual(){
        if (cabeza == null){
            System.out.println("Error, la lista de reproducción esta vacia");
        }
        else {
            System.out.println("La canción actual es: "+ this.cabeza.cancion);
        }
    }
    public void MostrarListaDeReproduccion(){
        if(this.cabeza == null ){
            System.out.println("Error, La lista está vacía");
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
