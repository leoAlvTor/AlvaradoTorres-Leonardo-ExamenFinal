package ec.edu.ups.ejb;

import ec.edu.ups.entidad.SignoVitales;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SignoVitalesFacade extends AbstractFacade<SignoVitales>{

    @PersistenceContext(unitName = "examen")
    private EntityManager entityManager;

    public SignoVitalesFacade(){
        super(SignoVitales.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return null;
    }
}
