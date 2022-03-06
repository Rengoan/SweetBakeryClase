<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_ES" />

<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card-header">
                    <h4>Listado Clientes</h4>
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
                        <c:forEach var="cliente" items="${clientes}" varStatus="status">
                            <tr>
                                <td>${cliente.idcliente}</td>
                                <td>${cliente.nombre} ${cliente.apellido}</td>
                                <td>${cliente.telefono} </td>
                                <td>${cliente.correo} </td>
                                <td>${cliente.usuario} </td>
                                <td>${cliente.pass} </td>
                                <td>${cliente.direccion} </td>
                                <td>
                                    <a href="ClienteServlet?accion=editar&idcliente=${cliente.idcliente}" class="btn btn-secondary">
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
                        <h1>Total Clientes</h1>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i> ${totalClientes}
                        </h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Agregamos el modal de agregar cliente -->
<jsp:include page="/WEB-INF/paginas/clientes/agregarCliente.jsp" />
