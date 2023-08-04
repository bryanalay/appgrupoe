package Modelo.DTO;

/**
 *
 * @author Almi-
 */
public class Vehiculo {
    String matricula;
    String marca;
    String anio;
    String tipo;
    String dispon;

    public Vehiculo(String matricula, String marca, String anio, String tipo, String dispon) {
        this.matricula = matricula;
        this.marca = marca;
        this.anio = anio;
        this.tipo = tipo;
        this.dispon = dispon;
    }

    public Vehiculo() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }   

    public String getDispon() {
        return dispon;
    }

    public void setDispon(String dispon) {
        this.dispon = dispon;
    }
    
}
