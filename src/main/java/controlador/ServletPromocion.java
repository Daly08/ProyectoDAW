package controlador;

import datos.Conexion;
import datos.PromocionDAO;
import modelo.Promocion;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.*;

@WebServlet(name = "ServletPromocion", urlPatterns = {"/ServletPromocion"})
public class ServletPromocion extends HttpServlet{
    

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException{
        String op = (rq.getParameter("op") != null) ? rq.getParameter("op") : "list";

        if(op.equals("lista")){
            try{

            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        rp.sendRedirect("/ProyectoDAW/ServletPromocion.jsp");
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
        rp.sendRedirect("/ProyectoDAW/ServletPromocion.jsp");
    }
}
