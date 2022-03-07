<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_ES" />

<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card-header">
                    <h4>Listado Proveedores</h4>
                </div>
                <table class="table table-striped">
                    <thead class="thead-dark">
                        <tr>
                            <th>#</th>
                            <th>Nombre</th>
                            <th>Correo</th>
                            <th>Telefono</th>
                            <th>Direccion</th>
                            <th>ID Empleado</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="proveedor" items="${proveedores}" varStatus="status">
                            <tr>
                                <td>${proveedor.idproveedor}</td>
                                <td>${proveedor.nombre}</td>
                                <td>${proveedor.correo}</td>
                                <td>${proveedor.telefono} </td>
                                <td>${proveedor.direccion} </td>
                                <td>${proveedor.empleado} </td>
                                <td>
                                    <a href="ProveedorServlet?accion=editar&idproveedor=${proveedor.idproveedor}" class="btn btn-secondary">
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
                        <h1>Total Proveedores</h1>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i> ${totalProveedores}
                        </h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Agregamos el modal de agregar empleado -->
<jsp:include page="/WEB-INF/paginas/proveedores/agregarProveedor.jsp" />
