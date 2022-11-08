package edu.ijse.semester.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("/customer/info/{nic}")
    public String  getCustomerName(@PathVariable String nic){
        return "hi am chamod" +nic;
    }
}
