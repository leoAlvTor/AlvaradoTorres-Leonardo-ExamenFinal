package ec.edu.ups.entidad;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.Objects;

@Entity
public class CitaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo;

    @Temporal(TemporalType.DATE)
    private GregorianCalendar fechaCita;

    private int hora;

    private int fraccionHora;

    @ManyToOne
    @JoinColumn
    private Paciente paciente;

    @OneToOne(mappedBy = "citaMedica")
    private SignoVitales signoVitales;

    public CitaMedica(){}

    public CitaMedica(GregorianCalendar fechaCita, int hora, int fraccionHora, Paciente paciente, SignoVitales signoVitales) {
        this.fechaCita = fechaCita;
        this.hora = hora;
        this.fraccionHora = fraccionHora;
        this.paciente = paciente;
        this.signoVitales = signoVitales;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public GregorianCalendar getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(GregorianCalendar fechaCita) {
        this.fechaCita = fechaCita;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getFraccionHora() {
        return fraccionHora;
    }

    public void setFraccionHora(int fraccionHora) {
        this.fraccionHora = fraccionHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public SignoVitales getSignoVitales() {
        return signoVitales;
    }

    public void setSignoVitales(SignoVitales signoVitales) {
        this.signoVitales = signoVitales;
    }

    @Override
    public String toString() {
        return "CitaMedica{" +
                "codigo=" + codigo +
                ", fechaCita=" + fechaCita +
                ", hora=" + hora +
                ", fraccionHora=" + fraccionHora +
                ", paciente=" + paciente +
                ", signoVitales=" + signoVitales +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CitaMedica)) return false;
        CitaMedica that = (CitaMedica) o;
        return codigo == that.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
