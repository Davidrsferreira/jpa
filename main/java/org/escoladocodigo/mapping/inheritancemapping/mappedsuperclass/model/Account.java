package org.escoladocodigo.mapping.inheritancemapping.mappedsuperclass.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "account")
public class Account extends AbstractModel {

    private Double balance;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
