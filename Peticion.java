public class Peticion {
    int id;
    String usuario;
    String descripcion;
    String categoria;
    int[] fecha;
    int idCategoria;

    Peticion(int id, String usuario, String descripcion, String categoria, int[] fecha, int idCategoria) {
        this.id = id;
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.fecha = fecha;
        this.idCategoria = idCategoria;
    }
}
