package com.example.tugasmagang.controller;

import com.example.tugasmagang.model.PackageModel;
import com.example.tugasmagang.repository.PackageRepository;
import com.example.tugasmagang.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PackageController {

    @Autowired
    private PackageService packageService;

    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    @GetMapping("/packages")
    public String packageList(Model model, String keyword) {
        if(keyword != null) {
            List<PackageModel> packagesList = packageService.findByKeyword(keyword);
            model.addAttribute("packagesList", packagesList);
        } else {
            List<PackageModel> packagesList = packageService.findAll();
            model.addAttribute("packagesList", packagesList);
        }

        return "package/packagesList";
    }

    @RequestMapping("/packages/add")
    public String packageAdd(Model model) {
        PackageModel packageModel = new PackageModel();
        model.addAttribute("packageModel", packageModel);

        return "package/packageAdd";
    }

    @RequestMapping(value = "/api/packages/save", method = RequestMethod.POST)
    public String packageSaveAPI(@ModelAttribute("packageModel") PackageModel packageModel) {
        packageService.save(packageModel);

        return "redirect:/packages";
    }

    @RequestMapping("api/packages/delete/{package_id}")
    public String packageDelete(@PathVariable(name = "package_id") String package_id) {
        packageService.deleteById(Integer.parseInt(package_id));
        return "redirect:/packages";
    }

    @RequestMapping("packages/edit/{package_id}")
    public ModelAndView packageEdit(@PathVariable(name = "package_id") String package_id) {
        ModelAndView mav = new ModelAndView("package/packageEdit");
        PackageModel packageModel = packageService.findById(Integer.parseInt(package_id)).get();
        mav.addObject("packageModel", packageModel);

        return mav;
    }
}
