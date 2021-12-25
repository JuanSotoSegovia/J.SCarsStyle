package Object_Class;

public class Exterior {

    private int[] id = {5,6,7,8,9,10,11,12,13,22};
    private String[] nombreExterior = {"Antena modelo aleta de tiburon blanca.","Antena modelo aleta de tiburon negra.",
            "Broche parachoque mediano metalico.","Cinta remolque azul tuning.","Cinta remolque roja tuning.","Gancho remolque recto negro.",
            "Gancho remolque recto rojo.","Guarda fangos de goma 4pzs.","Lip parachoque frontal.","Broche parachoque grande metalico."};
    private int[] precioExterior = {5000, 5000, 4500, 5000, 5000, 9000, 9000, 10000, 8000, 5500};
    private int[] comision = {1260, 1260, 1560, 1740, 1740, 2100, 2100, 3240, 2700, 2350};
    private String[] detalleExterior = {"Antena modelo aleta de tiburon funcional, color blanco.","Antena modelo aleta de tiburon funcional, color negro.",
            "Broche sujeta parachoque metalico mediano, color negro.","Cinta para remolque tuning, colo azul.","Cinta para remolque tuning, color rojo.",
            "Gancho para remolque recto, color negro.","Gancho para remolque recto, color rojo.","Guarda fangos de goma, color negro, 2pzs/4pzs",
            "Lip para parachoque frontal, marca samurai, modelo fibra de carbono.","Broche sujeta parachoque metalico grande, color negro."};
    private int[] calificcion = {5,5,5,5,5,5,5,5,5,5};

    public Exterior(){

    }

    public Exterior(int[] id, String[] nombreExterior, int[] precioExterior, int[] comision, String[] detalleExterior, int[] calificcion) {
        this.id = id;
        this.nombreExterior = nombreExterior;
        this.precioExterior = precioExterior;
        this.comision = comision;
        this.detalleExterior = detalleExterior;
        this.calificcion = calificcion;
    }

    public int[] getComision() {
        return comision;
    }

    public void setComision(int[] comision) {
        this.comision = comision;
    }

    public int[] getId() {
        return id;
    }

    public void setId(int[] id) {
        this.id = id;
    }

    public String[] getNombreExterior() {
        return nombreExterior;
    }

    public void setNombreExterior(String[] nombreExterior) {
        this.nombreExterior = nombreExterior;
    }

    public int[] getPrecioExterior() {
        return precioExterior;
    }

    public void setPrecioExterior(int[] precioExterior) {
        this.precioExterior = precioExterior;
    }

    public String[] getDetalleExterior() {
        return detalleExterior;
    }

    public void setDetalleExterior(String[] detalleExterior) {
        this.detalleExterior = detalleExterior;
    }

    public int[] getCalificcion() {
        return calificcion;
    }

    public void setCalificcion(int[] calificcion) {
        this.calificcion = calificcion;
    }

}
