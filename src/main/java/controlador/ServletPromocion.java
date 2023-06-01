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

    int Codigo;
    String Nombre;
    Float Precio;
    Boolean Vigencia;

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
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
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException{
        Codigo = (int)rq.getSession().getAttribute("Codigo");
        Nombre = rq.getParameter("Nombre");
        Precio = Float.parseFloat(rq.getParameter("Precio"));
        Vigencia = Boolean.parseBoolean(rq.getParameter("Vigencia"));
                
        String op;
        op=(String)rq.getSession().getAttribute("op");
        if(op.equals("registrar")){
            try{
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
                PromocionDAO promDAO = new PromocionDAO();
                Promocion prom = new Promocion();

                rq.getSession().setAttribute("datos", prom);

                if(Nombre != null && Precio != null){
                    promDAO.modificarNombre(Codigo,Nombre);
                    promDAO.modificarPrecio(Codigo, Precio);
                    if(Vigencia == null) promDAO.modificarVig(Codigo, false);
                    else promDAO.modificarVig(Codigo, true);
                }
                connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }else if(op.equals("buscar")){
            try{
                Connection connection = Conexion.getConnection();
                PromocionDAO promDAO = new PromocionDAO();
                Promocion prom = new Promocion();

                connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        rp.sendRedirect("/ProyectoDAW/ServletPromocion.jsp");
    }
}
