package controlador;

import datos.Conexion;
import datos.CitaDAO;
import datos.ClienteDAO;
import modelo.Cliente;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.*;

@WebServlet(name = "ServletCliente", urlPatterns = {"/ServletCliente"})
public class ServletCliente extends HttpServlet{
    private int Codigo;
    ClienteDAO clienteDAO;

    private String Nombre;
    private String Telefono;

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
        String opc = (rq.getParameter("opc") != null) ? rq.getParameter("opc") : "list";

        if(opc.equals("lista")){
            try{
                Connection connection = Conexion.getConnection();
                ClienteDAO CliDao = new ClienteDAO();
                List<Cliente> lista = CliDao.seleccionar();
                rq.setAttribute("lista", lista);
                connection.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    //@Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException{
        String op;
        Codigo = (int) rq.getSession().getAttribute("Codigo");
        op=(String)rq.getSession().getAttribute("op");
        if(op.equals("registrar")){
            try{
                String Nombre = rq.getParameter("Nombre");
                String Telefono = rq.getParameter("Telefono");
    
                Connection connection = Conexion.getConnection();
                Cliente cliente = new Cliente(Nombre, Telefono);
                ClienteDAO clientdao = new ClienteDAO();
                clientdao.insertar(cliente);
                connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        } else if(op.equals("modificar")){
            try{
                Connection connection = Conexion.getConnection();
                Cliente cliente = new Cliente();
                ClienteDAO clientdao = new ClienteDAO();
                rq.getSession().setAttribute("datos", cliente);
                if(Nombre != null  && Telefono != null){
                    clienteDAO.modificar(Codigo,Nombre);
                    clienteDAO.modificar(Codigo, Telefono);
                }
                connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }else if(op.equals("buscar")){
            try{
                Connection connection = Conexion.getConnection();
                Cliente cliente = new Cliente();
                //Cita cita = new Cita();
                ClienteDAO clientdao = new ClienteDAO();
                CitaDAO citaDAO = new CitaDAO();

                if(cliente != null){
                    rq.getSession().setAttribute("Codigo", cliente.getCodigo());
                    rq.getSession().setAttribute("Encontrado", true);
                }else{
                    rq.getSession().setAttribute("Codigo", null);
                    rq.getSession().setAttribute("Encontrado", false);
                }
                rq.getSession().setAttribute("Codigo", null);
                rq.getSession().setAttribute("datos", cliente);
                rq.getSession().getAttribute("datosCita", cita);

                connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }else if(op.equals("borrar")){
            try{
                Connection connection = Conexion.getConnection();
                ClienteDAO clienteDAO = new ClienteDAO();
                ClienteDAO.borrar(Codigo);
                connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        rp.sendRedirect("/ProyectoDAW/ServletCliente.jsp");
    }
}
