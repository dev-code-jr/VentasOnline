package modelo;

public class Venta {
    private int codigoVenta;
    private int item;
    private int codigoCliente;
    private int codigoEmpleado;
    private String numeroSerie;
    private String descripcionProd;
    private int codProducto;
    private String fecha;
    private double  precio;
    private int cantidad;
    private double subTotal;
    private double monto;
    private String estado;

    public Venta() {
    }

    public Venta(int codigoVenta, int item, int codigoCliente, int codigoEmpleado, String numeroSerie, String descripcionProd, int codProducto, String fecha, double precio, int cantidad, double subTotal, double monto, String estado) {
        this.codigoVenta = codigoVenta;
        this.item = item;
        this.codigoCliente = codigoCliente;
        this.codigoEmpleado = codigoEmpleado;
        this.numeroSerie = numeroSerie;
        this.descripcionProd = descripcionProd;
        this.codProducto = codProducto;
        this.fecha = fecha;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
        this.monto = monto;
        this.estado = estado;
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getDescripcionProd() {
        return descripcionProd;
    }

    public void setDescripcionProd(String descripcionProd) {
        this.descripcionProd = descripcionProd;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
