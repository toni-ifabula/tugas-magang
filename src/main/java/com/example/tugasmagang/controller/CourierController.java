package com.example.tugasmagang.controller;

import com.example.tugasmagang.model.Courier;
import com.example.tugasmagang.model.CoverageCity;
import com.example.tugasmagang.repository.CourierRepository;
import com.example.tugasmagang.repository.CoverageCityRepository;
import com.example.tugasmagang.service.CourierService;
import com.example.tugasmagang.service.CoverageCityService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;

@Controller
public class CourierController {

    private CourierService courierService;
    private CoverageCityService coverageCityService;

    public CourierController(CourierService courierService, CoverageCityService coverageCityService) {
        this.courierService = courierService;
        this.coverageCityService = coverageCityService;
    }

    @GetMapping("/couriers")
    public String courierList(Model model, String keywordName,
                              String keywordType, String keywordCity) {
        List<CoverageCity> coverageCityList = coverageCityService.findAll();
        model.addAttribute("coverageCityList", coverageCityList);

        if(keywordName != null && keywordType != null && keywordCity != null) {
            List<Courier> couriers = courierService.findByKeyword(keywordName, keywordType, keywordCity);
            model.addAttribute("couriers", couriers);
        } else {
            List<Courier> couriers = courierService.findAll();
            model.addAttribute("couriers", couriers);
        }

        return "courier/couriersList";
    }

    @RequestMapping("/couriers/add")
    public String courierAdd(Model model) {
        Courier courier = new Courier();
        model.addAttribute("courier", courier);

        List<CoverageCity> coverageCityList = coverageCityService.findAll();
        model.addAttribute("coverageCityList", coverageCityList);

        return "courier/courierAdd";
    }

    @RequestMapping(value = "/api/couriers/save", method = RequestMethod.POST)
    public String courierAddAPI(@ModelAttribute("courier") Courier courier) {
        courierService.save(courier);

        return "redirect:/couriers";
    }

    @RequestMapping("api/couriers/delete/{courier_id}")
    public String courierDelete(@PathVariable(name = "courier_id") String courier_id) {
        courierService.deleteById(Integer.parseInt(courier_id));
        return "redirect:/couriers";
    }

    @RequestMapping("couriers/edit/{courier_id}")
    public ModelAndView courierEdit(@PathVariable(name = "courier_id") String courier_id) {
        ModelAndView mav = new ModelAndView("courier/courierEdit");
        Courier courier = courierService.findById(Integer.parseInt(courier_id)).get();
        mav.addObject("courier", courier);

        List<CoverageCity> coverageCityList = coverageCityService.findAll();
        mav.addObject("coverageCityList", coverageCityList);

        return mav;
    }
}
