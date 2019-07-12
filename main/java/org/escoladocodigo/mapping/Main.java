package org.escoladocodigo.mapping;

import org.escoladocodigo.mapping.model.Adress;
import org.escoladocodigo.mapping.model.Student;
import org.escoladocodigo.mapping.service.Service;

public class Main {

    public static void main(String[] args) {

        Service service = new Service();

        Adress adress = new Adress("Bonjoia", "Porto", "4000");
        Student student = new Student();

        student.setName("David");
        student.setAdress(adress);

        student = service.saveOrUpdate(student);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        student.setName("teste");
        service.saveOrUpdate(student);
        service.close();

    }

}
