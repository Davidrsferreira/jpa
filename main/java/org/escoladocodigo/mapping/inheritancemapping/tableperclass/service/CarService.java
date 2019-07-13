package org.escoladocodigo.mapping.inheritancemapping.tableperclass.service;

import org.escoladocodigo.mapping.inheritancemapping.tableperclass.model.Car;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class CarService {

    private EntityManagerFactory emf;

    public CarService(){
        emf = Persistence.createEntityManagerFactory("test");
    }

    public Car findById(Integer id) {

        // open a new connection to the database
        EntityManager em = emf.createEntityManager();

        try {
            // fetch a new user using its id
            return em.find(Car.class, id); // always the primary key
        } finally {
            // make sure we close the database connection
            if (em != null) {
                em.close();
            }
        }
    }

    public Car saveOrUpdate(Car car) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin(); // open transaction
            Car savedCar= em.merge(car);
            em.getTransaction().commit(); // close transaction
            return savedCar;

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
