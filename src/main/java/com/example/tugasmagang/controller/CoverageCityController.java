package com.example.tugasmagang.controller;

import com.example.tugasmagang.model.CoverageCity;
import com.example.tugasmagang.model.PackageModel;
import com.example.tugasmagang.repository.CoverageCityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CoverageCityController {

    private CoverageCityRepository repository;

    public CoverageCityController(CoverageCityRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/coverageCities")
    public String coverageCityList(Model model) {
        List<CoverageCity> coverageCityList = repository.findAll();
        model.addAttribute("coverageCityList", coverageCityList);

        return "coverageCity/coverageCityList";
    }

    @RequestMapping("/coverageCities/add")
    public String coverageCityAdd(Model model) {
        CoverageCity coverageCity = new CoverageCity();
        model.addAttribute("coverageCity", coverageCity);

        return "coverageCity/coverageCityAdd";
    }

    @RequestMapping(value = "/api/coverageCities/save", method = RequestMethod.POST)
    public String coverageCityAddAPI(@ModelAttribute("coverageCity") CoverageCity coverageCity) {
        repository.save(coverageCity);

        return "redirect:/coverageCities";
    }

    @RequestMapping("api/coverageCities/delete/{city_id}")
    public String coverageCityDelete(@PathVariable(name = "city_id") String city_id) {
        repository.deleteById(Integer.parseInt(city_id));
        return "redirect:/coverageCities";
    }

    @RequestMapping("coverageCities/edit/{city_id}")
    public ModelAndView packageEdit(@PathVariable(name = "city_id") String city_id) {
        ModelAndView mav = new ModelAndView("coverageCity/coverageCityEdit");
        CoverageCity coverageCity = repository.findById(Integer.parseInt(city_id)).get();
        mav.addObject("coverageCity", coverageCity);

        return mav;
    }
}
