<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Productos</title>
    </head>
    <body>
        <h1>Listado de Productos</h1>
        <ul>
            <c:forEach items="${productos}" var="producto">
                <li>${producto.nombre} </li>
            </c:forEach>
        </ul>
    </body>
</html>
