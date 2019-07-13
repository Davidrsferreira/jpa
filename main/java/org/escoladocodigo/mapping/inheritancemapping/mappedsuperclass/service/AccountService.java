package org.escoladocodigo.mapping.inheritancemapping.mappedsuperclass.service;

import org.escoladocodigo.mapping.inheritancemapping.mappedsuperclass.model.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class AccountService {

    private EntityManagerFactory emf;

    public AccountService(){
        emf = Persistence.createEntityManagerFactory("test");
    }

    public Account findById(Integer id) {

        // open a new connection to the database
        EntityManager em = emf.createEntityManager();

        try {
            // fetch a new user using its id
            return em.find(Account.class, id); // always the primary key
        } finally {
            // make sure we close the database connection
            if (em != null) {
                em.close();
            }
        }
    }

    public Account saveOrUpdate(Account account) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin(); // open transaction
            Account savedAccount= em.merge(account);
            em.getTransaction().commit(); // close transaction
            return savedAccount;

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
