<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_ES" />

<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card-header">
                    <h4>Listado Productos</h4>
                </div>
                <table class="table table-striped">
                    <thead class="thead-dark">
                        <tr>
                            <th>#</th>
                            <th>Nombre</th>
                            <th>Categoria</th>
                            <th>Precio</th>
                            <th>Stock</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="producto" items="${productos}" varStatus="status">
                            <tr>
                                <td>${producto.idproducto}</td>
                                <td>${producto.nombre}</td>
                                <td>${producto.categoria}</td>
                                <td>${producto.precio} </td>
                                <td>${producto.stock} </td>
                                <td>
                                    <a href="ProductoServlet?accion=editar&idproducto=${producto.idproducto}" class="btn btn-secondary">
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

                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h1>Stock Total</h1>
                        <h4 class="display-4">
                            <i class="fas fa-box-open"></i>${total}
                        </h4>
                    </div>
                </div>
                <div class="card text-center bg-warning text-white mb-3">
                    <div class="card-body">
                        <h1>Total Productos</h1>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i> ${totalProductos}
                        </h4>
                    </div>
                </div>
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h1>Producto mas caro es de:</h1>
                        <h4 class="display-4">
                            <i class="fas fa-candy-cane">
                                <fmt:formatNumber value="${caro}" type="currency" currencySymbol="&euro;" />
                            </i>
                        </h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Agregamos el modal de agregar empleado -->
<jsp:include page="/WEB-INF/paginas/productos/agregarProducto.jsp" />
