package org.ace.eventplanning.service.impl;


import lombok.AllArgsConstructor;
import org.ace.eventplanning.entity.Customer;
import org.ace.eventplanning.repo.CustomerRepo;
import org.ace.eventplanning.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    @Override
    public List<Customer> findAllCustomer() {
        return customerRepo.findAll();
    }

    @Override
    public void registerCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public Customer findByCustomerID(long customerID) {
        return customerRepo.findById(customerID).orElseThrow(() -> new RuntimeException("Invalid ID" + customerID));
    }

    @Override
    public void deleteCustomer(long customerID) {
        if (customerRepo.existsById(customerID));
        customerRepo.deleteById(customerID);
    }

    @Override
    public Customer updateCustomer(long customerID, Customer updateCustomerData) {
        Optional<Customer> optionalCustomer = customerRepo.findById(customerID);
        if (optionalCustomer.isPresent()) {
            Customer existingCustomer = optionalCustomer.get();
            existingCustomer.setCustomerName(updateCustomerData.getCustomerName());
            existingCustomer.setCustomerAge(updateCustomerData.getCustomerAge());
            existingCustomer.setCustomerAddress(updateCustomerData.getCustomerAddress());
            existingCustomer.setCustomerEmail(updateCustomerData.getCustomerEmail());
            existingCustomer.setCustomerPassword(updateCustomerData.getCustomerPassword());
            return customerRepo.save(existingCustomer);
        } else {
            return null;
        }
    }
}
