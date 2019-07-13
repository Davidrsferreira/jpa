package org.escoladocodigo.mapping.inheritancemapping.mappedsuperclass;

import org.escoladocodigo.mapping.inheritancemapping.mappedsuperclass.model.Account;
import org.escoladocodigo.mapping.inheritancemapping.mappedsuperclass.model.Customer;
import org.escoladocodigo.mapping.inheritancemapping.mappedsuperclass.service.AccountService;
import org.escoladocodigo.mapping.inheritancemapping.mappedsuperclass.service.CustomerService;

public class Main {

    public static void main(String[] args) {

        Account account = new Account();
        Customer customer = new Customer();
        AccountService accountService = new AccountService();
        CustomerService customerService = new CustomerService();

        account.setBalance(25.0);
        customer.setName("David");

        accountService.saveOrUpdate(account);
        customerService.saveOrUpdate(customer);

        accountService.close();
        customerService.close();

    }
}
