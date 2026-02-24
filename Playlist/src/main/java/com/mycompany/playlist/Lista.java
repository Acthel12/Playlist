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
        System.out.println("Añadida la Cancion " + cancion.cancion +" al Comienzo de la lista");
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
        System.out.println("Añadida la Cancion " + cancion.cancion +" al Final de la lista");
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
        System.out.println("Añadida la Cancion " + cancion.cancion +" despues de la cancion actual");
    }
    public void ReproducirSiguiente(Pila historial){
        if (this.cabeza == null){
            System.out.println("Error, no hay canciones en la lista de reproduccion");
        }
        else {
            System.out.println("Se acabo la canción: " + this.cabeza.cancion);
            Nodo cancionSiguiente = this.cabeza.siguiente;
            if(cancionSiguiente != null){
                System.out.println("Reproduciendo la siguiente canción: " + cancionSiguiente.cancion);
            }
            historial.Apilar(this.cabeza);
            this.cabeza = cancionSiguiente;
            
            if (this.cabeza == null){
                this.cola = null;
                System.out.println("Se termino la lista de reproduccion actual.");
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
            System.out.println("Error, la lista de reproduccion esta vacia");
        }
        else {
            System.out.println("La cancion actual es: "+ this.cabeza.cancion);
        }
    }
    public void MostrarListaDeReproduccion(){
        if(this.cabeza == null ){
            System.out.println("Error, La Lista esta vacia");
        }
        else {
            int contador = 0;
            System.out.println("Lista De Reproduccion");
            Nodo actual = this.cabeza;
            while (actual != null){
                contador += 1;
                System.out.println(contador +". " + actual.cancion );
                actual = actual.siguiente;
            }
        }
    }
    public void EliminarCancion(String cancion){
        if (this.cabeza == null){
            System.out.println("Error la lista de reproduccion esta vacia ");
        }
        else if (this.cabeza.cancion.equals(cancion) ) {
            this.cabeza = this.cabeza.siguiente;
            System.out.println("Se elimino " + cancion + "al comienzo de la lista de reproducción");
            if (this.cabeza == null || this.cabeza.siguiente == null ){
                this.cola = this.cabeza;
            } 
        }
        else {
            Nodo actual = this.cabeza;
            
            while (actual.siguiente != null && !actual.siguiente.cancion.equals(cancion)){
                actual = actual.siguiente;
            }
            if (actual.siguiente != null){
                actual.siguiente  = actual.siguiente.siguiente;
                System.out.println("Se elimino la primera aparicion de " + cancion);
                if (actual.siguiente == null){
                    this.cola = actual;
                }
            }
            else{
                System.out.println("No se encontro la cancion a eliminar");
            }
            
        }
    }
}
