package ec.edu.ups.entidad;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class SignoVitales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    private String descripcion;

    private String presion;

    private int frecuenciaCardiaca;

    private String frecuenciaRespiratoria;

    private double temperatura;

    @OneToOne
    private CitaMedica citaMedica;

    public SignoVitales(){}

    public SignoVitales(int codigo, String descripcion, String presion, int frecuenciaCardiaca,
                        String frecuenciaRespiratoria, double temperatura, CitaMedica citaMedica) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.presion = presion;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
        this.temperatura = temperatura;
        this.citaMedica = citaMedica;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPresion() {
        return presion;
    }

    public void setPresion(String presion) {
        this.presion = presion;
    }

    public int getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(int frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public String getFrecuenciaRespiratoria() {
        return frecuenciaRespiratoria;
    }

    public void setFrecuenciaRespiratoria(String frecuenciaRespiratoria) {
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public CitaMedica getCitaMedica() {
        return citaMedica;
    }

    public void setCitaMedica(CitaMedica citaMedica) {
        this.citaMedica = citaMedica;
    }

    @Override
    public String toString() {
        return "SignoVitales{" +
                "codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", presion='" + presion + '\'' +
                ", frecuenciaCardiaca=" + frecuenciaCardiaca +
                ", frecuenciaRespiratoria='" + frecuenciaRespiratoria + '\'' +
                ", temperatura=" + temperatura +
                ", citaMedica=" + citaMedica +
                '}';
    }
}
