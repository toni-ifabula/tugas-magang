package com.example.tugasmagang.controller;

import com.example.tugasmagang.model.Courier;
import com.example.tugasmagang.model.CoverageCity;
import com.example.tugasmagang.repository.CourierRepository;
import com.example.tugasmagang.repository.CoverageCityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;

@Controller
public class CourierController {

    private CourierRepository courierRepository;
    private CoverageCityRepository coverageCityRepository;

    public CourierController(CourierRepository courierRepository, CoverageCityRepository coverageCityRepository) {
        this.courierRepository = courierRepository;
        this.coverageCityRepository = coverageCityRepository;
    }

    @RequestMapping("/couriers")
    public String courierList(Model model) {
        List<Courier> couriers = courierRepository.findAll();
        model.addAttribute("couriers", couriers);

        return "courier/couriersList";
    }

    @RequestMapping("/couriers/add")
    public String courierAdd(Model model, Model model2) {
        Courier courier = new Courier();
        model.addAttribute("courier", courier);

        List<CoverageCity> coverageCityList = coverageCityRepository.findAll();
        model.addAttribute("coverageCityList", coverageCityList);

        return "courier/courierAdd";
    }

    @RequestMapping(value = "/api/couriers/save", method = RequestMethod.POST)
    public String courierAddAPI(@ModelAttribute("courier") Courier courier) {
        courierRepository.save(courier);

        return "redirect:/couriers";
    }

    @RequestMapping("api/couriers/delete/{courier_id}")
    public String courierDelete(@PathVariable(name = "courier_id") String courier_id) {
        courierRepository.deleteById(Integer.parseInt(courier_id));
        return "redirect:/couriers";
    }

    @RequestMapping("couriers/edit/{courier_id}")
    public ModelAndView courierEdit(@PathVariable(name = "courier_id") String courier_id) {
        ModelAndView mav = new ModelAndView("courier/courierEdit");
        Courier courier = courierRepository.findById(Integer.parseInt(courier_id)).get();
        mav.addObject("courier", courier);

        List<CoverageCity> coverageCityList = coverageCityRepository.findAll();
        mav.addObject("coverageCityList", coverageCityList);

        return mav;
    }
}
