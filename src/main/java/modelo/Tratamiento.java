package modelo;
import java.io.Serializable;

public class Tratamiento implements Serializable{
    private static final long serialVersionUID = 1L;
    private int Codigo;
    private String Nombre;
    private int Precio;
    private int Cod_Manicurista;

    public Tratamiento(){
    }

    //Borrar
    public Tratamiento(int Codigo){
        this.Codigo = Codigo;
    }

    //Insertar
    public Tratamiento(String Nombre, int Precio, int Cod_Manicurista){
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Cod_Manicurista = Cod_Manicurista;
    }

    //Modificar
    public Tratamiento(int Codigo, String Nombre, int Precio, int Cod_Manicurista){
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Cod_Manicurista = Cod_Manicurista;
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

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public int getCod_Manicurista() {
        return Cod_Manicurista;
    }

    public void setCod_Manicurista(int Cod_Manicurista) {
        this.Cod_Manicurista = Cod_Manicurista;
    }
}