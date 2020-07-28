package ec.edu.ups.ejb;

import ec.edu.ups.entidad.CitaMedica;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CitaMedicaFacade extends AbstractFacade<CitaMedica>{

    @PersistenceContext(unitName = "ExamenFinal")
    private EntityManager entityManager;

    public CitaMedicaFacade(){
        super(CitaMedica.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
