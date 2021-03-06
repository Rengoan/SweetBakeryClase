<div class="modal fade" id="agregarEmpleadoModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Empleado</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>

            <form action="EmpleadoServlet?accion=insertar" method="POST"
                  class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required/>
                    </div>
                    <div class="form-group">
                        <label for="apellido">Apellido</label>
                        <input type="text" class="form-control" name="apellido" required/>
                    </div>
                    <div class="form-group">
                        <label for="telefono">Tel?fono</label>
                        <input type="tel" class="form-control" name="telefono" />
                    </div>
                    <div class="form-group">
                        <label for="correo">Correo</label>
                        <input type="email" class="form-control" name="correo" required/>
                    </div>
                    <div class="form-group">
                        <label for="usuario">Usuario</label>
                        <input type="text" class="form-control" name="usuario" />
                    </div>   
                    <div class="form-group">
                        <label for="pass">Contrase?a</label>
                        <input type="password" class="form-control" name="pass" />
                    </div> 
                    <div class="form-group">
                        <label for="direccion">Direccion</label>
                        <input type="text" class="form-control" name="direccion" />
                    </div> 
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button> 
                </div>
            </form>
        </div>
    </div>
</div>