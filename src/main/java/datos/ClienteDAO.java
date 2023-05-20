package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;

public class ClienteDAO{
    public static final String selectSQL = "SELECT * FROM Cliente";
    public static final String insertSQL = "INSERT INTO Cliente(Nombre, Telefono) VALUES (?,?)";
    public static final  String updateSQL = "UPDATE Cliente SET Nombre = ?, Telefono = ? WHERE Codigo = ? ";
    public static final String deleteSQL = "DELETE FROM Cliente WHERE Codigo = ? ";
    
    //Muestra los clientes
    public List<Cliente> seleccionar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        Cliente Cli = null;

        List<Cliente> Clientes = new ArrayList<>();
        try{
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);

            while(result.next()){
                int Codigo = result.getInt("Codigo");
                String Nombre = result.getString("Nombre");
                String Telefono = result.getString("Telefono");

                Cli = new Cliente(Codigo, Nombre, Telefono);
                Clientes.add(Cli);
            }

            Conexion.close(result);
            Conexion.close((ResultSet) state);
            Conexion.close(conn);

            for(Cliente clientes: Clientes){
                System.out.println("Código: " + clientes.getCodigo());
                System.out.println("Nombre: " + clientes.getNombre());
                System.out.println("Telefono: " + clientes.getTelefono());
                System.out.println(" \n ");
            }

        }catch (Exception e) {
            e.printStackTrace(System.out);
        } 
        return Clientes;
    }

    public void insertar(Cliente clientes){

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;

        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(insertSQL);

            state.setString(1,clientes.getNombre());
            state.setString(2,clientes.getTelefono());

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Registtro agregado correctamente");

            Conexion.close(state);
            Conexion.close(conn);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificarNom(int Codigo, String Nombre) throws SQLException{

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;


        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(updateSQL);

            state.setString(1, Nombre);
            state.setInt(3, Codigo);

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Registro actualizado");


            Conexion.close(state);
            Conexion.close(conn);

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarTel(int Codigo, String Telefono) throws SQLException{

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;


        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(updateSQL);

            state.setString(1, Telefono);
            state.setInt(2, Codigo);

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Registro actualizado");


            Conexion.close(state);
            Conexion.close(conn);

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void borrar(int Codigo) throws SQLDataException{

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;

        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(deleteSQL);

            state.setInt(1,Codigo);

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Registro eliminado");


            Conexion.close(state);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}