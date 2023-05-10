package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//import com.sun.corba.se.impl.encoding.CDRInputObject;
import modelo.Cita_Disp;

public class Cita_DispDAO{
    public static final String selectSQL = "SELECT * FROM Cita_Disp";
    public static final String insertSQL = "INSERT INTO Cita_Disp(F_Disponible, Horario) VALUES (?,?)";
    public static final  String updateSQL = "UPDATE Cita_Disp SET F_Disponible = ?, Horario = ? WHERE Codigo = ? ";
    public static final String deleteSQL = "DELETE FROM Cita_Disp WHERE Codigo = ? ";
    

    public List<Cita_Disp> listar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        Cita_Disp CitDis = null;

        List<Cita_Disp> CitasDis = new ArrayList<>();
        try{
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);

            while(result.next()){
                int Codigo = result.getInt("Codigo");
                Date F_Disponible = result.getDate("F_Disponible");
                String Horario = result.getString("Horario");

                CitDis = new Cita_Disp(Codigo, F_Disponible, Horario);
                CitasDis.add(CitDis);
            }

            Conexion.close(result);
            Conexion.close((ResultSet) state);
            Conexion.close(conn);

            
            for(Cita_Disp cita_disp: CitasDis){
                System.out.println("Código: " + cita_disp.getCodigo());
                System.out.println("F_Disponible: " + cita_disp.getF_Disponible());
                System.out.println("Horario: " + cita_disp.getHorario());
                System.out.println(" \n ");
            }

        }catch (Exception e) {
            e.printStackTrace();
        } 
        return CitasDis;
    }

    public int insertar(Cita_Disp cita_disp){

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;

        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(insertSQL);
            
            state.setDate(1,(Date)cita_disp.getF_Disponible());
            state.setString(2,cita_disp.getHorario());

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Cita disponible agregada correctamente");

            Conexion.close(state);
            Conexion.close(conn);

            Cita_Disp cita_dispNvo = new Cita_Disp();

        }catch (Exception e) {
            e.printStackTrace();
        }

        return registros;
    }

    public int modificar(Cita_Disp cita_disp){

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;


        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(updateSQL);

            state.setDate(1,(Date)cita_disp.getF_Disponible());
            state.setString(2,cita_disp.getHorario());
            state.setInt(3,cita_disp.getCodigo());

            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Cita disponible actualizada");


            Conexion.close(state);
            Conexion.close(conn);
            Cita_Disp cita_dispMod = new Cita_Disp();

        }catch (Exception e) {
            e.printStackTrace();
        }
        return registros;
    }

    public int borrar(Cita_Disp cita_disp){

        Connection conn = null;
        PreparedStatement state = null;
        int registros=0;

        try{
            conn = Conexion.getConnection();
            state = conn.prepareStatement(deleteSQL);

            state.setInt(1,cita_disp.getCodigo());
            registros = state.executeUpdate();

            if(registros>0)
                System.out.println("Cita disponible eliminado");


            Conexion.close(state);
            Conexion.close(conn);
            Cita_Disp cita_dispBor = new Cita_Disp();

        }catch (Exception e) {
            e.printStackTrace();
        }

        return registros;
    }
}