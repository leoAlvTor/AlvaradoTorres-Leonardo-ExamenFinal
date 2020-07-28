package ec.edu.ups.controlador;


import ec.edu.ups.ejb.CitaMedicaFacade;
import ec.edu.ups.ejb.PacienteFacade;
import ec.edu.ups.entidad.CitaMedica;
import ec.edu.ups.entidad.Paciente;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class CitaMedicaEJB implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private PacienteFacade pacienteFacade;

    @EJB
    private CitaMedicaFacade citaMedicaFacade;

    private Paciente paciente;

    private String nombre_paciente;
    private String telefono_paciente;
    private String direccion_paciente;
    private String correo_paciente;
    private String cedula;

    private String fecha;
    private String hora;
    private String fraccion_hora;


    private String mensajes;

    @PostConstruct
    public void init(){

    }

    public String getNombre_paciente() {
        return nombre_paciente;
    }

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono_paciente() {
        return telefono_paciente;
    }

    public void setTelefono_paciente(String telefono_paciente) {
        this.telefono_paciente = telefono_paciente;
    }

    public String getDireccion_paciente() {
        return direccion_paciente;
    }

    public void setDireccion_paciente(String direccion_paciente) {
        this.direccion_paciente = direccion_paciente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCorreo_paciente() {
        return correo_paciente;
    }

    public void setCorreo_paciente(String correo_paciente) {
        this.correo_paciente = correo_paciente;
    }

    public String getMensajes(){
        return this.mensajes;
    }

    public String getFraccion_hora() {
        return fraccion_hora;
    }

    public void setFraccion_hora(String fraccion_hora) {
        this.fraccion_hora = fraccion_hora;
    }

    public void crearPacientes(){
        Paciente paciente = new Paciente("0105652747", "Leo", "Alvarado", "0979395837", "Checa", "torresleonardo@outlook.com", null);
        Paciente paciente1 = new Paciente("0101130862", "Daniel", "Torres", "072897510", "Miguel Velez", "daniel@outlook.com", null);
        Paciente paciente2 = new Paciente("0101240612", "Renata", "Pauta", "0988847177", "Pio Bravo", "renata@outlook.com", null);

        pacienteFacade.create(paciente);
        pacienteFacade.create(paciente1);
        pacienteFacade.create(paciente2);

    }

    public void buscarPaciente(){
        paciente = pacienteFacade.find(cedula);
        if(paciente != null){
        nombre_paciente = paciente.getNombre();
        correo_paciente = paciente.getCorreo();
        telefono_paciente = paciente.getTelefono();
        direccion_paciente = paciente.getDireccion();
        }
    }

    public void crearCita(){
      //  crearPacientes();
        if(!verificarFechaHora()){
            Paciente paciente = pacienteFacade.find(cedula);
            if(paciente != null) {
                citaMedicaFacade.create(new CitaMedica(getFechaFromString(fecha), Integer.parseInt(hora), Integer.parseInt(fraccion_hora), paciente, null));
                mensajes = "Cita creada correctamente!";
            }else{
                mensajes = "ERROR!";
            }
        }else{
            mensajes = "La fecha / hora seleccionada ya tiene una cita asignada.";
        }
    }

    private boolean errorCitaMedica = false;
    private boolean verificarFechaHora(){
       List<CitaMedica> citaMedicaList = citaMedicaFacade.findAll();

       citaMedicaList.forEach(e->{
          if(e.getFechaCita().equals(getFechaFromString(fecha)) && e.getHora() == Integer.parseInt(hora)) {
              errorCitaMedica = true;
          }else{
              errorCitaMedica = false;
          }
       });
       return errorCitaMedica;
    }

    private void verificarHoraActual(){
        int hour  = LocalDateTime.now().getHour();
        int minute = LocalDateTime.now().getMinute();

        int frac_hora = Integer.parseInt(fraccion_hora);
        if(frac_hora == 1) frac_hora = 0;
        else if(frac_hora == 2) frac_hora = 30;

        int diferencia = minute - frac_hora;

    }

    private GregorianCalendar getFechaFromString(String fecha){
        try {
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.setTime(new SimpleDateFormat("dd-MM-yyyy").parse(fecha));
            return (GregorianCalendar) calendar;
        }catch (Exception e){
            e.printStackTrace();
            return new GregorianCalendar();
        }
    }


}
