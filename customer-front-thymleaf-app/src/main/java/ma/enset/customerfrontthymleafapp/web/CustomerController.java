package ma.enset.customerfrontthymleafapp.web;

import ma.enset.customerfrontthymleafapp.entities.Customer;
import ma.enset.customerfrontthymleafapp.repositories.CustomerRepositories;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CustomerController {
    private final CustomerRepositories customerRepositories;

    public CustomerController(CustomerRepositories customerRepositories) {
        this.customerRepositories = customerRepositories;
    }

    @GetMapping("/customers")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String customers(Model model){
        List<Customer> customerList = customerRepositories.findAll();
        model.addAttribute("customers", customerList);
        return "customers";
    }

    @GetMapping("/products")
    public String products(){
        return "products";
    }

    @GetMapping("/auth")
    @ResponseBody
    public Authentication authenticate(Authentication authentication){
        return authentication;
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/NotAuthorized")
    public String notAuthorized(){
        return "notAuthorized";
    }
}
