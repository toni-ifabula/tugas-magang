package com.example.tugasmagang.controller;

import com.example.tugasmagang.model.Courier;
import com.example.tugasmagang.model.CoverageCity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String courierList() {
        return "home";
    }

}
