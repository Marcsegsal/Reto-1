public class Peticion {
    private int id;
    private String usuario;
    private String descripcion;
    private String fecha;
    private int idCategoria;

    Peticion(int id, String usuario, String descripcion, String categoria, String fecha, int idCategoria) {
        this.id = id;
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.idCategoria = idCategoria;
    }

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
}
