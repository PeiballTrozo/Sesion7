package org.Controlador;

import org.Modelo.Articulo;

import java.util.ArrayList;

public interface ConexionBBDD
{
    ArrayList<Articulo> getAllArticulo();
    boolean insertArticulo(String nombre, int numPaginas, String texto, String autor);
    boolean deleteArticulo(int id);
    boolean updateArticulo(int id,String nombre, int numPaginas, String texto, String autor );
}
