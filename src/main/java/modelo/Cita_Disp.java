package modelo;
import java.sql.*;
import java.io.Serializable;

public class Cita_Disp implements Serializable{
    private static final long serialVersionUID = 1L;
    private int Codigo;
    private Date F_Disponible;
    private String Horario;

    public Cita_Disp(){
    }

    //Borrar
    public Cita_Disp(int Codigo){
        this.Codigo = Codigo;
    }

    //Insertar
    public Cita_Disp(Date F_Disponible, String Horario){
        this.F_Disponible = F_Disponible;
        this.Horario = Horario;
    }

    //Modificar
    public Cita_Disp(int Codigo, Date F_Disponible, String Horario){
        this.Codigo = Codigo;
        this.F_Disponible = F_Disponible;
        this.Horario = Horario;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public Date getF_Disponible() {
        return F_Disponible;
    }

    public void setF_Disponible(Date F_Disponible) {
        this.F_Disponible = F_Disponible;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String Horario) {
        this.Horario = Horario;
    }
}