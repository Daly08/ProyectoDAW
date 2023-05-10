package modelo;
import java.io.Serializable;

public class Manicurista implements Serializable{
    private static final long serialVersionUID = 1L;
    private int Codigo;
    private String Nombre;
    private String Telefono;

    public Manicurista(){
    }

    //Borrar
    public Manicurista(int Codigo){
        this.Codigo = Codigo;
    }

    //Insertar
    public Manicurista(String Nombre, String Telefono){
        this.Nombre = Nombre;
        this.Telefono = Telefono;
    }

    //Modificar
    public Manicurista(int Codigo, String Nombre, String Telefono){
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
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

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
}