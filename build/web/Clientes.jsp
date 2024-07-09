<%-- 
    Document   : Clientes
    Created on : 14/07/2023, 05:19:56 PM
    Author     : informatica
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Ingreso Clientes</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Clientes" method="POST">
                        <div class="form-group">
                            <label>DPI:</label>
                            <input type="text" value="${cliente.getDPICliente()}" name="txtDPICliente" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre:</label>
                            <input type="text" value="${cliente.getNombresCliente()}" name="txtNombresCliente" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Dirección:</label>
                            <input type="text" value="${cliente.getDireccionCliente()}" name="txtDireccionCliente" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado:</label>
                            <input type="text" value="${cliente.getEstado()}" name="txtEstadoCliente" class="form-control">
                        </div>
                        <button type="submit" name="accion" value="Agregar" class="btn btn-info">
                            <img src="img/agregar.png" alt="Agregar"> Agregar
                        </button>
                        <button type="submit" name="accion" value="Actualizar" class="btn btn-success">
                            <img src="img/actualizar.png" alt="Agregar"> Actualizar
                        </button>
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <td>CODIGO</td>
                            <td>DPI</td>
                            <td>NOMBRES</td>
                            <td>DIRECCION</td>
                            <td>ESTADO</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cliente" items="${clientes}">
                            <tr>
                                <td>${cliente.getCodigoCliente()}</td>
                                <td>${cliente.getDPICliente()}</td>
                                <td>${cliente.getNombresCliente()}</td>
                                <td>${cliente.getDireccionCliente()}</td>
                                <td>${cliente.getEstado()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Clientes&accion=Editar&codigoCliente=${cliente.getCodigoCliente()}">
                                        <img src="img/editar.png" alt="editar"> Editar
                                    </a>
                                    <a class="btn btn-danger" onclick="return confirm('¿Desea eliminar este registro?')" href="Controlador?menu=Clientes&accion=Eliminar&codigoCliente=${cliente.getCodigoCliente()}">
                                        <img src="img/borrar.png" alt="editar"> Eliminar
                                    </a>
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
