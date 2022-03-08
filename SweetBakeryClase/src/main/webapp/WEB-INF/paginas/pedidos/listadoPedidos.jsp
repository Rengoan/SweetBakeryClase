<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_ES" />

<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card-header">
                    <h4>Listado Pedidos</h4>
                </div>
                <table class="table table-striped">
                    <thead class="thead-dark">
                        <tr>
                            <th>#</th>
                            <th>Fecha</th>
                            <th>Total</th>
                            <th>ID Cliente</th>
                            <th>Nombre Cliente</th>
                            <th>ID Empleado</th>
                            <th>Nombre Empleado</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pedido" items="${pedidos}" varStatus="status">
                            <tr>
                                <td>${pedido.idpedido}</td>
                                <td>${pedido.fecha}</td>
                                <td>${pedido.total}</td>
                                <td>${pedido.cliente.idcliente}</td>
                                <td>${pedido.cliente.nombre} </td>
                                <td>${pedido.empleado.idempleado}</td>
                                <td>${pedido.empleado.nombre} </td>
                                <td>
                                    <a href="PedidoServlet?accion=editar&idpedido=${pedido.idpedido}" class="btn btn-secondary">
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
                        <h1>Total Pedidos</h1>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i> ${totalPedidos}
                        </h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Agregamos el modal de agregar empleado -->
<jsp:include page="/WEB-INF/paginas/pedidos/agregarPedido.jsp" />
