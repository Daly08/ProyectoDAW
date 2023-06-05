<%--
  Created by IntelliJ IDEA.
  User: Julit
  Date: 04/06/2023
  Time: 07:22 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Tratamientos</title>
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
            <form method="post" action="/Proyecto/SVRTrat.java">
                <p>Nombre del tratamiento <input type="text" name="Nombre"></p>
                <p>Precio <input type="number" name="Precio"></p>
                <p>Empleado <select></select></p>
            </form>
        </div>
    </main>
    </body>
</html>
