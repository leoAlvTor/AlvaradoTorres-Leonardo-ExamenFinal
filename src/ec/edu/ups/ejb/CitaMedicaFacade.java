package ec.edu.ups.ejb;

import ec.edu.ups.entidad.CitaMedica;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CitaMedicaFacade extends AbstractFacade<CitaMedica>{

    @PersistenceContext(unitName = "examen")
    private EntityManager entityManager;

    public CitaMedicaFacade(){
        super(CitaMedica.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return null;
    }
}
