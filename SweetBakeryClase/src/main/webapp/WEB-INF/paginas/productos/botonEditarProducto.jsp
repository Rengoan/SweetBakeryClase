<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <a href="productos.jsp" class="btn btn-light btn-block">
                    <i class="fas fa-arrow-left"></i> Regresar al inicio
                </a>
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-success btn-block">
                    <i class="fas fa-check"></i> Guardar Producto
                </button>
            </div>
            <div class="col-md-3">
                <a href="ProductoServlet?accion=eliminar&idproducto=${producto.idproducto}" class="btn btn-light btn-block">
                    <i class="fas fa-trash"></i> Eliminar Producto
                </a>
            </div>
        </div>
    </div>
</section>
