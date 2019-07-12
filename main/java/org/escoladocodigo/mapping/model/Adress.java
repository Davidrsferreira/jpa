package org.escoladocodigo.mapping.model;

import javax.persistence.Embeddable;

@Embeddable
public class Adress {

    private String street;
    private String city;
    private String zipcode;

    public Adress(){}

    public Adress(String street, String city, String zipcode){
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
    }

}
