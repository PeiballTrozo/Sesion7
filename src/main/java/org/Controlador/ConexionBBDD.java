package org.Controlador;

import org.Modelo.Articulo;

import java.util.ArrayList;

public interface ConexionBBDD
{
    ArrayList<Articulo> getAllArticulo();
    void insertArticulo(String nombre, int numPaginas, String texto, String autor);
}
