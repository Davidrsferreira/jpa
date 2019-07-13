package org.escoladocodigo.mapping.inheritancemapping.mappedsuperclass.service;

import org.escoladocodigo.mapping.inheritancemapping.mappedsuperclass.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class CustomerService {

    private EntityManagerFactory emf;

    public CustomerService(){
        emf = Persistence.createEntityManagerFactory("test");
    }

    public Customer findById(Integer id) {

        // open a new connection to the database
        EntityManager em = emf.createEntityManager();

        try {
            // fetch a new user using its id
            return em.find(Customer.class, id); // always the primary key
        } finally {
            // make sure we close the database connection
            if (em != null) {
                em.close();
            }
        }
    }

    public Customer saveOrUpdate(Customer customer) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin(); // open transaction
            Customer savedCustomer = em.merge(customer);
            em.getTransaction().commit(); // close transaction
            return savedCustomer;

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
