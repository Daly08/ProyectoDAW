package modelo;

import java.io.Serializable;

public class Promocion implements Serializable{
    private static final long serialVersionUID = 1L;
    private int Codigo;
    private String Nombre;
    private Float Precio;
    private Boolean Vigencia;

    public Promocion(){
    }

    //Borrar
    public Promocion(int Codigo){
        this.Codigo = Codigo;
    }
    
    //Insertar
    public Promocion(int Codigo, String Nombre, Float Precio, Boolean Vigencia){
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Vigencia = Vigencia;
        this.Codigo = Codigo;
    }

    //Modificar
    public Promocion(String Nombre, Float Precio, Boolean Vigencia){
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Vigencia = Vigencia;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre(){
        return Nombre;
    }

    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }

    public Float getPrecio() {
        return Precio;
    }

    public void setPrecio(Float Precio) {
        this.Precio = Precio;
    }

    public Boolean getVigencia() {
        return Vigencia;
    }

    public void setVigencia(Boolean Vigencia) {
        this.Vigencia = Vigencia;
    }
}
