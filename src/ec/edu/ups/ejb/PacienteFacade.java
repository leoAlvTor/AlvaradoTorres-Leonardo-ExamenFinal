package ec.edu.ups.ejb;

import ec.edu.ups.entidad.Paciente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PacienteFacade extends AbstractFacade<Paciente>{

    @PersistenceContext(unitName = "examen")
    private EntityManager entityManager;

    public PacienteFacade(){
        super(Paciente.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return null;
    }
}
