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

    public List<Cita> listar(){
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
                Date Fecha = result.getDate("Fecha");
                Time Horario = result.getTime("Horario");
                int Cod_Cliente = result.getInt("Cod_Cliente");
                int Cod_Tratamiento = result.getInt("Cod_Tratamiento");
                Cit = new Cita(Codigo, Fecha, Horario, Cod_Cliente, Cod_Tratamiento);
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
                System.out.println(" \n ");
            }

        }catch (Exception e) {
            e.printStackTrace(System.out);
        } 
        return Citas;
    }

    public int insertar(Cita citas){

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;

        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(insertSQL);
            
            state.setDate(1,(Date)citas.getFecha());
            state.setTime(2,citas.getHorario());
            state.setInt(3,citas.getCod_Cliente());
            state.setInt(4,citas.getCod_Tratamiento());

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Cita agregada correctamente");

            Conexion.close(state);
            Conexion.close(conn);

            Cita citasNvo = new Cita();

        }catch (Exception e) {
            e.printStackTrace();
        }

        return registros;
    }

    public int modificar(Cita citas){

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;


        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(updateSQL);

            state.setDate(1,(Date)citas.getFecha());
            state.setTime(2,citas.getHorario());
            state.setInt(3,citas.getCod_Cliente());
            state.setInt(4,citas.getCod_Tratamiento());
            state.setInt(5,citas.getCodigo());

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Cita actualizada");


            Conexion.close(state);
            Conexion.close(conn);
            Cita citasMod = new Cita();

        }catch (Exception e) {
            e.printStackTrace();
        }
        return registros;
    }

    public int borrar(Cita citas){

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;

        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(deleteSQL);

            state.setInt(1,citas.getCodigo());

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Cita eliminado");


            Conexion.close(state);
            Conexion.close(conn);
            Cita citasBor = new Cita();

        }catch (Exception e) {
            e.printStackTrace();
        }

        return registros;
    }
}