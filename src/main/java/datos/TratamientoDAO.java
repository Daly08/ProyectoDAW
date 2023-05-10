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
                int Precio = result.getInt("Precio");
                int Cod_Manicurista = result.getInt("Cod_Manicurista");
                
                Trat = new Tratamiento(Codigo, Nombre, Precio, Cod_Manicurista);
                Tratamientos.add(Trat);
            }

            Conexion.close(result);
            Conexion.close((ResultSet) state);
            Conexion.close(conn);

            for(Tratamiento tratamientos: Tratamientos){
                System.out.println("Código: " + tratamientos.getCodigo());
                System.out.println("Nombre: " + tratamientos.getNombre());
                System.out.println("Precio: " + tratamientos.getPrecio());
                System.out.println("Cod_Manicurista: " + tratamientos.getCod_Manicurista());
                System.out.println(" \n ");
            }

        }catch (Exception e) {
            e.printStackTrace(System.out);
        } 
        return Tratamientos;
    }

    public int insertar(Tratamiento tratamientos){

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;

        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(insertSQL);

            state.setString(1,tratamientos.getNombre());
            state.setInt(2,tratamientos.getPrecio());
            state.setInt(3,tratamientos.getCod_Manicurista());

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Registtro agregado correctamente");

            Conexion.close(state);
            Conexion.close(conn);

            Tratamiento tratamientosNvo = new Tratamiento();

        }catch (Exception e) {
            e.printStackTrace();
        }
        return registros;
    }

    public int modificar(Tratamiento tratamientos){

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;


        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(updateSQL);

            state.setString(1,tratamientos.getNombre());
            state.setInt(2,tratamientos.getPrecio());
            state.setInt(3,tratamientos.getCod_Manicurista());
            state.setInt(4,tratamientos.getCodigo());

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Registro actualizado");


            Conexion.close(state);
            Conexion.close(conn);
           Tratamiento TratamientosMod = new Tratamiento();

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    public int borrar(Tratamiento tratamientos){

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
            Tratamiento tratamientosBor = new Tratamiento();

        }catch (Exception e) {
            e.printStackTrace();
        }
        return registros;
    }
}