package datos;

import modelo.Empleado;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.concurrent.ExecutionException;

public class EmpleadoDAO {
    public static final String selectSQL = "SELECT * FROM Empleado";
    public static final String insertSQL = "INSERT INTO Empleado(Nombre, Cargo, Telefono) VALUES (?,?,?)";
    public static final String updateSQL = "UPDATE Empleado SET Nombre = ?, Cargo = ?, Telefono = ?";
    public static final String deleteSQL = "DELETE FROM Empleado WHERE Codigo = ?";

    //Muestra los clientes

    public List<Empleado> seleccionar() throws SQLException{
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        Empleado emp = null;

        List<Empleado> Empleado = new ArrayList<>();
        try{
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);

            while(result.next()){
                int Codigo = result.getInt("Codigo");
                String Nombre = result.getString("Nombre");
                String Cargo = result.getString("Cargo");
                String Telefono = result.getString("Telefono");

                emp = new Empleado(Codigo, Nombre, Cargo, Telefono);
                Empleado.add(emp);
            }
            Conexion.close(result);
            Conexion.close(state);
            Conexion.close(conn);

            for(Empleado empleado: Empleado){
                System.out.println("Codigo: "+ empleado.getCodigo());
                System.out.println("Nombre: "+ empleado.getNombre());
                System.out.println("Cargo: "+ empleado.getCargo());
                System.out.print("Telefono: "+ empleado.getTelefono());
                System.out.println(" \n ");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Empleado;
    }

    public void insertar(Empleado empleado) throws SQLException{
        Connection conn = null;
        PreparedStatement state = null;
        int registros = 0;

        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(insertSQL);

            state.setString(1, empleado.getNombre());
            state.setString(2, empleado.getCargo());
            state.setString(3, empleado.getTelefono());

            registros = state.executeUpdate();
            if(registros>0)
                System.out.println("Registro agregado correctamente");

            Conexion.close(state);
            Conexion.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void modificarNom(int Codigo, String Nombre) throws SQLException{
        Connection conn = null;
        PreparedStatement state = null;
        int registros = 0;

        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(updateSQL);

            state.setString(1, Nombre);
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

    public void modificarCar(int Codigo, String Cargo) throws SQLException{
        Connection conn = null;
        PreparedStatement state = null;
        int registros = 0;

        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(updateSQL);

            state.setString(1, Cargo);
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

    public void modificarTel(int Codigo, String Telefono) throws SQLException{
        Connection conn = null;
        PreparedStatement state = null;
        int registros = 0;

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

    public void borrar(int Codigo) throws SQLException{
        Connection conn = null;
        PreparedStatement state = null;
        int registros = 0;

        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(deleteSQL);

            state.setInt(1, Codigo);

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Registro eliminado");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
