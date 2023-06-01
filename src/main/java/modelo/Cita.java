package modelo;

import java.io.Serializable;

public class Cita implements Serializable{
    private static final long serialVersionUID = 1L;
    private int Codigo;
    private String Fecha;
    private String Horario;
    private String Cod_Cliente;
    private String Cod_Tratamiento;
    private String Cod_Promocion;

    public Cita(){
    }

    //Borrar
    public Cita(int Codigo){
        this.Codigo = Codigo;
    }

    //Insertar
    public Cita( int Codigo, String Fecha, String Horario, String Cod_Cliente, String Cod_Tratamiento,  String Cod_Promocion){
        this.Codigo = Codigo;
        this.Fecha = Fecha;
        this.Horario = Horario;
        this.Cod_Tratamiento = Cod_Tratamiento;
        this.Cod_Cliente = Cod_Cliente;
        this.Cod_Promocion = Cod_Promocion;
    }

    //Modificar
    public Cita(String Fecha, String Horario, String Cod_Cliente, String Cod_Tratamiento,  String Cod_Promocion){
        this.Fecha = Fecha;
        this.Horario = Horario;
        this.Cod_Cliente = Cod_Cliente;
        this.Cod_Tratamiento = Cod_Tratamiento;
        this.Cod_Promocion = Cod_Promocion;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String Horario) {
        this.Horario = Horario;
    }

    public String getCod_Cliente() {
        return Cod_Cliente;
    }

    public void setCod_Cliente(String Cod_Cliente) {
        this.Cod_Cliente = Cod_Cliente;
    }

    public String getCod_Tratamiento() {
        return Cod_Tratamiento;
    }

    public void setCod_Tratamiento(String Cod_Tratamiento) {
        this.Cod_Tratamiento = Cod_Tratamiento;
    }

    public String getCod_Promocion() {
        return Cod_Tratamiento;
    }

    public void setCod_Promocion(String Cod_Promocion) {
        this.Cod_Promocion = Cod_Promocion;
    }

    public String setCod_Promocion(){
        return Cod_Promocion;
    }
}