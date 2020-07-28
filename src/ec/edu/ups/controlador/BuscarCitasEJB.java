package ec.edu.ups.controlador;

import ec.edu.ups.ejb.CitaMedicaFacade;
import ec.edu.ups.ejb.PacienteFacade;
import ec.edu.ups.entidad.CitaMedica;
import ec.edu.ups.entidad.Paciente;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import java.io.Serializable;
import java.text.SimpleDateFormat;


@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class BuscarCitasEJB implements Serializable {

    private Paciente paciente = new Paciente();

    private CitaMedica cita = new CitaMedica();

    @EJB
    private CitaMedicaFacade citaMedicaFacade;

    @EJB
    private PacienteFacade pacienteFacade;

    @PostConstruct
    public void init(){

    }

    private String cita_id, paciente_id, fecha;

    public String getCita_id() {
        return cita_id;
    }

    public void setCita_id(String cita_id) {
        this.cita_id = cita_id;
    }

    public String getPaciente_id() {
        return paciente_id;
    }

    public void setPaciente_id(String paciente_id) {
        this.paciente_id = paciente_id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public CitaMedica getCita() {
        return cita;
    }

    public void setCita(CitaMedica cita) {
        this.cita = cita;
    }

    public String getFecha(){
        return this.fecha;
    }

    public void buscarCita(){


        cita = citaMedicaFacade.find(Integer.parseInt(cita_id));
        paciente = pacienteFacade.find(paciente_id);

        if(!cita.getPaciente().getCedula().equals(paciente_id)){
            cita = new CitaMedica();
            paciente = new Paciente();
        }else {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            format.setCalendar(cita.getFechaCita());
            fecha = format.format(cita.getFechaCita().getTime());
        }
    }

}
