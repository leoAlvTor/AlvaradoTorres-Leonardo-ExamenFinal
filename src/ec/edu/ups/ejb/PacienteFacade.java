package ec.edu.ups.ejb;

import ec.edu.ups.entidad.Paciente;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PacienteFacade extends AbstractFacade<Paciente>{

    @PersistenceContext(unitName = "ExamenFinal")
    private EntityManager entityManager;

    public PacienteFacade(){
        super(Paciente.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
