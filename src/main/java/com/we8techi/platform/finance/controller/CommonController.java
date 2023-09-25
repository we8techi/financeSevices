package com.we8techi.platform.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.we8techi.platform.finance.entity.Customer;
import com.we8techi.platform.finance.repository.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CommonController {
    @Autowired
    private CustomerRepository customerRepo;

     @GetMapping("/status")
   public String getCustomerCount(){
        String msg ="Database Configuration Done..Connected to Postgres..Total Customer Count from DB : ";
        int count = this.getAllCustomer().size();
        return msg+count;
    }

    @GetMapping("/findAll")
   public List<Customer> getAllCustomer(){
        return customerRepo.findAll();
    }

    @PostMapping("/insert")
    public Customer insert(@RequestBody Customer cutomer){
        return customerRepo.save(cutomer);
    }
}