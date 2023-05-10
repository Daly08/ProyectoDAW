package modelo;

import java.sql.*;
import java.io.Serializable;

public class Cita implements Serializable{
    private static final long serialVersionUID = 1L;
    private int Codigo;
    private Date Fecha;
    private Time Horario;
    private int Cod_Cliente;
    private int Cod_Tratamiento;
    private int Cod_Promocion;

    public Cita(){
    }

    //Borrar
    public Cita(int Codigo){
        this.Codigo = Codigo;
    }

    //Insertar
    public Cita(int Cod_Cliente, Date Fecha, Time Horario, int Cod_Tratamiento, int Cod_Promocion){
        this.Fecha = Fecha;
        this.Horario = Horario;
        this.Cod_Cliente = Cod_Cliente;
        this.Cod_Tratamiento = Cod_Tratamiento;
    }

    //Modificar
    public Cita(int Codigo, Date Fecha, Time Horario, int Cod_Cliente, int Cod_Tratamiento, int Cod_Promocion){
        this.Codigo = Codigo;
        this.Fecha = Fecha;
        this.Horario = Horario;
        this.Cod_Cliente = Cod_Cliente;
        this.Cod_Tratamiento = Cod_Tratamiento;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public Time getHorario() {
        return Horario;
    }

    public void setHorario(Time Horario) {
        this.Horario = Horario;
    }

    public int getCod_Cliente() {
        return Cod_Cliente;
    }

    public void setCod_Cliente(int Cod_Cliente) {
        this.Cod_Cliente = Cod_Cliente;
    }

    public int getCod_Tratamiento() {
        return Cod_Tratamiento;
    }

    public void setCod_Tratamiento(int Cod_Tratamiento) {
        this.Cod_Tratamiento = Cod_Tratamiento;
    }

    public int getCod_Promocion() {
        return Cod_Tratamiento;
    }

    public void setCod_Promocion(int Cod_Promocion) {
    }
}