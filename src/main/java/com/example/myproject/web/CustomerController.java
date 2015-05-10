package com.example.myproject.web;

import com.example.myproject.domain.Customer;
import com.example.myproject.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/count")
    @ResponseBody
    long getEmail() {
        LOGGER.debug("Getting email");

        long count = customerService.count();
        return count;
    }

    @RequestMapping("/hello")
    @ResponseBody
    String home() {
        LOGGER.debug("Getting home page");
        return "Hello World!";
    }

    @RequestMapping(value = "/customer/create", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    Customer createCustomer(@RequestBody Customer customer) {
        LOGGER.debug("creating customer!");


        return customerService.create(customer);
    }

    @RequestMapping(value = "/email", method = RequestMethod.GET)
    @ResponseBody
    Boolean checkEmail(@RequestParam("email") String email) {
        LOGGER.debug("Getting email");

        Boolean count = customerService.isEmailAvailable(email);
        return count;
    }




}
