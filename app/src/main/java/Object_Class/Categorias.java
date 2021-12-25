package Object_Class;

public class Categorias {

    private int id;
    private String[] nombreCategorias = {"Escape","Exterior","Iluminacion","Reparaciones"};

    public Categorias (){

    }

    public Categorias(int id, String[] nombreCategorias) {
        this.id = id;
        this.nombreCategorias = nombreCategorias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getNombreCategorias() {
        return nombreCategorias;
    }

    public void setNombreCategorias(String[] nombreCategorias) {
        this.nombreCategorias = nombreCategorias;
    }
}
