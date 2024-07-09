<%-- 
    Document   : principal
    Created on : 14/07/2023, 05:19:37 PM
    Author     : informatica
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Menu Principal</title>
    </head>

    <nav class="navbar navbar-expand-lg nvbar-light bg-info">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a style="margin-left: 10 px; border: none" class="btn btn-outline-light" href="Controlador?menu=Home" target="myFrame">Home</a>
                </li>
                <li class="nav-item active">
                    <a style="margin-left: 10 px; border: none" class="btn btn-outline-light" href="Controlador?menu=Principal&accion=listar">Catálogo</a>
                </li>
                <li class="nav-item">
                    <a style="margin-left: 10 px; border: none" class="btn btn-outline-light" href="Controlador?menu=Producto&accion=listar" target="myFrame">Producto</a>
                </li>
                <li class="nav-item">
                    <a style="margin-left: 10 px; border: none" class="btn btn-outline-light" href="Controlador?menu=Empleado&accion=listar" target="myFrame">Empleado</a>
                </li>
                <li class="nav-item">
                    <a style="margin-left: 10 px; border: none" class="btn btn-outline-light" href="Controlador?menu=Clientes&accion=listar" target="myFrame">Cliente</a>
                </li>
                <li class="nav-item">
                    <a style="margin-left: 10 px; border: none" class="btn btn-outline-light" href="Controlador?menu=RegistroVenta&accion=default" target="myFrame">Registrar Venta</a>
                </li>
            </ul>
        </div>
        <div>
            <a style="margin-left: 10 px; border: none" class="btn btn-outline-light" href="Controlador?menu=CarritoCompra&accion=listar" target="myFrame">
                <img src="img/carrito-de-compras.png" alt="" width="32"/>Carrito de compras<i class="fas fa-cart-plus">(<label style="color: red">${contador}</label>)</i></a>
        </div>
        <div class="dropdown">

            <button style="border: none" class="btn btn-outline-light dropdown-toggle " type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true">${usuario.getNombresEmpleado()}</button>
            <div class="dropdown-menu text-center" aria-labellebdy="dropdownMenuButton">
                <a class="dropdown-item" href="#">
                    <img style="border-radius: 50%;" src="img/${usuario.getUsuario()}.png" alt="" width="50"/>
                </a>
                <a class="dropdown-item" href="#">${usuario.getUsuario()}</a>
                <a class="dropdown-item" href="#">${usuario.getUsuario()}@kinal.edu.gt</a>
                <div class="dropdown-divider"></div>
                <form action="Validarr" method="POST">
                    <button name="accion" name="Salir" class="dropdown-item" href="#">Salir</button>
                </form>
            </div>
        </div>
    </nav>
    <div class="card col-sm-7" id="catalogo" style="margin-top: 40px; margin-left: 240px;">
        <div class="col-sm-12">
            <table class="table table-hover">
                <h4>Catalogo de productos</h4>
                <thead>
                    <tr>
                        <td>CODIGO</td>
                        <td>NOMBRE</td>
                        <td>PRECIO</td>
                        <td>STOCK</td>
                        <td>ESTADO</td>
                        <td>ACCIONES</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="producto" items="${productos}">
                        <tr>
                            <td>${producto.getCodigoProducto()}</td>
                            <td>${producto.getNombreProducto()}</td>
                            <td>${producto.getPrecio()}</td>
                            <td>${producto.getStock()}</td>
                            <td>${producto.getEstado()}</td>
                            <td>
                                <a class="btn btn-success" href="Controlador?menu=Principal&accion=AgregarCarrito&codigoProducto=${producto.getCodigoProducto()}">
                                    <img src="img/agregar-carrito.png" alt="Agregar al carrito"> Agregar al carrito
                                </a>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </div>

    <div class="m-4" style="height: 660px">
        <iframe name="myFrame" style="height: 100%; width: 100%; border: none;"></iframe>
    </div>
    <%-- Script necesario para mostrar el catálogo de productos en la pestaña principal --%>
    <script>
        const iframe = document.getElementsByName("myFrame")[0];
        const catalogo = document.getElementById("catalogo");

        iframe.addEventListener("load", function () {
            // Oculta la tarjeta cuando el contenido del iframe cambia
            catalogo.style.display = "none";
        });
    </script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

</html>
