package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VentaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    int num;
    String numSerie;
    
    public String numeroSerie(int num) {
        this.num = num + 1;
        if ((this.num >= 1000000) && (this.num <= 10000000)) {
            numSerie = "" + this.num;
        }
        if ((this.num >= 100000) && (this.num <= 1000000)) {
            numSerie = "0" + this.num;
        }
        if ((this.num >= 10000) && (this.num <= 100000)) {
            numSerie = "00" + this.num;
        }
        if ((this.num >= 1000) && (this.num <= 10000)) {
            numSerie = "000" + this.num;
        }
        if ((this.num >= 100) && (this.num <= 1000)) {
            numSerie = "0000" + this.num;
        }
        if ((this.num >= 10) && (this.num <= 100)) {
            numSerie = "00000" + this.num;
        }
        if (this.num < 10) {
            numSerie = "000000" + this.num;
        }
        
        return this.numSerie;
    }
    
    public String generarNumSerie() {
        String numSerie="";
        String sql = "select max(numeroSerie) from venta";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                numSerie = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numSerie; 
    }
    
    public String codigoVenta() {
        String codVenta = "";
        String sql = "select max(codigoVenta) from venta";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                codVenta = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return codVenta;
    }
    
    public int guardarVenta(Venta v) {
        String sql = "insert into Venta (numeroSerie, fechaVenta, monto, estado, codigoCliente, codigoEmpleado) values(?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getNumeroSerie());
            ps.setString(2, v.getFecha());
            ps.setDouble(3, v.getMonto());
            ps.setString(4, v.getEstado());
            ps.setInt(5, v.getCodigoCliente());
            ps.setInt(6, v.getCodigoEmpleado());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    public int guardarDetalleVenta(Venta ven) {
        String sql = "insert into DetalleVenta (codigoProducto, cantidad, precioVenta, codigoVenta) values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ven.getCodProducto());
            ps.setInt(2, ven.getCantidad());
            ps.setDouble(3, ven.getPrecio());
            ps.setInt(4, ven.getCodigoVenta());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
}
