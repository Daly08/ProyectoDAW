package modelo;
import java.io.Serializable;
public class Empleado implements Serializable{
    private static final long seralVersionUID =1L;
    private int Codigo;
    private String Nombre;
    private String Cargo;
    private String Telefono;

    public Empleado(){
    }

    public Empleado(int Codigo, String Nombre, String Cargo, String Telefono){
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Cargo = Cargo;
        this.Telefono = Telefono;
    }

    public Empleado(String Nombre, String Cargo, String Telefono){
        this.Nombre = Nombre;
        this.Cargo = Cargo;
        this.Telefono = Telefono;
    }

    public Empleado(int Codigo){
        this.Codigo = Codigo;
    }

    public int getCodigo(){
        return Codigo;
    }

    public void setCodigo(int Codigo){
        this.Codigo = Codigo;
    }

    public String getNombre(){
        return Nombre;
    }

    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }

    public String getCargo(){
        return Cargo;
    }

    public void setCargo(String Cargo){
        this.Cargo = Cargo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
}
