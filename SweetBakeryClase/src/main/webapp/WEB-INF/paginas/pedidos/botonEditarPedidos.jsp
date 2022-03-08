<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <a href="pedidos.jsp" class="btn btn-light btn-block">
                    <i class="fas fa-arrow-left"></i> Regresar al inicio
                </a>
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-success btn-block">
                    <i class="fas fa-check"></i> Guardar Pedido
                </button>
            </div>
            <div class="col-md-3">
                <a href="PedidoServlet?accion=eliminar&idpedido=${pedido.idpedido}" class="btn btn-light btn-block">
                    <i class="fas fa-trash"></i> Eliminar Pedido
                </a>
            </div>
        </div>
    </div>
</section>
