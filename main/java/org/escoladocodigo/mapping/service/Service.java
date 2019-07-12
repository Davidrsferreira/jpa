package org.escoladocodigo.mapping.service;

import org.escoladocodigo.mapping.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class Service {

    private EntityManagerFactory emf;

    public Service(){
        emf = Persistence.createEntityManagerFactory("test");
    }

    public Student findById(Integer id) {

        // open a new connection to the database
        EntityManager em = emf.createEntityManager();

        try {
            // fetch a new user using its id
            return em.find(Student.class, id); // always the primary key
        } finally {
            // make sure we close the database connection
            if (em != null) {
                em.close();
            }
        }
    }

    public Student saveOrUpdate(Student student) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin(); // open transaction
            Student savedStudent= em.merge(student);
            em.getTransaction().commit(); // close transaction
            return savedStudent;

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
        emf.close();
    }
}
