<%-- 
    Document   : Home
    Created on : 24/08/2023, 10:26:54 PM
    Author     : Edwar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Home</title>
    </head>
    <body>
        <div class="d-flex justify-content-center align-items-center" style="height: 100vh;">
            <div class="justify-content-center align-items-center" style="height: 100vh;">
                <div class="justify-content-center align-items-center" style="height: 100vh;">
                    <div class="d-flex justify-content-center align-items-center"> 
                        <img style="border-radius: 50%;" src="img/${usuario.getUsuario()}.png" alt="" width="400"/>
                    </div>
                    <div class="d-flex justify-content-center align-items-center" style="font-family: monospace">
                        <label class="text-center">Nombre: ${usuario.getNombresEmpleado()}</label><br>
                    </div>
                    <div class="d-flex justify-content-center align-items-center" style="font-family: monospace">
                        <label class="text-center">Carné: ${carnet}</label><br>
                    </div>
                    <div class="d-flex justify-content-center align-items-center" style="font-family: monospace">
                        <label class="text-center">Código técnico: IN5BV</label><br>
                    </div><br>
                    <div class="d-flex justify-content-center align-items-center" style="font-family: monospace">
                        <label class="text-center">Proyecto de ventas</label><br>
                    </div><br>
                    <div class="d-flex justify-content-center align-items-center" style="font-family: monospace">
                        <label class="text-center">El siguiente proyecto de ventas fue desarrollado en el lenguaje Java en su entorno Web. Aplicando el Patrón: Modelo Vista Controlador.</label><br>
                    </div>
                </div>
            </div>
            
        </div>
        
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
