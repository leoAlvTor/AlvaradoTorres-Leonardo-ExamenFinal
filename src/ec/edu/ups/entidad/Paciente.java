package ec.edu.ups.entidad;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Paciente {

    @Id
    private String cedula;

    private String nombre;

    private String apellido;

    private String telefono;

    private String direccion;

    private String correo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private List<CitaMedica> citaMedica;

    public Paciente(){}

    public Paciente(String cedula, String nombre, String apellido, String telefono,
                    String direccion, String correo, List<CitaMedica> citaMedica) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.citaMedica = citaMedica;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public List<CitaMedica> getCitaMedica() {
        return citaMedica;
    }

    public void setCitaMedica(List<CitaMedica> citaMedica) {
        this.citaMedica = citaMedica;
    }

    public void addCita(CitaMedica citaMedica){
        this.citaMedica.add(citaMedica);
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", correo='" + correo + '\'' +
                ", citaMedica=" + citaMedica +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paciente)) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(cedula, paciente.cedula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula);
    }
}
