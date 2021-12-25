package Object_Class;

public class Ventas {

    private String Uid;
    private String id;
    private String fecha;
    private String producto;
    private String idProducto;
    private String precio;
    private String comision;
    private String catidad;
    private String totalPrecio;
    private String totalComision;
    private String vendedor;

    public Ventas() {

    }

    public Ventas(String uid, String id, String fecha, String producto, String idProducto, String precio, String comision, String catidad, String totalPrecio, String totalComision, String vendedor) {
        Uid = uid;
        this.id = id;
        this.fecha = fecha;
        this.producto = producto;
        this.idProducto = idProducto;
        this.precio = precio;
        this.comision = comision;
        this.catidad = catidad;
        this.totalPrecio = totalPrecio;
        this.totalComision = totalComision;
        this.vendedor = vendedor;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getComision() {
        return comision;
    }

    public void setComision(String comision) {
        this.comision = comision;
    }

    public String getCatidad() {
        return catidad;
    }

    public void setCatidad(String catidad) {
        this.catidad = catidad;
    }

    public String getTotalPrecio() {
        return totalPrecio;
    }

    public void setTotalPrecio(String totalPrecio) {
        this.totalPrecio = totalPrecio;
    }

    public String getTotalComision() {
        return totalComision;
    }

    public void setTotalComision(String totalComision) {
        this.totalComision = totalComision;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    //ver estructura
    @Override
    public String toString() {
        return "ID venta: " + id + "\nProducto: " + producto
                + "\nCantidad: " + catidad + "\nTotal Venta: " + totalPrecio + "\nTotal Comision: "
                + totalComision + "\nFecha: " + fecha + "\n";
    }
}
