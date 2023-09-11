package com.vbtech.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vbtech.finance.entity.Customer;
import com.vbtech.finance.repository.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CommonController {
    @Autowired
    private CustomerRepository studentRepo;

    @GetMapping("/findAll")
   public List<Customer> getAllStudent(){
        return studentRepo.findAll();
    }

    @PostMapping("/insert")
    public Customer insert(@RequestBody Customer cutomer){
        return studentRepo.save(cutomer);
    }
}