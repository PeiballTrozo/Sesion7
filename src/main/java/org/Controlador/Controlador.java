package org.Controlador;

import org.Modelo.Articulo;

import java.sql.*;
import java.util.ArrayList;

public class Controlador implements ConexionBBDD{
    private static String bd = "prueba";
    private static String login = "root";
    private static String password = "";
    private static String host = "127.0.0.1"; //localhost

    private static String url = "jdbc:mysql://";
    private static Connection conexion;
    @Override
    public ArrayList<Articulo> getAllArticulo() {
        ArrayList<Articulo> listaArticulo= new ArrayList<>();
        conexion=getConexion();
        try{
            if(conexion!=null){
                PreparedStatement pr= conexion.prepareStatement("select * from articulo");
                ResultSet rs= pr.executeQuery();

                while(rs.next()){
                    String nombre= rs.getString("nombre");
                    int numPaginas= rs.getInt("numPaginas");
                    String texto= rs.getString("texto");
                    String autor= rs.getString("autor");

                    listaArticulo.add(new Articulo(nombre,numPaginas,texto,autor));
                }
                pr.close();
                rs.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  listaArticulo;

    }



    @Override
    public boolean insertArticulo(String nombre, int numPaginas, String texto, String autor) {
        conexion= getConexion();
        try{
            if(conexion!=null){
                PreparedStatement pr= conexion.prepareStatement("insert into articulo (nombre, numPaginas, texto,autor) values(?,?,?,?)");
                pr.setString(1, nombre);
                pr.setInt(2, numPaginas);
                pr.setString(3, texto);
                pr.setString(4, autor);
                pr.executeUpdate();
                conexion.commit();
                pr.close();
            }
        } catch (SQLException e) {
            cerrarConexion();
            return false;
        }
        return true;

    }

    @Override
    public boolean deleteArticulo(int id) {
        conexion= getConexion();
        try{
            if(conexion!=null){
                PreparedStatement pr= conexion.prepareStatement("delete from articulo where id=?");
                pr.setInt(1,id);
                pr.executeUpdate();
                conexion.commit();
                pr.close();
            }
        } catch (SQLException e) {
            cerrarConexion();
            return false;
        }
        return true;
    }

    private Connection getConexion() {
        if(conexion==null){
            crearConexion();
        }
        return conexion;
    }

    public static void crearConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url + host + "/"+ bd, login, password);
            conexion.setAutoCommit(false);

        } catch (SQLException e) {
            System.out.println(e);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public void cerrarConexion(){
        try {
            conexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
