package com.example.tugasmagang.controller;

import com.example.tugasmagang.model.CoverageCity;
import com.example.tugasmagang.model.PackageModel;
import com.example.tugasmagang.model.Transaction;
import com.example.tugasmagang.model.TransactionAssignment;
import com.example.tugasmagang.repository.CoverageCityRepository;
import com.example.tugasmagang.repository.PackageRepository;
import com.example.tugasmagang.repository.TransactionAssignmentRepository;
import com.example.tugasmagang.repository.TransactionRepository;
import com.example.tugasmagang.service.CoverageCityService;
import com.example.tugasmagang.service.PackageService;
import com.example.tugasmagang.service.TransactionAssignmentService;
import com.example.tugasmagang.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TransactionController {

    private TransactionService transactionService;
    private PackageService packageService;
    private CoverageCityService coverageCityService;
    private TransactionAssignmentService transactionAssignmentService;

    public TransactionController(TransactionService transactionService, PackageService packageService, CoverageCityService coverageCityService, TransactionAssignmentService transactionAssignmentService) {
        this.transactionService = transactionService;
        this.packageService = packageService;
        this.coverageCityService = coverageCityService;
        this.transactionAssignmentService = transactionAssignmentService;
    }

    @GetMapping("/transactions")
    public String transactionList(Model model, String keywordPackage, String keywordType, String keywordCity) {
        List<PackageModel> packagesList = packageService.findAll();
        model.addAttribute("packagesList", packagesList);

        List<CoverageCity> coverageCityList = coverageCityService.findAll();
        model.addAttribute("coverageCityList", coverageCityList);

        if(keywordPackage != null && keywordType != null && keywordCity != null) {
            List<Transaction> transactionsList = transactionService.findByKeyword(keywordPackage, keywordType, keywordCity);
            model.addAttribute("transactionsList", transactionsList);
        } else {
            List<Transaction> transactionsList = transactionService.findAll();
            model.addAttribute("transactionsList", transactionsList);
        }

        return "transaction/transactionsList";
    }

    @RequestMapping("/transactions/add")
    public String transactionAdd(Model model) {
        Transaction transaction = new Transaction();
        model.addAttribute("transaction", transaction);

        List<PackageModel> packagesList = packageService.findAll();
        model.addAttribute("packagesList", packagesList);

        List<CoverageCity> coverageCityList = coverageCityService.findAll();
        model.addAttribute("coverageCityList", coverageCityList);

        return "transaction/transactionAdd";
    }

    @RequestMapping(value = "/api/transactions/add", method = RequestMethod.POST)
    public String transactionAddAPI(@ModelAttribute("transaction") Transaction transaction) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        transaction.setTrx_date(timestamp);

        if(transaction.getTrx_city_src() == transaction.getTrx_city_dst()) {
            transaction.setTrx_type("DK");
        } else {
            transaction.setTrx_type("AK");
        }

        transactionService.save(transaction);

        TransactionAssignment transactionAssignment = new TransactionAssignment();
        transactionAssignment.setTrx_id(transaction.getTrx_id());
//        String defaultValue = "-";
//        Date date = new SimpleDateFormat("d").parse(defaultValue);
        transactionAssignment.setAssign_date(null);
//        transactionAssignment.setCourier_id(null);
        transactionAssignmentService.save(transactionAssignment);

        return "redirect:/transactions";
    }

}
