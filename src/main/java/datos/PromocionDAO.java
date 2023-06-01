package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Promocion;

public class PromocionDAO{
    public static final String selectSQL = "SELECT * FROM Promocio";
    public static final String insertSQL = "INSERT INTO Promocion(Nombre, Precio, Vigencia) VALUES (?,?,?)";
    public static final  String updateSQL = "UPDATE Promocion SET Nombre = ?, Precio = ?, Vigencia = ? WHERE Codigo = ? ";
    public static final String deleteSQL = "DELETE FROM Tratamiento WHERE Codigo = ? ";

    public List<Promocion> listar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        Promocion Prom = null;

        List<Promocion> Promociones = new ArrayList<>();
        try{
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);

            while(result.next()){
                int Codigo = result.getInt("Codigo");
                String Nombre = result.getString("Nombre");
                Float Precio = result.getFloat("Precio");
                Boolean Vigencia = result.getBoolean("Vigencia");
                
                Prom = new Promocion(Codigo, Nombre, Precio, Vigencia);
                Promociones.add(Prom);
            }

            Conexion.close(result);
            Conexion.close((ResultSet) state);
            Conexion.close(conn);

            for(Promocion promociones: Promociones){
                System.out.println("Código: " + promociones.getCodigo());
                System.out.println("Nombre: " + promociones.getNombre());
                System.out.println("Precio: " + promociones.getPrecio());
                System.out.println("Vigencia: " + promociones.getVigencia());
                System.out.println(" \n ");
            }

        }catch (Exception e) {
            e.printStackTrace(System.out);
        } 
        return Promociones;
    }

    public void insertar(Promocion Promociones){

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;

        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(insertSQL);

            state.setString(1,Promociones.getNombre());
            state.setFloat(2,Promociones.getPrecio());
            state.setBoolean(3, Promociones.getVigencia());

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Registtro agregado correctamente");

            Conexion.close(state);
            Conexion.close(conn);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificarNombre(int Codigo, String Nombre){

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;


        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(updateSQL);

            state.setString(1,Nombre);
            state.setInt(2,Codigo);

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Registro actualizado");


            Conexion.close(state);
            Conexion.close(conn);

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarPrecio(int Codigo, Float Precio){

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;


        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(updateSQL);

            state.setFloat(1,Precio);
            state.setInt(2,Codigo);

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Registro actualizado");


            Conexion.close(state);
            Conexion.close(conn);

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarVig(int Codigo, Boolean Vigencia){

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;


        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(updateSQL);

            state.setBoolean(1,Vigencia);
            state.setInt(2,Codigo);

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Registro actualizado");


            Conexion.close(state);
            Conexion.close(conn);

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void borrar(Promocion Promociones){

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;

        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(deleteSQL);

            state.setInt(1,Promociones.getCodigo());

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Registro eliminado");


            Conexion.close(state);
            Conexion.close(conn);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
