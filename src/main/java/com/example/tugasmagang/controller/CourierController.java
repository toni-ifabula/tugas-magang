package com.example.tugasmagang.controller;

import com.example.tugasmagang.model.Courier;
import com.example.tugasmagang.model.PackageModel;
import com.example.tugasmagang.repository.CourierRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CourierController {

    private CourierRepository repository;

    public CourierController(CourierRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/couriers")
    public String courierList(Model model) {
        List<Courier> couriers = repository.findAll();
        model.addAttribute("couriers", couriers);

        return "courier/couriersList";
    }

    @RequestMapping("/couriers/add")
    public String courierAdd(Model model) {
        Courier courier = new Courier();
        model.addAttribute("courier", courier);

        return "courier/courierAdd";
    }

    @RequestMapping(value = "/api/couriers/add", method = RequestMethod.POST)
    public String courierAddAPI(@ModelAttribute("courier") Courier courier) {
        repository.save(courier);

        return "redirect:/couriers";
    }
}
