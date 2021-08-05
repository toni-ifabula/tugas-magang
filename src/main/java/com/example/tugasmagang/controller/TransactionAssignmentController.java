package com.example.tugasmagang.controller;

import com.example.tugasmagang.model.Courier;
import com.example.tugasmagang.model.CoverageCity;
import com.example.tugasmagang.model.TransactionAssignment;
import com.example.tugasmagang.repository.CourierRepository;
import com.example.tugasmagang.repository.TransactionAssignmentRepository;
import com.example.tugasmagang.repository.TransactionRepository;
import com.example.tugasmagang.service.CourierService;
import com.example.tugasmagang.service.TransactionAssignmentService;
import com.example.tugasmagang.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class TransactionAssignmentController {

    private TransactionAssignmentService transactionAssignmentService;
    private TransactionService transactionService;
    private CourierService courierService;

    public TransactionAssignmentController(TransactionAssignmentService transactionAssignmentService, TransactionService transactionService, CourierService courierService) {
        this.transactionAssignmentService = transactionAssignmentService;
        this.transactionService = transactionService;
        this.courierService = courierService;
    }

    @GetMapping("/transactionAssignment")
    public String transactionAssignmentList(Model model, String keyword) {
        if(keyword != null) {
            List<TransactionAssignment> transactionAssignmentList = transactionAssignmentService.findByKeyword(keyword);
            model.addAttribute("transactionAssignmentList", transactionAssignmentList);
        } else {
            List<TransactionAssignment> transactionAssignmentList = transactionAssignmentService.findAll();
            model.addAttribute("transactionAssignmentList", transactionAssignmentList);
        }

        return "transactionAssignment/transactionAssignmentList";
    }

    @RequestMapping(value = "/api/transactionAssignment/save", method = RequestMethod.POST)
    public String transactionAssignmentSaveAPI(@ModelAttribute("transactionAssignment") TransactionAssignment transactionAssignment) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        transactionAssignment.setAssign_date(timestamp);

//        transactionAssignment.getTransaction().getTrx_date();
//        transactionAssignment.setTrx_id(transactionAssignment.getTransaction().getTrx_id());

        transactionAssignmentService.save(transactionAssignment);

        return "redirect:/transactionAssignment";
    }

    @RequestMapping("transactionAssignment/edit/{trxAssign_id}")
    public ModelAndView transactionAssignmentEdit(@PathVariable(name = "trxAssign_id") String trxAssign_id) {
        ModelAndView mav = new ModelAndView("transactionAssignment/transactionAssignmentEdit");
        TransactionAssignment transactionAssignment = transactionAssignmentService.findById(Integer.parseInt(trxAssign_id)).get();
        mav.addObject("transactionAssignment", transactionAssignment);

        if(transactionAssignment.getTransaction().getTrx_type().equals("DK")) {
            List<Courier> couriers = courierService.getTypeMCY();
            mav.addObject("couriers", couriers);
        } else if(transactionAssignment.getTransaction().getTrx_type().equals("AK")) {
            List<Courier> couriers = courierService.getTypeCAR();
            mav.addObject("couriers", couriers);
        }

        return mav;
    }
}
