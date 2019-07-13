package org.escoladocodigo.mapping.inheritancemapping.joinedtable.service;

import org.escoladocodigo.mapping.inheritancemapping.joinedtable.model.Boat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class BoatService {

    private EntityManagerFactory emf;

    public BoatService(){
        emf = Persistence.createEntityManagerFactory("test");
    }

    public Boat findById(Integer id) {

        // open a new connection to the database
        EntityManager em = emf.createEntityManager();

        try {
            // fetch a new user using its id
            return em.find(Boat.class, id); // always the primary key
        } finally {
            // make sure we close the database connection
            if (em != null) {
                em.close();
            }
        }
    }

    public Boat saveOrUpdate(Boat boat) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin(); // open transaction
            Boat savedBoat = em.merge(boat);
            em.getTransaction().commit(); // close transaction
            return savedBoat;

        } catch (RollbackException ex) {

            // something went wrong, make sure db is consistent
            em.getTransaction().rollback();
            return null;

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void close(){

        if (emf != null){
            emf.close();
        }
    }
}
