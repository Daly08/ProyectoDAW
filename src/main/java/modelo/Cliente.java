package modelo;
import java.io.Serializable;

public class Cliente implements Serializable{
    private static final long serialVersionUID = 1L;
    private int Codigo;
    private String Nombre;
    private String Telefono;

    public Cliente(){
    }

    //Borrar
    public Cliente(int Codigo){
        this.Codigo = Codigo;
    }

    //Insertar
    public Cliente(String Nombre, String Telefono){
        this.Nombre = Nombre;
        this.Telefono = Telefono;
    }

    //Modificar
    public Cliente(int Codigo, String Nombre, String Telefono){
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

    public static String getNombre() {
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