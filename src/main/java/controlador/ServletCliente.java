package controlador;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import javax.sql.DataSource;
import datos.Conexion;
import modelo.Cliente;
import datos.ClienteDAO;
import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.*;

@WebServlet(name = "ServletCliente", urlPatterns = {"/ServletCliente"})
public class ServletCliente {
    //Peticion Get
    //@Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
        String opc = (rq.getParameter("opc") != null) ? rq.getParameter("opc") : "list";

        if(opc.equals("list")){
            ClienteDAO CliDao = new ClienteDAO();
            List<Cliente> lista = CliDao.seleccionar();
            rq.setAttribute("lista", lista);
            rq.getRequestDispatcher("vistas/cliente/index.jsp").forward(rq, rp);
        }
        else if (opc.equals("mostrar")){
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            PreparedStatement state;
            ResultSet result;
            int Codigo = Integer.parseInt(rq.getParameter(("Codigo")));
            try{
                String updateSql = "SELECT * FROM Cliente WHERE Codigo = ?";
                state = conn.prepareStatement(updateSql);
                state.setInt(1, Codigo);
                result = state.executeQuery();
                Cliente client = new Cliente();
                while (result.next()){
                    client.setCodigo(result.getInt("Codigo"));
                    client.setNombre(result.getString("Nombre"));
                    client.setTelefono(result.getString("Telefono"));
                }
                rq.setAttribute("Cliente", client);
                rq.getRequestDispatcher("vistas/cliente/modificar.jsp").forward(rq, rp);

            } catch (SQLException e){
                System.out.println("Error en SQL " + e.getMessage());
            }
        }
        else if (opc.equals("borrar")){
            int Codigo = Integer.parseInt(rq.getParameter(("Codigo")));
            Cliente client = new Cliente(Codigo);
            ClienteDAO clientdao = new ClienteDAO();
            clientdao.borrar(client);
            rp.sendRedirect("ServletCliente");
        }
    }
    //@Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException{
        String op;
        op=(String)rq.getSession().getAttribute("op");
        if(op.equals("nuevo")){
            String Nombre = rq.getParameter("Nombre");
            String Telefono = rq.getParameter("Telefono");

            Cliente cliente = new Cliente(Nombre, Telefono);
            ClienteDAO clientdao = new ClienteDAO();
            clientdao.insertar(cliente);
            rp.sendRedirect("/ProyectoDAW/ServletCliente");
        }
    }
}
