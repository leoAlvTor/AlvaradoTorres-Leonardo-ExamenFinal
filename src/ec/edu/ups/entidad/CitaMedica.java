package ec.edu.ups.entidad;

import javax.persistence.*;

@Entity
public class CitaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo;

    @ManyToOne
    private Paciente paciente;

    @OneToOne(mappedBy = "citaMedica")
    private SignoVitales signoVitales;

}
