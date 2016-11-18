package DAO;

import Service.APIService;

import javax.persistence.EntityManager;

/**
 * Created by p1317074 on 19/10/16.
 */
public class DAO {

    protected EntityManager em;

    public DAO() {
    }

    public EntityManager getEntityManager(){
        if (em == null || !em.isOpen()){
            em = APIService.getEntityManagerFactory().createEntityManager();
        }
        return em;
    }

    public void closeEntityManager(){
        if (em.isOpen()){
            em.close();
        }
    }
}
