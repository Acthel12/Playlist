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
}
