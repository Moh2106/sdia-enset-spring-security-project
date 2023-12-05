package ma.enset.customerfrontthymleafapp.web;

import ma.enset.customerfrontthymleafapp.entities.Customer;
import ma.enset.customerfrontthymleafapp.repositories.CustomerRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {
    private CustomerRepositories customerRepositories;

    public CustomerController(CustomerRepositories customerRepositories) {
        this.customerRepositories = customerRepositories;
    }

    @GetMapping("/customers")
    public String customers(Model model){
        List<Customer> customerList = customerRepositories.findAll();
        model.addAttribute("customers", customerList);
        return "customers";
    }

    @GetMapping("/products")
    public String products(){
        return "products";
    }
}
