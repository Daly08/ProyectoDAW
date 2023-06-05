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
        <h1>Citas Registradas</h1>
        <button onclick="location.href='/ProyectoDAW/Cita/RegistrarCita.jsp'">Registrar cita</button>
        <button onclick="location.href='/ProyectoDAW/Cita/BuscarCita.jsp'">Buscar cita</button>
        <button onclick="location.href='/ProyectoDAW/Cita/ModificarCita.jsp'">Modificar cita</button>
        <table>
            <thead>
            <tr>
                <th>Código</th>
                <th>Cliente</th>
                <th>Fecha</th>
                <th>Horario</th>
                <th>Tratamiento</th>
                <th>Promoción</th>
            </tr>
            </thead>
        </table>
    </div>
</main>
</body>

</html>