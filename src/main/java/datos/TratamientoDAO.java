package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Tratamiento;

public class TratamientoDAO{
    public static final String selectSQL = "SELECT * FROM Tratamiento";
    public static final String insertSQL = "INSERT INTO Tratamiento(Nombre, Precio, Cod_Manicurista) VALUES (?,?,?)";
    public static final  String updateSQL = "UPDATE Tratamiento SET Nombre = ?, Precio = ?, Cod_Manicurista = ? WHERE Codigo = ? ";
    public static final String deleteSQL = "DELETE FROM Tratamiento WHERE Codigo = ? ";

    public List<Tratamiento> listar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        Tratamiento Trat = null;

        List<Tratamiento> Tratamientos = new ArrayList<>();
        try{
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);

            while(result.next()){
                int Codigo = result.getInt("Codigo");
                String Nombre = result.getString("Nombre");
                Float Precio = result.getFloat("Precio");
                
                Trat = new Tratamiento(Codigo, Nombre, Precio);
                Tratamientos.add(Trat);
            }

            Conexion.close(result);
            Conexion.close((ResultSet) state);
            Conexion.close(conn);

            for(Tratamiento tratamientos: Tratamientos){
                System.out.println("Código: " + tratamientos.getCodigo());
                System.out.println("Nombre: " + tratamientos.getNombre());
                System.out.println("Precio: " + tratamientos.getPrecio());
                System.out.println(" \n ");
            }

        }catch (Exception e) {
            e.printStackTrace(System.out);
        } 
        return Tratamientos;
    }

    public void insertar(Tratamiento tratamiento){

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;

        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(insertSQL);

            state.setString(1,tratamiento.getNombre());
            state.setFloat(2,tratamiento.getPrecio());

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
            state.setFloat(2,Codigo);

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

    public void borrar(Tratamiento tratamientos){

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;

        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(deleteSQL);

            state.setInt(1,tratamientos.getCodigo());

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