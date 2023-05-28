package controlador;

import datos.Conexion;
import datos.TratamientoDAO;
import modelo.Tratamiento;

import javax.servlet.http.HttpServlet;
import javax.activation.DataSource;
import javax.annotation.Resource;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.*;

@WebServlet(name = "ServletTratamiento", urlPatterns = {"/ServletTratamiento"})
public class ServletTratamiento {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    //private Tratamiento tratamiento;
    private int Codigo;
    private String Nombre;
    private Float Precio;

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws SQLException{
        String op = (rq.getParameter("op") != null) ? rq.getParameter("op") : "list";
        
        if(op.equals("lista")){
            try{
                Connection connection = Conexion.getConnection();
                TratamientoDAO tratamientoDAO = new TratamientoDAO();
                rq.getSession().setAttribute("datos", tratamientoDAO);
                connection.close();
            }catch(SQLException e){
                rq.getSession().setAttribute("datos", new LinkedList<Tratamiento>());
                e.printStackTrace();
            }
        }
        rp.sendRedirect("/ProyectoDAW/ServletTratamiento.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws SQLException{
        String op;
        Codigo = (int)rq.getSession().getAttribute("Codigo");
        op=(String)rq.getSession().getAttribute("op");
        if(op.equals("registrar")){
            try{
                String Nombre = rq.getParameter("Nombre");
                Float Precio = Float.valueOf(rq.getParameter("Precio"));

                Connection connection = Conexion.getConnection();
                TratamientoDAO tratDAO = new TratamientoDAO();

                Tratamiento tratamiento = new Tratamiento(Nombre, Precio);
                tratDAO.insertar(tratamiento);
                connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        } else if(op.equals("modificar")){
            Nombre = rq.getParameter("Nombre");
            Precio = Float.valueOf(rq.getParameter("Precio"));
            try{
                Connection connection = Conexion.getConnection();
                TratamientoDAO tratDAO = new TratamientoDAO();

                Tratamiento tratamiento = new Tratamiento(Codigo);
                rq.getSession().setAttribute("datos", tratamiento);

                if(Nombre != null && Precio != null){
                    tratDAO.modificarNombre(Codigo, Nombre);
                    tratDAO.modificarPrecio(Codigo, Precio);
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        } else if(op.equals("buscar")){
            try{

            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        rp.sendRedirect("/ProyectoDAW/ServletTratamiento.jsp");
    }
}
