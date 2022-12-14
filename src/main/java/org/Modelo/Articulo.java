package org.Modelo;

/**
 * Mi base de datos:
 * CREATE TABLE `articulo` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `nombre` varchar(50) NOT NULL,
 *   `numPaginas` int(11) DEFAULT NULL,
 *   `texto` varchar(255) DEFAULT NULL,
 *   `autor` varchar(50) DEFAULT NULL,
 *   PRIMARY KEY (`id`)
 * )
 */
public class Articulo {
    private String nombre;
    private int numPaginas;
    private String texto;
    private String autor;


    public Articulo(String nombre, int numPaginas, String texto, String autor) {
        this.nombre = nombre;
        this.numPaginas = numPaginas;
        this.texto = texto;
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
