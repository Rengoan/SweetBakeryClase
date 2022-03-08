<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/5c465338f1.js" crossorigin="anonymous"></script>                        
        <title>Editar Pedido</title>
    </head>
    <body>
        <!-- Inlcude de nuestro header -->
        <jsp:include page="/WEB-INF/paginas/comunes/header.jsp" />

        <form action="PedidoServlet?accion=modificar&idpedido=${pedido.idpedido}"
              method="POST" class="was-validated">

            <jsp:include page="/WEB-INF/paginas/pedidos/botonEditarPedidos.jsp" />

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Pedido</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="fecha">Fecha</label>
                                        <input type="date" class="form-control" name="fecha"  value="${pedido.fecha}" />
                                    </div>
                                    <div class="form-group">
                                        <label for="total">Total</label>
                                        <input type="number" class="form-control" name="total" required value="${pedido.total}" />
                                    </div>
                                    <div class="form-group">
                                        <label for="cliente">ID Cliente</label>
                                        <input type="number" class="form-control" name="cliente" required value="${pedido.cliente.idcliente}" />
                                    </div>
                                    <div class="form-group">
                                        <label for="empleado">ID Empleado</label>
                                        <input type="number" class="form-control" name="empleado" required value="${pedido.empleado.idempleado}" />
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </div>
            </section>

        </form>

        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp" />        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


    </body>
</html>