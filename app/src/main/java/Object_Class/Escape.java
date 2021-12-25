package Object_Class;

public class Escape {

    private int[] id = {1,2,3,4};
    private String[] nombreEscape = {"Cola escape doble modelo 407.","Cola escape modelo 146.","Cola escape modelo 233.",
            "Cola escape modelo A-2."};
    private int[] precioEscape = {15000, 10000, 8000, 9000};
    private int[] comision = {4260, 4200, 3480, 4080};
    private String[] detalleEscape = {"Cola de escape salida doble cromada, modelo 407, entrada recta.","Cola de escape cromada, modelo 146, entrada recta.",
            "Cola de escape cromada, modelo 233, entrada recta.","Cola de escape cromada, modelo A-2, entrada recta."};
    private int[] calificacion = {5,5,5,5};

    public Escape(){

    }

    public Escape(int[] id, String[] nombreEscape, int[] precioEscape, int[] comision, String[] detalleEscape, int[] calificacion) {
        this.id = id;
        this.nombreEscape = nombreEscape;
        this.precioEscape = precioEscape;
        this.comision = comision;
        this.detalleEscape = detalleEscape;
        this.calificacion = calificacion;
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

    public String[] getNombreEscape() {
        return nombreEscape;
    }

    public void setNombreEscape(String[] nombreEscape) {
        this.nombreEscape = nombreEscape;
    }

    public int[] getPrecioEscape() {
        return precioEscape;
    }

    public void setPrecioEscape(int[] precioEscape) {
        this.precioEscape = precioEscape;
    }

    public String[] getDetalleEscape() {
        return detalleEscape;
    }

    public void setDetalleEscape(String[] detalleEscape) {
        this.detalleEscape = detalleEscape;
    }

    public int[] getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int[] calificacion) {
        this.calificacion = calificacion;
    }
}
