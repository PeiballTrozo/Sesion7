package org.Vista;

import org.Controlador.Controlador;
import org.Modelo.Articulo;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner sc;
    private static Controlador controlador;
    public static void main(String[] args) {
        controlador= new Controlador();

        System.out.println("\t\tBienvenido");
        sc = new Scanner(System.in);

        while (true) {
            System.out.println("\tSeleccione el trabajo a realizar");
            System.out.println("1.- Insertar articulo");
            System.out.println("2.- Borrar articulo");
            System.out.println("3.- Mostrar lista de articulos");
            System.out.println("0.- Salir");

            switch (sc.nextInt()) {
                case 0:
                    Salir();
                    break;
                case 1:
                    ObtenerArticuloFromUsuario();
                    break;
                case 2:
                    EliminarArticulo();
                    break;
                case 3:
                    MostrarListaArticulos();
                    break;
                default:
                    System.out.println("La opcion seleccionada no existe");
                    break;
            }
        }

    }

    private static void EliminarArticulo() {
        System.out.println("\tIntroduzca el nombre del articulo");
        controlador.deleteArticulo(sc.nextInt());
        sc.nextLine();
    }

    private static void Salir() {
        System.out.println("Hasta Luego");
        controlador.cerrarConexion();
        System.exit(0);
    }

    private static void ObtenerArticuloFromUsuario() {
        sc.nextLine();
        System.out.println("\tIntroduzca el nombre del articulo");
        String nombre=sc.nextLine();
        System.out.println("\tIntroduzca el numero de paginas");
        int numero= sc.nextInt();
        sc.nextLine();
        System.out.println("\tIntroduzca el texto del articulo");
        String texto=sc.nextLine();
        System.out.println("\tIntroduzca el autor del articulo");
        String autor=sc.nextLine();
        if(controlador.insertArticulo(nombre, numero,texto,autor)){
            System.out.println("El articulo ha sido introducido en la base de datos con exito");
        }else{
            System.out.println("El articulo no se ha introducido");
        }
    }
    private static void MostrarListaArticulos() {
        ArrayList<Articulo> arrArt = controlador.getAllArticulo();
        if(arrArt.size()==0){
            System.out.println("La tabla articulo esta vacia");
        }else{
            System.out.println("La tabla contiene:");

            for (int i=0;i<arrArt.size();i++) {
                Articulo aux= arrArt.get(i);
                System.out.println((i+1)+": | "+ aux.getNombre()+" | "+ aux.getNumPaginas()+" | "+ aux.getTexto()+ " | "+aux.getAutor()+" | ");
            }
        }
    }

}