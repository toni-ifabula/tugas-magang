package com.example.tugasmagang.controller;

import com.example.tugasmagang.model.PackageModel;
import com.example.tugasmagang.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PackageController {

    private PackageRepository repository;

    public PackageController(PackageRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/packages")
    public String packageList(Model model) {
        List<PackageModel> packagesList = repository.findAll();
        model.addAttribute("packagesList", packagesList);

        return "package/packagesList";
    }

    @RequestMapping("/packages/add")
    public String packageAdd(Model model) {
        PackageModel packageModel = new PackageModel();
        model.addAttribute("packageModel", packageModel);

        return "package/packageAdd";
    }

    @RequestMapping(value = "/api/packages/add", method = RequestMethod.POST)
    public String packageAddAPI(@ModelAttribute("packageModel") PackageModel packageModel) {
        repository.save(packageModel);

        return "redirect:/packages";
    }

    @RequestMapping("api/packages/delete/{package_id}")
    public String packageDelete(@PathVariable(name = "package_id") String package_id) {
        repository.deleteById(Integer.parseInt(package_id));
        return "redirect:/packages";
    }
}
