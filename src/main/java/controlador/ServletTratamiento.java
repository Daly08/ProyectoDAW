package controlador;

import datos.Conexion;
import datos.TratamientoDAO;
import modelo.Tratamiento;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.*;

@WebServlet(name = "ServletTratamiento", urlPatterns = {"/ServletTratamiento"})
public class ServletTratamiento {
    

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws SQLException{
        String op;
        op=(String)rq.getSession().getAttribute("op");
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
        op=(String)rq.getSession().getAttribute("op");
        if(op.equals("registrar")){
            try{

            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        rp.sendRedirect("/ProyectoDAW/ServletTratamiento.jsp");
    }
}
