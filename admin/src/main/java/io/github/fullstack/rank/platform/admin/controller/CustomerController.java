package io.github.fullstack.rank.platform.admin.controller;

import io.github.fullstack.rank.platform.admin.repository.Customer;
import io.github.fullstack.rank.platform.admin.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * Summary: CustomerController
 * Author : anduo@qq.com
 * Version: 1.0
 * Date   : 16/2/18
 * Time   : 下午12:02
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer getBook(@PathVariable long id) {
        return customerRepository.findOne(id);
    }

}
