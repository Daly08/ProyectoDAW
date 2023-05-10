package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Manicurista;

public class ManicuristaDAO{
    public static final String selectSQL = "SELECT * FROM Manicurista";
    public static final String insertSQL = "INSERT INTO Manicurista(Nombre, Telefono) VALUES (?,?)";
    public static final  String updateSQL = "UPDATE Cliente SET Nombre = ?, Telefono = ? WHERE Codigo = ? ";
    public static final String deleteSQL = "DELETE FROM Manicurista WHERE Codigo = ? ";
    
    public List<Manicurista> listar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        Manicurista Mani = null;

        List<Manicurista> Manicuristas = new ArrayList<>();
        try{
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);

            while(result.next()){
                int Codigo = result.getInt("Codigo");
                String Nombre = result.getString("Nombre");
                String Telefono = result.getString("Telefono");
                Mani = new Manicurista(Codigo, Nombre, Telefono);
                Manicuristas.add(Mani);
            }

            Conexion.close(result);
            Conexion.close((ResultSet) state);
            Conexion.close(conn);

            for(Manicurista manicurista: Manicuristas){
                System.out.println("Código: " + manicurista.getCodigo());
                System.out.println("Nombre: " + manicurista.getNombre());
                System.out.println("Telefono: " + manicurista.getTelefono());
                System.out.println(" \n ");
            }

        }catch (Exception e) {
            e.printStackTrace(System.out);
        } 
        return Manicuristas;
    }

    public int insertar(Manicurista manicuristas){

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;

        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(insertSQL);

            state.setString(1,manicuristas.getNombre());
            state.setString(2,manicuristas.getTelefono());

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Registtro agregado correctamente");

            Conexion.close(state);
            Conexion.close(conn);

            Manicurista manicuristasNvo = new Manicurista();

        }catch (Exception e) {
            e.printStackTrace();
        }

        return registros;
    }

    public int modificar(Manicurista manicuristas){

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;


        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(updateSQL);

            state.setString(1,manicuristas.getNombre());
            state.setString(2,manicuristas.getTelefono());
            state.setInt(3,manicuristas.getCodigo());

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Registro actualizado");


            Conexion.close(state);
            Conexion.close(conn);
            Manicurista manicuristasMod = new Manicurista();

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    public int borrar(Manicurista manicuristas){

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;

        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(deleteSQL);

            state.setInt(1,manicuristas.getCodigo());

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Registro eliminado");


            Conexion.close(state);
            Conexion.close(conn);
            Manicurista manicuristasBor = new Manicurista();

        }catch (Exception e) {
            e.printStackTrace();
        }

        return registros;
    }
}