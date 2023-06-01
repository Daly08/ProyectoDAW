package controlador;

import datos.Conexion;
import datos.PromocionDAO;
import modelo.Promocion;

import javax.servlet.http.HttpServlet;
import javax.annotation.Resource;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.*;

@WebServlet(name = "ServletPromocion", urlPatterns = {"/ServletPromocion"})
public class ServletPromocion extends HttpServlet{
    @Resource(name = "jdbc/database")

    String Nombre;
    Float Precio;
    Boolean Vigencia;

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException{
        String op = (rq.getParameter("op") != null) ? rq.getParameter("op") : "list";

        if(op.equals("lista")){
            try{
                Connection connection = Conexion.getConnection();
                PromocionDAO promocionDAO = new PromocionDAO();
                rq.getSession().setAttribute("datos", promocionDAO);
                connection.close();
            }catch(SQLException e){
                rq.getSession().setAttribute("datos", new LinkedList<Promocion>());
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
                Nombre = rq.getParameter("Nombre");
                Precio = Float.parseFloat(rq.getParameter("Precio"));
                Vigencia = Boolean.parseBoolean(rq.getParameter("Vigencia"));
                Connection connection = Conexion.getConnection();
                PromocionDAO promDAO = new PromocionDAO();

                boolean checkbox;
                if(Vigencia == null) checkbox = false;
                else checkbox = true;

                Promocion prom = new Promocion(Nombre, Precio, checkbox);
                promDAO.insertar(prom);

                connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        } else if(op.equals("modificar")){
            try{
                Connection connection = Conexion.getConnection();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        rp.sendRedirect("/ProyectoDAW/ServletPromocion.jsp");
    }
}
