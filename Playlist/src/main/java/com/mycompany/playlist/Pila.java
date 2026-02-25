/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.playlist;

/**
 *
 * @author Usuario
 */
public class Pila {
        Nodo cabeza;
        
        public Pila (){
            this.cabeza = null;
        }
        
        public void Apilar(Nodo cancion){
            if (this.cabeza == null){
                this.cabeza = cancion;
            }
            else {
                cancion.siguiente = this.cabeza;
                this.cabeza = cancion;
            }
        }
        public Nodo Desapilar(){
            if (this.cabeza == null){
                System.out.println("Error: el historial esta vacío");
                return null;
            }
            else {
                Nodo actual = this.cabeza;
                this.cabeza = this.cabeza.siguiente;
                actual.siguiente = null;
                
                return actual;
            }
        }
        public void MostrarHistorial(){
            if (this.cabeza != null){
                System.out.println("Historial de canciones");
                int contador = 0;
                Nodo siguiente = this.cabeza;
                while ( siguiente != null){
                    contador += 1;
                    System.out.println(contador + ". " + siguiente.cancion);
                    siguiente = siguiente.siguiente;
                }
            }
            else {
                System.out.println("El historial esta vacío");
            }
        }
}
