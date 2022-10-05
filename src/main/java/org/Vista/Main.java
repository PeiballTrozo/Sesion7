package org.Vista;

import org.Controlador.Controlador;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Controlador controlador= new Controlador();
        controlador.insertArticulo("nombre",10,"texto", "autor");
    }
}