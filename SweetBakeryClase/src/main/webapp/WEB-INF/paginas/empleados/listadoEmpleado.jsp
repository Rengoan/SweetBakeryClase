<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_ES" />

<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card-header">
                    <h4>Listado Empleados</h4>
                </div>
                <table class="table table-striped">
                    <thead class="thead-dark">
                        <tr>
                            <th>#</th>
                            <th>Nombre</th>
                            <th>Telefono</th>
                            <th>Correo</th>
                            <th>Usuario</th>
                            <th>Contraseña</th>
                            <th>Direccion</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="empleado" items="${empleados}" varStatus="status">
                            <tr>
                                <td>${empleado.idempleado}</td>
                                <td>${empleado.nombre} ${cliente.apellido}</td>
                                <td>${empleado.telefono} </td>
                                <td>${empleado.correo} </td>
                                <td>${empleado.usuario} </td>
                                <td>${empleado.pass} </td>
                                <td>${empleado.direccion} </td>
                                <td>
                                    <a href="EmpleadoServlet?accion=editar&idempleado=${empleado.idempleado}" class="btn btn-secondary">
                                        <i class="fas fa-angle-double-right bg-success"></i> Editar
                                    </a>

                                </td>
                            </tr> 
                        </c:forEach> 
                    </tbody>
                </table>
            </div>
            <!-- Sección de las cards -->
            <div class="col-md-3">

                <div class="card text-center bg-warning text-white mb-3">
                    <div class="card-body">
                        <h1>Total Empleados</h1>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i> ${totalEmpleados}
                        </h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Agregamos el modal de agregar empleado -->
<jsp:include page="/WEB-INF/paginas/empleados/agregarEmpleado.jsp" />
