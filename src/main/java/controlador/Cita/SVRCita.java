package controlador.Cita;

import datos.CitaDAO;
import modelo.Cita;

import javax.annotation.Resource;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Connection;
import java.io.IOException;

@WebServlet(name = "SVRCita", urlPatterns = {"/SVRCita"})
public class SVRCita extends HttpServlet{
    @Resource(name = "jdbc/database")
    private DataSource conexion;

    private Cita cita;
    //private int Codigo;

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException{
        Integer Codigo = Integer.parseInt(rq.getParameter("Codigo"));
        String Fecha = rq.getParameter("Fecha");
        String Horario = rq.getParameter("Horario");
        String Cod_Cliente = rq.getParameter("Cod_Cliente");
        String Cod_Tratamiento = rq.getParameter("Cod_Tratamiento");
        String Cod_Promocion = rq.getParameter("Cod_Promocion");
        
        try{
            Connection connection = conexion.getConnection();
            CitaDAO citaDAO = new CitaDAO();
            Horario = Horario + ":00";

            cita = new Cita(Fecha, Horario, Cod_Cliente, Cod_Tratamiento, Cod_Promocion);
            citaDAO.insertar(cita);

            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        rs.sendRedirect("/ProyectoDAW/Cita/SVRCita.jsp");
    }
    
}
