package com.example.myproject.web;

import com.example.myproject.domain.Customer;
import com.example.myproject.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// Customer controller exposing api for customer, sa anotacijom @controller klasa, ako se dobro sjecam, prima HttpServletRequest i
// HttpServletResponse, te na taj nacina zadrzava kontrolu toka (IOC principle), upravlja zivotnim ciklusom bean-a itd., za razliku
//od pristupa di bi implementacija imala kontrolu u smislu da bi pitala nekakav middleware za request objekt te dalje obradjivala podatke
@Controller
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;

    // constructor injection, jedna od nacina za inject-at dependency uz setter injection
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/count")
    @ResponseBody
    long count() {
        return customerService.count();
    }

    @RequestMapping("/hello")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    //pomocu anotacije specifiramo tocnu metodu koja ce hendlat taj request, kao i request method type, headers i ostale parametre
    @RequestMapping(value = "/customer/create", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    Customer createCustomer(@RequestBody Customer customer) {
        LOGGER.debug("creating customer!");
        return customerService.create(customer);
    }

    @RequestMapping(value = "/email", method = RequestMethod.GET)
    @ResponseBody
    boolean checkEmail(@RequestParam("email") String email) {
        LOGGER.debug("Getting email");
        return customerService.isEmailAvailable(email);
    }




}
