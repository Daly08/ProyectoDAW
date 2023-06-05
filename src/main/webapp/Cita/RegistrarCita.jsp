<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.Cliente" %>
<%@ page import="modelo.Tratamiento" %>
<%@ page import="modelo.Promocion" %>
<%@ page import="java.util.List" %>

<html>
    <head>
        <title>Citas</title>
    </head>
    <body>
        <header>
            <nav>
                <ul>
                <li><a href="/ProyectoDAW/index.jsp">Inicio</a></li>
                <li><a href="/ProyectoDAW/Cita/ListaCita.jsp">Citas</a></li>
                <li><a href="/ProyectoDAW/Tratamiento/ListaTra.jsp">Tratamientos</a></li>
                <li><a href="/ProyectoDAW/Promocion/ListaProm.jsp">Promociones</a></li>
                </li>
                </ul>
            </nav>
        </header>
        <main>
            <div>
                <form method="post" action="/ProyectoDAW/SVRCita.java">
                    <p>Cliente <input type="text" name="Nombre"></p>
                    <p>Fecha <input type="date" name="Fecha"></p>
                    <p>Horario <input type="time" name="Horario"></p>
                    <p>Tratamiento <input type="text" name="Tratamiento"></p>
                    <p>Promoción <input type="text" name="Promocion"></p>
                    <p><input type="submit" value="Registrar"></p>
                </form>
            </div>
        </main>
    </body>
</html>