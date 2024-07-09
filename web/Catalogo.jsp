<%-- 
    Document   : Catalogo
    Created on : 14/09/2023, 06:56:16 PM
    Author     : Edwar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogo</title>
    </head>
    <body>
        <div class="card col-sm-8" id="catalogo" style="margin-top: 40px; margin-left: 240px;">
            <div class="col-sm-12">
                <table class="table table-hover">
                    <table class="table table-hover">
                        <thead>
                        <h4>Catálogo de productos</h4>
                        <tr>
                            <td><strong>Cod</strong></td>
                            <td><strong>Nombre</strong></td>
                            <td><strong>Descripción</strong></td>
                            <td><strong>Precio</strong></td>
                            <td><strong>Imagen</strong></td>
                            <td><strong>Stock</strong></td>
                            <td><strong>Cod Proveedor</strong></td>
                            <td><strong>Cod Categoría</strong></td>
                            <td><strong>Actions</strong></td>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach var="producto" items="${productos}">
                            <tr>
                                <td>${producto.getIdProducto()}</td>
                                <td>${producto.getNombreProducto()}</td>
                                <td>${producto.getDescripcion()}</td>
                                <td>${producto.getPrecio()}</td>
                                <td><img src="${producto.getImagen()}" width="50"></td>
                                <td>${producto.getStock()}</td>
                                <td>${producto.getIdProveedor()}</td>
                                <td>${producto.getIdCategoria()}</td>

                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Principal&accion=AgregarCarrito&idProducto=${producto.getIdProducto()}">Agregar al Carrito</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
