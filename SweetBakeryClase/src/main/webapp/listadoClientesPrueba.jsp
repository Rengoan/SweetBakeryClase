<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Clientes</title>
    </head>
    <body>
        <h1>Listado de Clientes</h1>
        <ul>
            <c:forEach items="${clientes}" var="cliente">
                <li>${clientes.nombre} ${clientes.apellido} </li>
            </c:forEach>
        </ul>
    </body>
</html>