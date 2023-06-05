<%--
  Created by IntelliJ IDEA.
  User: Julit
  Date: 04/06/2023
  Time: 06:36 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Citas registradas</title>
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="/ProyectoDAW/index.jsp">Inicio</a></li>
            <li><a href="/ProyectoDAW/Cita/ListaCita.jsp">Citas</a></li>
            <li><a href="/ProyectoDAW/Tratamiento/ListaTra.jsp">Tratamientos</a></li>
            <li><a href="/ProyectoDAW/Promocion/ListaProm.jsp">Promociones</a></li>
        </ul>
    </nav>
</header>
<main>
    <div>
        <h1>Promociones</h1>
        <button onclick="location.href='/ProyectoDAW/Promocion/RegistrarProm.jsp'">Agregar promoción</button>
        <button onclick="location.href='/ProyectoDAW/Promocion/BuscarProm.jsp'">Buscar Promoción</button>
        <button onclick="location.href='/ProyectoDAW/Promocion/ModificarProm.jsp'">Modificar promoción</button>
        <table>
            <thead>
            <tr>
                <th>Código</th>
                <th>Promoción</th>
                <th>Precio</th>
                <th>Vigencia</th>
            </tr>
            </thead>
        </table>
    </div>
</main>

</body>

</html>
