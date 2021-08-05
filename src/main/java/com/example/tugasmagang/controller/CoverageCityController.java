package com.example.tugasmagang.controller;

import com.example.tugasmagang.model.CoverageCity;
import com.example.tugasmagang.model.PackageModel;
import com.example.tugasmagang.repository.CoverageCityRepository;
import com.example.tugasmagang.service.CoverageCityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CoverageCityController {

    private CoverageCityService coverageCityService;

    public CoverageCityController(CoverageCityService coverageCityService) {
        this.coverageCityService = coverageCityService;
    }

    @GetMapping("/coverageCities")
    public String coverageCityList(Model model, String keyword) {
        if(keyword != null) {
            List<CoverageCity> coverageCityList = coverageCityService.findByKeyword(keyword);
            model.addAttribute("coverageCityList", coverageCityList);
        } else {
            List<CoverageCity> coverageCityList = coverageCityService.findAll();
            model.addAttribute("coverageCityList", coverageCityList);
        }

        return "coverageCity/coverageCityList";
    }

    @RequestMapping("/coverageCities/add")
    public String coverageCityAdd(Model model) {
        CoverageCity coverageCity = new CoverageCity();
        model.addAttribute("coverageCity", coverageCity);

        return "coverageCity/coverageCityAdd";
    }

    @RequestMapping(value = "/api/coverageCities/save", method = RequestMethod.POST)
    public String coverageCitySaveAPI(@ModelAttribute("coverageCity") CoverageCity coverageCity) {
        coverageCityService.save(coverageCity);

        return "redirect:/coverageCities";
    }

    @RequestMapping("api/coverageCities/delete/{city_id}")
    public String coverageCityDelete(@PathVariable(name = "city_id") String city_id) {
        coverageCityService.deleteById(Integer.parseInt(city_id));
        return "redirect:/coverageCities";
    }

    @RequestMapping("coverageCities/edit/{city_id}")
    public ModelAndView coverageCityEdit(@PathVariable(name = "city_id") String city_id) {
        ModelAndView mav = new ModelAndView("coverageCity/coverageCityEdit");
        CoverageCity coverageCity = coverageCityService.findById(Integer.parseInt(city_id)).get();
        mav.addObject("coverageCity", coverageCity);

        return mav;
    }
}
