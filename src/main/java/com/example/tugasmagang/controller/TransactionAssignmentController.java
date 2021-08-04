package com.example.tugasmagang.controller;

import com.example.tugasmagang.model.Courier;
import com.example.tugasmagang.model.CoverageCity;
import com.example.tugasmagang.model.TransactionAssignment;
import com.example.tugasmagang.repository.CourierRepository;
import com.example.tugasmagang.repository.TransactionAssignmentRepository;
import com.example.tugasmagang.repository.TransactionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TransactionAssignmentController {

    private TransactionAssignmentRepository transactionAssignmentRepository;
    private TransactionRepository transactionRepository;
    private CourierRepository courierRepository;

    public TransactionAssignmentController(TransactionAssignmentRepository transactionAssignmentRepository, TransactionRepository transactionRepository, CourierRepository courierRepository) {
        this.transactionAssignmentRepository = transactionAssignmentRepository;
        this.transactionRepository = transactionRepository;
        this.courierRepository = courierRepository;
    }

    @RequestMapping("/transactionAssignment")
    public String transactionAssignmentList(Model model) {
        List<TransactionAssignment> transactionAssignmentList = transactionAssignmentRepository.findAll();
        model.addAttribute("transactionAssignmentList", transactionAssignmentList);

        return "transactionAssignment/transactionAssignmentList";
    }
}
