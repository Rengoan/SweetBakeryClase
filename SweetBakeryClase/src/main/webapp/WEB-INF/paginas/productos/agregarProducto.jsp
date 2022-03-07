<div class="modal fade" id="agregarProductoModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Producto</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>

            <form action="ProductoServlet?accion=insertar" method="POST"
                  class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required value="${producto.nombre}" />
                    </div>
                    <div class="form-group">
                        <label for="categoria">Categoria</label>
                        <input type="text" class="form-control" name="categoria" required value="${producto.categoria}" />
                    </div>
                    <div class="form-group">
                        <label for="precio">Precio</label>
                        <input type="number" class="form-control" name="precio" required step="any" value="${producto.precio}" />
                    </div>
                    <div class="form-group">
                        <label for="stock">Stock</label>
                        <input type="number" class="form-control" name="stock" required step="any" value="${producto.stock}" />
                    </div>
                    <div class="form-group">
                        <label for="empleado_idempleado">ID Empleado</label>
                        <input type="number" class="form-control" name="empleado_idempleado" required value="${proveedor.empleado_idempleado}" />
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button> 
                </div>
            </form>
        </div>
    </div>
</div>
