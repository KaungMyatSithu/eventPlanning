package org.ace.eventplanning.service;



import org.ace.eventplanning.entity.Customer;

import java.util.List;

public interface CustomerService {
    //Find All Method
    List<Customer> findAllCustomer();




    //Register Method
    void registerCustomer(Customer customer);




    //Find By ID Method
    Customer findByCustomerID(long customerID);



    //Delete Method
    void deleteCustomer(long customerID);


    //Update Method
    Customer updateCustomer(long customerID, Customer updateCustomerData);
}
