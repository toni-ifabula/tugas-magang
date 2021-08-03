package com.example.tugasmagang.controller;

import com.example.tugasmagang.model.CoverageCity;
import com.example.tugasmagang.repository.CoverageCityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/api/coverageCities/add", method = RequestMethod.POST)
    public String coverageCityAddAPI(@ModelAttribute("coverageCity") CoverageCity coverageCity) {
        repository.save(coverageCity);

        return "redirect:/coverageCities";
    }
}
