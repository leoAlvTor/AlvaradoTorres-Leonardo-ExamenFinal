package ec.edu.ups.ejb;

import ec.edu.ups.entidad.SignoVitales;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SignoVitalesFacade extends AbstractFacade<SignoVitales>{

    @PersistenceContext(unitName = "ExamenFinal")
    private EntityManager entityManager;

    public SignoVitalesFacade(){
        super(SignoVitales.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
