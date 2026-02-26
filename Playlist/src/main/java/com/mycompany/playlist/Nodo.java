/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.playlist;

/**
 *
 * @author Usuario
 */

//lógica de los nodos según vimos en clase
public class Nodo{
    String cancion;
    Nodo siguiente;
    
    public Nodo(String cancion){
        this.cancion = cancion;
        this.siguiente = null;
    }
}
