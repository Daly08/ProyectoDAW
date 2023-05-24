package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Cita;

public class CitaDAO{
    public static final String selectSQL = "SELECT * FROM Cita";
    public static final String insertSQL = "INSERT INTO Cita(Fecha, Horario, Cod_Cliente, Cod_Tratamiento) VALUES (?,?,?,?)";
    public static final  String updateSQL = "UPDATE Cita_Disp SET Fecha = ?, Horario = ?, Cod_Cliente = ?, Cod_Tratamiento = ? WHERE Codigo = ? ";
    public static final String deleteSQL = "DELETE FROM Cita WHERE Codigo = ? ";

    public List<Cita> listar() throws SQLException{
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        Cita Cit = null;

        List<Cita> Citas = new ArrayList<>();
        try{
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);

            while(result.next()){
                int Codigo = result.getInt("Codigo");
                String Fecha = result.getString("Fecha");
                String Horario = result.getString("Horario");
                String Cod_Cliente = result.getString("Cod_Cliente");
                String Cod_Tratamiento = result.getString("Cod_Tratamiento");
                String Cod_Promocion = result.getString("Cod_Promocion");
                Cit = new Cita(Codigo, Fecha, Horario, Cod_Cliente, Cod_Tratamiento, Cod_Promocion);
                Citas.add(Cit);
            }

            Conexion.close(result);
            Conexion.close((ResultSet) state);
            Conexion.close(conn);

            for(Cita citas: Citas){
                System.out.println("Codigo: " + citas.getCodigo());
                System.out.println("Fecha: " + citas.getFecha());
                System.out.println("Horario: " + citas.getHorario());
                System.out.println("Cod_Cliente: " + citas.getCod_Cliente());
                System.out.println("Cod_Tratamiento: " + citas.getCod_Tratamiento());
                System.out.println("Cod_Promocion: " + citas.getCod_Promocion());
                System.out.println(" \n ");
            }

        }catch (Exception e) {
            e.printStackTrace(System.out);
        } 
        return Citas;
    }

    public void insertar(Cita cita) throws SQLDataException{

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;

        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(insertSQL);
            
            state.setString(1, cita.getFecha());
            state.setString(2,cita.getHorario());
            state.setString(3,cita.getCod_Cliente());
            state.setString(4,cita.getCod_Tratamiento());
            state.setString(5,cita.getCod_Promocion());

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Cita agregada correctamente");

            Conexion.close(state);
            Conexion.close(conn);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificarFecha(int Codigo, String Fecha) throws SQLDataException{

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;


        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(updateSQL);

            state.setString(1,Fecha);
            state.setInt(2,Codigo);

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Cita actualizada");


            Conexion.close(state);
            Conexion.close(conn);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificarHorario(int Codigo, String Horario) throws SQLDataException{

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;


        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(updateSQL);

            state.setString(1,Horario);
            state.setInt(2,Codigo);

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Cita actualizada");


            Conexion.close(state);
            Conexion.close(conn);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificarCod_Cliente(int Codigo, String Cod_Cliente) throws SQLDataException{

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;


        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(updateSQL);

            state.setString(1,Cod_Cliente);
            state.setInt(2,Codigo);

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Cita actualizada");


            Conexion.close(state);
            Conexion.close(conn);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificarCod_Tratamiento(int Codigo, String Cod_Tratamiento) throws SQLDataException{

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;


        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(updateSQL);

            state.setString(1,Cod_Tratamiento);
            state.setInt(2,Codigo);

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Cita actualizada");


            Conexion.close(state);
            Conexion.close(conn);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificarCod_Promocion(int Codigo, String Cod_Promocion) throws SQLDataException{

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;


        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(updateSQL);

            state.setString(1,Cod_Promocion);
            state.setInt(2,Codigo);

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Cita actualizada");


            Conexion.close(state);
            Conexion.close(conn);

        }catch (Exception e) {
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
                System.out.println("Cita eliminado");


            Conexion.close(state);
            Conexion.close(conn);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}