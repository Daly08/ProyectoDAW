<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Promociones</title>
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
            <form method="post" action="/ProyectoDAW/Cita/SVRProm.java">
                <p>Nombre de la promoción <input type="text" name="Nombre"></p>
                <p>Precio <input type="number" name="Precio"></p>
                <p>Vigencia <input type="" name="Vigencia"></p>
                <p><input type="submit" value="Registrar"></p>
            </form>
        </div>
    </main>
    </body>
</html>
