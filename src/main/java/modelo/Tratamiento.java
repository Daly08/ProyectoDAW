package modelo;
import java.io.Serializable;

public class Tratamiento implements Serializable{
    private static final long serialVersionUID = 1L;
    private int Codigo;
    private String Nombre;
    private Float Precio;

    public Tratamiento(){
    }

    //Borrar
    public Tratamiento(int Codigo){
        this.Codigo = Codigo;
    }

    //Insertar
    public Tratamiento(String Nombre, Float Precio){
        this.Nombre = Nombre;
        this.Precio = Precio;
    }

    //Modificar
    public Tratamiento(int Codigo, String Nombre, Float Precio){
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Precio = Precio;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(int Nombre) {
        this.Nombre = String.valueOf(Nombre);
    }

    public Float getPrecio() {
        return Precio;
    }

    public void setPrecio(Float Precio) {
        this.Precio = Precio;
    }
}