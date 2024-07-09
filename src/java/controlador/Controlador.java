/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.CarritoCompra;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import modelo.Producto;
import modelo.ProductoDAO;
import modelo.Venta;
import modelo.VentaDAO;

/**
 *
 * @author informatica
 */
public class Controlador extends HttpServlet {

    Empleado empleado = new Empleado();
    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    Producto producto = new Producto();
    ProductoDAO productoDAO = new ProductoDAO();
    Cliente cliente = new Cliente();
    ClienteDAO clienteDAO = new ClienteDAO();
    CarritoCompra carrito = new CarritoCompra();

    Venta venta = new Venta();
    VentaDAO ventaDAO = new VentaDAO();
    int codEmpleado;
    int codProducto;
    int codCliente;
    List<Venta> lista = new ArrayList<>();
    int item;
    int codPro;
    String descripcion;
    double precio;
    int cantidad = 1;
    double subTotal;
    double totalPagar;
    int contador;
    int posicion;
    String numSerie;
    List<CarritoCompra> listaCarrito = new ArrayList<>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        System.out.println(menu + " + menu");
        System.out.println(accion + " + accion");
        if (menu.equals("Principal")) {
            switch (accion) {
                case "listar":
                    List listaProducto = productoDAO.listar();
                    request.setAttribute("productos", listaProducto);
                    request.setAttribute("contador", contador);
                    break;
                case "AgregarCarrito":
                    cantidad = 1;
                    codProducto = Integer.parseInt(request.getParameter("codigoProducto"));
                    producto = productoDAO.listarPorCodigoProducto(codProducto);
                    if (listaCarrito.size() > 0) {
                        for (int i = 0; i < listaCarrito.size(); i++) {
                            if (codProducto == listaCarrito.get(i).getCodigoProducto()) {
                                contador++;
                                posicion = i;
                            }
                        }
                        if (codProducto == listaCarrito.get(posicion).getCodigoProducto()) {
                            int res = producto.getStock();
                            if (res == 0) {
                                String mensajeAlerta = "Sin existencias!!";
                                System.out.println(mensajeAlerta);
                            } else {
                                cantidad = listaCarrito.get(posicion).getCantidad() + cantidad;
                                subTotal = listaCarrito.get(posicion).getPrecioProducto() * cantidad;
                                listaCarrito.get(posicion).setCantidad(cantidad);
                                int stock = producto.getStock() - listaCarrito.get(posicion).getCantidad();
                                listaCarrito.get(posicion).setStockDesCom(stock);
                                listaCarrito.get(posicion).setSubtotal(subTotal);
                            }
                        } else {
                            int res = producto.getStock();
                            if (res == 0) {
                                String mensajeAlerta = "Sin existencias!!";
                                System.out.println(mensajeAlerta);
                            } else {
                                item = item + 1;
                                carrito = new CarritoCompra();
                                carrito.setItem(item);
                                carrito.setCodigoProducto(producto.getCodigoProducto());
                                carrito.setDescripcionProducto(producto.getNombreProducto());
                                carrito.setPrecioProducto(producto.getPrecio());
                                carrito.setCantidad(cantidad);
                                carrito.setStockActual(producto.getStock());
                                carrito.setStockDesCom(carrito.getStockActual() - cantidad);
                                carrito.setEstado(producto.getEstado());
                                carrito.setSubtotal(cantidad * producto.getPrecio());
                                listaCarrito.add(carrito);
                                contador++;
                            } 
                        }
                    } else {
                        int res = producto.getStock();
                        if (res == 0) {
                            String mensajeAlerta = "Sin existencias!!";
                            System.out.println(mensajeAlerta);
                        } else {
                            item = item + 1;
                            carrito = new CarritoCompra();
                            carrito.setItem(item);
                            carrito.setCodigoProducto(producto.getCodigoProducto());
                            carrito.setDescripcionProducto(producto.getNombreProducto());
                            carrito.setPrecioProducto(producto.getPrecio());
                            carrito.setCantidad(cantidad);
                            carrito.setStockActual(producto.getStock());
                            carrito.setStockDesCom(carrito.getStockActual() - cantidad);
                            carrito.setEstado(producto.getEstado());
                            carrito.setSubtotal(cantidad * producto.getPrecio());
                            listaCarrito.add(carrito);
                            contador = listaCarrito.size();
                        }
                    }
                    totalPagar = 0.0;
                    for (int i = 0; i < listaCarrito.size(); i++) {
                        totalPagar = totalPagar + listaCarrito.get(i).getSubtotal();
                    }
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("contador", contador);
                    request.setAttribute("listaCarrito", listaCarrito);
                    Empleado emp = (Empleado) request.getSession().getAttribute("usuario");
                    request.getRequestDispatcher("Controlador?menu=Principal&accion=listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        } else if (menu.equals("Empleado")) {
            switch (accion) {
                case "listar":
                    List listaEmpleado = empleadoDAO.listar();
                    request.setAttribute("empleados", listaEmpleado);
                    break;
                case "Agregar":
                    String DPI = request.getParameter("txtDPIEmpleado");
                    String nombres = request.getParameter("txtNombresEmpleado");
                    String telefono = request.getParameter("txtTelefonoEmpleado");
                    String est = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUsuario");
                    empleado.setDPIEmpleado(DPI);
                    empleado.setNombresEmpleado(nombres);
                    empleado.setTelefonoEmpleado(telefono);
                    empleado.setEstado(est);
                    empleado.setUsuario(user);
                    empleadoDAO.agregar(empleado);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=listar").forward(request, response);
                    break;
                case "Editar":
                    codEmpleado = Integer.parseInt(request.getParameter("codigoEmpleado"));
                    Empleado e = empleadoDAO.listarCodigoEmpleado(codEmpleado);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=listar").forward(request, response);
                    break;
                case "Actualizar":
                    DPI = request.getParameter("txtDPIEmpleado");
                    nombres = request.getParameter("txtNombresEmpleado");
                    telefono = request.getParameter("txtTelefonoEmpleado");
                    est = request.getParameter("txtEstado");
                    user = request.getParameter("txtUsuario");
                    empleado.setDPIEmpleado(DPI);
                    empleado.setNombresEmpleado(nombres);
                    empleado.setTelefonoEmpleado(telefono);
                    empleado.setEstado(est);
                    empleado.setUsuario(user);
                    empleado.setCodigoEmpleado(codEmpleado);
                    empleadoDAO.actualizar(empleado);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=listar").forward(request, response);
                    break;
                case "Eliminar":
                    codEmpleado = Integer.parseInt(request.getParameter("codigoEmpleado"));
                    empleadoDAO.eliminar(codEmpleado);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        } else if (menu.equals("Producto")) {
            switch (accion) {
                case "listar":
                    List listaProducto = productoDAO.listar();
                    request.setAttribute("productos", listaProducto);
                    break;
                case "Agregar":
                    String nomProducto = request.getParameter("txtNombreProducto");
                    double precio = Double.parseDouble(request.getParameter("txtPrecio"));
                    int stock = Integer.parseInt(request.getParameter("txtStock"));
                    String est = request.getParameter("txtEstado");
                    producto.setNombreProducto(nomProducto);
                    producto.setPrecio(precio);
                    producto.setStock(stock);
                    producto.setEstado(est);
                    productoDAO.agregar(producto);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=listar").forward(request, response);
                    break;
                case "Editar":
                    codProducto = Integer.parseInt(request.getParameter("codigoProducto"));
                    Producto pr = productoDAO.listarPorCodigoProducto(codProducto);
                    request.setAttribute("producto", pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=listar").forward(request, response);
                    break;
                case "Actualizar":
                    nomProducto = request.getParameter("txtNombreProducto");
                    System.out.println(nomProducto);
                    precio = Double.parseDouble(request.getParameter("txtPrecio"));
                    stock = Integer.parseInt(request.getParameter("txtStock"));
                    est = request.getParameter("txtEstado");
                    producto.setNombreProducto(nomProducto);
                    producto.setPrecio(precio);
                    producto.setStock(stock);
                    producto.setEstado(est);
                    producto.setCodigoProducto(codProducto);
                    productoDAO.actualizar(producto);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=listar").forward(request, response);
                    break;
                case "Eliminar":
                    codProducto = Integer.parseInt(request.getParameter("codigoProducto"));
                    productoDAO.eliminar(codProducto);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        } else if (menu.equals("Clientes")) {
            switch (accion) {
                case "listar":
                    List listaCliente = clienteDAO.listar();
                    request.setAttribute("clientes", listaCliente);
                    break;
                case "Agregar":
                    String DPICli = request.getParameter("txtDPICliente");
                    String nombres = request.getParameter("txtNombresCliente");
                    String direccionCliente = request.getParameter("txtDireccionCliente");
                    String est = request.getParameter("txtEstadoCliente");
                    cliente.setDPICliente(DPICli);
                    cliente.setNombresCliente(nombres);
                    cliente.setDireccionCliente(direccionCliente);
                    cliente.setEstado(est);
                    clienteDAO.agregar(cliente);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=listar").forward(request, response);
                    break;
                case "Editar":
                    codCliente = Integer.parseInt(request.getParameter("codigoCliente"));
                    Cliente cli = clienteDAO.listarPorCodigoCliente(codCliente);
                    request.setAttribute("cliente", cli);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=listar").forward(request, response);
                    break;
                case "Actualizar":
                    DPICli = request.getParameter("txtDPICliente");
                    nombres = request.getParameter("txtNombresCliente");
                    direccionCliente = request.getParameter("txtDireccionCliente");
                    est = request.getParameter("txtEstadoCliente");
                    cliente.setDPICliente(DPICli);
                    cliente.setNombresCliente(nombres);
                    cliente.setDireccionCliente(direccionCliente);
                    cliente.setEstado(est);
                    cliente.setCodigoCliente(codCliente);
                    clienteDAO.actualizar(cliente);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=listar").forward(request, response);
                    break;
                case "Eliminar":
                    codCliente = Integer.parseInt(request.getParameter("codigoCliente"));
                    clienteDAO.eliminar(codCliente);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        } else if (menu.equals("RegistroVenta")) {
            switch (accion) {
                case "BuscarCliente":
                    codCliente = Integer.parseInt(request.getParameter("txtCodigoCliente"));
                    cliente = clienteDAO.buscarCliente(codCliente);
                    request.setAttribute("cliente", cliente);
                    break;
                case "BuscarProducto":
                    codProducto = Integer.parseInt(request.getParameter("txtCodigoProducto"));
                    producto.setCodigoProducto(codProducto);
                    producto = productoDAO.listarPorCodigoProducto(codProducto);
                    request.setAttribute("producto", producto);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("cliente", cliente);
                    break;
                case "Agregar":
                    request.setAttribute("cliente", cliente);
                    totalPagar = 0.0;
                    item = item + 1;
                    codPro = producto.getCodigoProducto();
                    descripcion = request.getParameter("txtNombreProducto");
                    precio = Double.parseDouble(request.getParameter("txtPrecio"));
                    cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
                    subTotal = precio * cantidad;
                    venta = new Venta();
                    venta.setItem(item);
                    venta.setCodProducto(codPro);
                    venta.setDescripcionProd(descripcion);
                    venta.setPrecio(precio);
                    venta.setCantidad(cantidad);
                    venta.setSubTotal(subTotal);
                    lista.add(venta);
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar = totalPagar + lista.get(i).getSubTotal();
                    }
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("lista", lista);
                    break;
                case "GenerarVenta":
                    for (int i = 0; i < lista.size(); i++) {
                        producto = new Producto();
                        int cant = lista.get(i).getCantidad();
                        int codProduct = lista.get(i).getCodProducto();
                        productoDAO = new ProductoDAO();
                        producto = productoDAO.listarPorCodigoProducto(codProduct);
                        int sn = producto.getStock() - cant;
                        productoDAO.actualizarStock(codProduct, sn);
                    }
                    venta.setCodigoCliente(cliente.getCodigoCliente());
                    venta.setCodigoEmpleado(2);
                    venta.setNumeroSerie(numSerie);
                    venta.setFecha("2023-02-15");
                    venta.setMonto(totalPagar);
                    venta.setEstado("1");
                    ventaDAO.guardarVenta(venta);
                    int codVenta = Integer.parseInt(ventaDAO.codigoVenta());
                    for (int i = 0; i < lista.size(); i++) {
                        venta = new Venta();
                        venta.setCodProducto(lista.get(i).getCodProducto());
                        venta.setCantidad(lista.get(i).getCantidad());
                        venta.setPrecio(lista.get(i).getPrecio());
                        venta.setCodigoVenta(codVenta);
                        ventaDAO.guardarDetalleVenta(venta);
                    }
                    break;
                case "Eliminar":
                    codProducto = Integer.parseInt(request.getParameter("codigoProducto"));
                    if (lista.size() > 0) {
                        for (int i = 0; i < lista.size(); i++) {
                            if (codProducto == lista.get(i).getCodProducto()) {
                                posicion = i;
                            }
                        }
                        if (codProducto == lista.get(posicion).getCodProducto()) {
                            contador = contador - lista.get(posicion).getCantidad();
                            totalPagar = totalPagar - lista.get(posicion).getSubTotal();
                            lista.remove(posicion);
                        }
                    }
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalPagar", totalPagar);
                    break;
                default:
                    numSerie = ventaDAO.generarNumSerie();
                    if (numSerie == null) {
                        numSerie = "0000001";
                        request.setAttribute("numSerie", numSerie);
                    } else {
                        int num = Integer.parseInt(numSerie);
                        numSerie = ventaDAO.numeroSerie(num);
                        request.setAttribute("numSerie", numSerie);
                    }
            }
            request.getRequestDispatcher("RegistroVenta.jsp").forward(request, response);
        } else if (menu.equals("Home")) {
            Empleado emple = (Empleado) request.getSession().getAttribute("usuario");
            String usuario = emple.getUsuario();
            int carnet;
            if ("echamale-2022222".equals(usuario)) {
                carnet = 2022222;
                request.setAttribute("carnet", carnet);
            } else {
                carnet = 2022240;
                request.setAttribute("carnet", carnet);
            }
            request.getRequestDispatcher("Home.jsp").forward(request, response);
        } else if (menu.equals("CarritoCompra")) {
            switch (accion) {
                case "Eliminar":
                    codProducto = Integer.parseInt(request.getParameter("codigoProducto"));
                    if (listaCarrito.size() > 0) {
                        for (int i = 0; i < listaCarrito.size(); i++) {
                            if (codProducto == listaCarrito.get(i).getCodigoProducto()) {
                                posicion = i;
                            }
                        }
                        if (codProducto == listaCarrito.get(posicion).getCodigoProducto()) {
                            contador = contador - listaCarrito.get(posicion).getCantidad();
                            totalPagar = totalPagar - listaCarrito.get(posicion).getSubtotal();
                            listaCarrito.remove(posicion);
                        }
                    }
                    request.setAttribute("contador", contador);
                    request.setAttribute("listaCarrito", listaCarrito);
                    break;
                case "Cancelar":
                    if (listaCarrito.size() > 0) {
                        listaCarrito.clear();
                        contador = 0;
                        totalPagar = 0.0;
                    }
                    request.setAttribute("contador", contador);
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("listaCarrito", listaCarrito);
                    break;
                case "Comprar":
                    for (int i = 0; i < listaCarrito.size(); i++) {
                        producto = new Producto();
                        int cant = listaCarrito.get(i).getCantidad();
                        int codProduct = listaCarrito.get(i).getCodigoProducto();
                        productoDAO = new ProductoDAO();
                        producto = productoDAO.listarPorCodigoProducto(codProduct);
                        int sn = producto.getStock() - cant;
                        contador = contador - listaCarrito.get(i).getCantidad();
                        productoDAO.actualizarStock(codProduct, sn);
                    }
                    listaCarrito.clear();
                    totalPagar = 0.0;
                    Empleado emple = (Empleado) request.getSession().getAttribute("usuario");
                    request.setAttribute("contador", contador);
                    request.setAttribute("totalPagar", totalPagar);
                    break;
            }
            request.setAttribute("listaCarrito", listaCarrito);
            request.setAttribute("totalPagar", totalPagar);
            request.getRequestDispatcher("CarritoCompra.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
