package org.ace.eventplanning.controller;

import lombok.AllArgsConstructor;
import org.ace.eventplanning.entity.Customer;
import org.ace.eventplanning.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping
    public ResponseEntity<Customer> registerCustomer (@RequestBody Customer customer){
        customerService.registerCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> findAllCustomer (){
        List<Customer> customerList = customerService.findAllCustomer();
        return new ResponseEntity<>(customerList,HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCustomer(@RequestParam long customerID){
        customerService.deleteCustomer(customerID);
        return new ResponseEntity<>("Deleted",HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{customerID}")
    public ResponseEntity<Customer> findCustomerID (@PathVariable long customerID){
        Customer customer = customerService.findByCustomerID(customerID);
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/{customerID}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerID, @RequestBody Customer updatedCustomerData) {
        Customer updatedCustomer = customerService.updateCustomer(customerID, updatedCustomerData);

        if (updatedCustomer != null) {
            return ResponseEntity.ok(updatedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
