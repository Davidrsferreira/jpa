package org.escoladocodigo.associations.onetoone.service;

import org.escoladocodigo.associations.onetoone.model.Owner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class Service {

    private EntityManagerFactory emf;

    public Service(){
        emf = Persistence.createEntityManagerFactory("test");
    }

    public Owner findById(Integer id) {

        // open a new connection to the database
        EntityManager em = emf.createEntityManager();

        try {
            // fetch a new user using its id
            return em.find(Owner.class, id); // always the primary key
        } finally {
            // make sure we close the database connection
            if (em != null) {
                em.close();
            }
        }
    }

    public Owner saveOrUpdate(Owner owner) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin(); // open transaction
            Owner savedOwner= em.merge(owner);
            em.getTransaction().commit(); // close transaction
            return savedOwner;

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

    public void remove(int id) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin(); // open transaction
            Owner owner = em.find(Owner.class, id);
            em.remove(owner);
            em.getTransaction().commit(); // close transaction

        } catch (RollbackException ex) {

            // something went wrong, make sure db is consistent
            em.getTransaction().rollback();

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
