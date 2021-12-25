package Object_Class;

public class Stock {
    private String Uid;
    private String id;
    private String nombreProducto;
    private String stock;

    public Stock() {
    }

    public Stock(String uid, String id, String nombreProducto, String stock) {
        Uid = uid;
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.stock = stock;
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

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nProducto: " + nombreProducto + "\nStock: " + stock + "\n";
    }
}
