package Object_Class;

public class Productos {

    private String[] producto = {"Cola escape doble modelo 407.", "Cola escape modelo 146.", "Cola escape modelo 233.",
        "Cola escape modelo A-2.", "Antena modelo aleta de tiburon blanca.", "Antena modelo aleta de tiburon negra.",
        "Broche parachoque mediano metalico.", "Cinta remolque azul tuning.", "Cinta remolque roja tuning.",
        "Gancho remolque recto negro.", "Gancho remolque recto rojo.", "Guarda fangos de goma 4pzs.",
        "Lip parachoque frontal.", "Broche parachoque grande metalico.", "Cinta remolque pegable negra tuning.",
        "Cinta remolque pegable rojo tuning.", "Ampolleta halogena golden modelo 880.", "Ampolleta halogena golden modelo 9006.",
        "Ampolleta LED T10 modelo diamante.", "Ampolleta LED T10 RGB + control remoto.", "Cinta LED para focos sobre puesta bi-funcional.",
        "Ojos de aguila LED.", "Tercera luz de freno triangular.", "Ampolleta halogena golden modelo H4.",
        "Neblinero led golden 60W", "Kit cierre centralizado 4 puertas."};

    private String[] id = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "22", "25", "26", "14",
        "15", "16", "17", "18", "19", "20", "23", "24", "21"};

    private String[] precio = {"15000", "10000", "8000", "9000", "5000", "5000", "4500", "5000", "5000", "9000", "9000",
        "10000", "8000", "5500", "4000", "4000", "7000", "8000", "2000", "4500", "10000", "4500", "4500", "7000", "19000",
        "10000"};

    private String[] comision = {"4260", "4200", "3480", "4080", "1260", "1260", "156", "1740", "1740", "2100", "2100",
        "3240", "2700", "2350", "1080", "1080", "2400", "2640", "750", "1650", "2100", "1560", "1320", "2880", "3960", "1800"};

    public Productos() {

    }

    public Productos(String[] producto, String[] id, String[] precio, String[] comision) {
        this.producto = producto;
        this.id = id;
        this.precio = precio;
        this.comision = comision;
    }

    public String[] getProducto() {
        return producto;
    }

    public void setProducto(String[] producto) {
        this.producto = producto;
    }

    public String[] getId() {
        return id;
    }

    public void setId(String[] id) {
        this.id = id;
    }

    public String[] getPrecio() {
        return precio;
    }

    public void setPrecio(String[] precio) {
        this.precio = precio;
    }

    public String[] getComision() {
        return comision;
    }

    public void setComision(String[] comision) {
        this.comision = comision;
    }
}
