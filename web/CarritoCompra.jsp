<%-- 
    Document   : CarritoCompra
    Created on : 24/08/2023, 07:43:39 PM
    Author     : Edwar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Carrito de compras</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-9">
                <table class="table table-hover">
                    <thead>
                    <h3 class="cancelado2" style="display: none;">
                        <span style="color: #304a6e;">Carrito Compra |</span>
                        <span style="color: #668dc0"> ${usuario.getNombresEmpleado()}</span>
                    </h3>
                    <h3 class="parte1">Carrito Compra</h3>
                    
                    <tr>
                        <td>CODIGO</td>
                        <td>CODIGO-PRODUCTO</td>
                        <td>NOMBRE</td>
                        <td>PRECIO</td>
                        <td>STOCK-ACTUAL</td>
                        <td>STOCK-DESPUES-DE-LA-COMPRA</td>
                        <td>CANTIDAD</td>
                        <td>ESTADO</td>
                        <td>SUB-TOTAL</td>
                        <td class="acciones">ACCIONES</td>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="listaCarrito" items="${listaCarrito}">
                            <tr>
                                <td class="text-center">${listaCarrito.item}</td>
                                <td>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="card">
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <a class="btn btn-success" onclick="mostrar()" href="Controlador?menu=CarritoCompra&accion=Comprar">Comprar</a>
                            <a class="btn btn-danger" href="Controlador?menu=CarritoCompra&accion=Cancelar">Cancelar</a>
                            <h3 class="cancelado" style="display: none;">
                                <span style="color: black;">ESTADO: </span>
                                <span style="color: red;">CANCELADO</span>
                            </h3>
                        </div>
                        <div class="col-sm-4 ml-auto">
                            <input type="text" name="txtTotal" value="Q.${totalPagar}0" class="form-control" disabled="true">
                        </div>
                    </div>
                </div>
            </div>
            <div>
                <a class="btn btn-primary" href="javascript:void(0);" onclick="reloadAndRedirect();">Seguir comprando</a>
            </div>
        </div>
        <script>
            function reloadAndRedirect() {
                window.location.reload();
                top.location.href = 'Controlador?menu=Principal&accion=listar';
            }

            function mostrar() {
                var elementosParaOcultar = document.querySelectorAll('.parte1, .btn, .acciones');
                elementosParaOcultar.forEach(function (elemento) {
                    elemento.style.display = 'none';
                });

                var h3Cancelado = document.querySelector('.cancelado');
                h3Cancelado.style.display = 'block';
                var h3Cancelado2 = document.querySelector('.cancelado2');
                h3Cancelado2.style.display = 'block';

                var spanEstado = h3Cancelado.querySelector('span[color="black"]');
                if (spanEstado) {
                    spanEstado.style.color = 'black';
                }

                var spanCancelado = h3Cancelado.querySelector('span[color="red"]');
                if (spanCancelado) {
                    spanCancelado.style.color = 'red';
                }

                window.print();

                elementosParaOcultar.forEach(function (elemento) {
                    elemento.style.display = '';
                });
                h3Cancelado.style.display = 'none';
                h3Cancelado2.style.display = 'none';
            }
        </script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
