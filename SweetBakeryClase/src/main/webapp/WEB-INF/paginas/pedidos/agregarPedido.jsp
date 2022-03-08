<div class="modal fade" id="agregarPedidoModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Pedido</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>

            <form action="PedidoServlet?accion=insertar" method="POST"
                  class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="fecha">Fecha</label>
                        <input type="date" class="form-control" name="fecha" required value="${pedido.fecha}" />
                    </div>
                    <div class="form-group">
                        <label for="total">Total</label>
                        <input type="number" class="form-control" name="total" required value="${pedido.total}" />
                    </div>
                    <div class="form-group">
                        <label for="empleado">ID Cliente</label>
                        <input type="number" class="form-control" name="empleado" required value="${pedido.cliente.idcliente}" />
                    </div>
                    <div class="form-group">
                        <label for="empleado">ID Empleado</label>
                        <input type="number" class="form-control" name="empleado" required value="${pedido.empleado.idempleado}" />
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button> 
                </div>
            </form>
        </div>
    </div>
</div>
