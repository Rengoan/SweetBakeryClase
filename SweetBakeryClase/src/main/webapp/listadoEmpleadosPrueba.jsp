<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Empleados</title>
    </head>
    <body>
        <h1>Listado de Empleados</h1>
        <ul>
            <c:forEach items="${empleados}" var="empleado">
                <li>${empleados.nombre} ${empleados.apellido} </li>
            </c:forEach>
        </ul>
    </body>
</html>