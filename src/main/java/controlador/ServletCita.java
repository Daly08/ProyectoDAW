package controlador;

import datos.CitaDAO;
import datos.Conexion;
import datos.PromocionDAO;
import modelo.Cita;
import modelo.Promocion;
import modelo.Tratamiento;

import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;
//import javax.servlet.annotation.*;
import javax.annotation.Resource;
//import javax.persistence.metamodel.SetAttribute;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.LinkedList;
import java.sql.SQLException;
import java.sql.Connection;
//import java.io.*;
//import java.sql.*;
//import java.util.*;

@WebServlet(name = "ServletCita", urlPatterns = { "/ServletCita" })
public class ServletCita extends HttpServlet {
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    CitaDAO citaDAO;
    PromocionDAO promocionDAO;

    private Cita cita;
    private int Codigo;
    private String Fecha;
    private String Horario;
    private String Cod_Tratamiento;
    private String Cod_Cliente;
    private String Cod_Promocion;

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String op = (rq.getParameter("opc") != null) ? rq.getParameter("opc") : "list";

        if (op.equals("lista")) {
            try {
                Connection connection = Conexion.getConnection();
                CitaDAO citaDAO = new CitaDAO();
                rq.getSession().setAttribute("datos", citaDAO);
                connection.close();
            } catch (SQLException e) {
                rq.getSession().setAttribute("datos", new LinkedList<Cita>());
                e.printStackTrace();
            }
        }rs.sendRedirect("/ProyectoDAW/Cita/ServletCita.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException{
        String op;
        Codigo = (int)rq.getSession().getAttribute("Codigo");
        op=(String)rq.getSession().getAttribute("op");
        
        if(op.equals("registrar")){
            try{
                String Fecha = rq.getParameter("Fecha");
                String Horario = rq.getParameter("Horario");
                String Cod_Cliente = rq.getParameter("Cod_Cliente");
                String Cod_Tratamiento = rq.getParameter("cod_Tramiento");
                String Cod_Promocion = rq.getParameter("Cod_Promocion");
                
                Connection connection = conexion.getConnection();
                CitaDAO citaDAO = new CitaDAO();
                Horario = Horario + ":00";

                cita = new Cita(Fecha, Horario, Cod_Cliente, Cod_Tratamiento, Cod_Promocion);
                citaDAO.insertar(cita);

                connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        } else if(op.equals("modificar")){
            Fecha = rq.getParameter("Fecha");
            Horario = rq.getParameter("Horario");
            Cod_Cliente = String.valueOf(Integer.parseInt(rq.getParameter("Cod_Cliente")));
            Cod_Tratamiento = String.valueOf(Integer.parseInt(rq.getParameter("Cod_Tratamiento")));
            Cod_Promocion = String.valueOf(Integer.parseInt(rq.getParameter("Cod_Promocion")));
            try{
                Connection connection = conexion.getConnection();
                CitaDAO citaDAO = new CitaDAO();
                PromocionDAO promocionDAO= new PromocionDAO();

                rq.getSession().setAttribute("datos", cita);
                rq.getSession().setAttribute("tratamiento", citaDAO);
                rq.getSession().setAttribute("promocion", promocionDAO);

                if(Fecha != null && Horario != null && Cod_Cliente != null && Cod_Tratamiento != null && Cod_Cliente != null){
                    citaDAO.modificarFecha(Codigo, Fecha);
                    citaDAO.modificarHorario(Codigo, Horario);
                    citaDAO.modificarCod_Tratamiento(Codigo, Cod_Tratamiento);
                    citaDAO.modificarCod_Cliente(Codigo, Cod_Cliente);
                    citaDAO.modificarCod_Promocion(Codigo, Cod_Promocion);
                }
                connection.close();
            }catch(SQLException e){
                rq.getSession().setAttribute("Promocion", new LinkedList<Promocion>());
                e.printStackTrace();
            }
        } else if(op.equals("buscar")){
            try{
                Connection connection = conexion.getConnection();
                CitaDAO citaDAO= new CitaDAO();

                if(cita != null){
                    rq.getSession().setAttribute("Codigo", cita.getCodigo());
                    rq.getSession().setAttribute("Encontrado", true);
                    rq.getSession().setAttribute("Tratamiento", citaDAO);
                }else{
                    rq.getSession().setAttribute("Codigo", null);
                    rq.getSession().setAttribute("Encontrado", false); 
                }
                rq.getSession().setAttribute("Codigo", null);
                rq.getSession().setAttribute("datos", cita);

                connection.close();
            }catch(SQLException e){
                rq.getSession().setAttribute("Encontrado", false);
                rq.getSession().setAttribute("Tratamiento", new LinkedList<Tratamiento>());
                e.printStackTrace();
            }
        }else if(op.equals("cancelar")){
            try{
               Connection connection = conexion.getConnection();
               CitaDAO citaDAO = new CitaDAO();
               citaDAO.borrar(Codigo);
               connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        rs.sendRedirect("/ProyectoDAW/Cita/ServletCita.jsp");
    }
}