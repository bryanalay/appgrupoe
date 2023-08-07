package Modelo.DTO;

/**
 *
 * @author Almi-
 */
public class Factura {
    private int id;
    private int idEnvio;
    private String ruc;
    private String ciDestino;
    private String direccion;
    private String detalles;
    private String total;

    // Constructor
    public Factura(int id, int idEnvio, String ruc, String ciDestino, String direccion, String detalles, String total) {
        this.id = id;
        this.idEnvio = idEnvio;
        this.ruc = ruc;
        this.ciDestino = ciDestino;
        this.direccion = direccion;
        this.detalles = detalles;
        this.total = total;
    }

    public Factura() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(int idEnvio) {
        this.idEnvio = idEnvio;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getCiDestino() {
        return ciDestino;
    }

    public void setCiDestino(String ciDestino) {
        this.ciDestino = ciDestino;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
