package com.example.tugasmagang.controller;

import com.example.tugasmagang.model.CoverageCity;
import com.example.tugasmagang.model.PackageModel;
import com.example.tugasmagang.model.Transaction;
import com.example.tugasmagang.repository.CoverageCityRepository;
import com.example.tugasmagang.repository.PackageRepository;
import com.example.tugasmagang.repository.TransactionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TransactionController {

    private TransactionRepository transactionRepository;
    private PackageRepository packageRepository;
    private CoverageCityRepository coverageCityRepository;

    public TransactionController(TransactionRepository transactionRepository, PackageRepository packageRepository, CoverageCityRepository coverageCityRepository) {
        this.transactionRepository = transactionRepository;
        this.packageRepository = packageRepository;
        this.coverageCityRepository = coverageCityRepository;
    }

    @RequestMapping("/transactions")
    public String transactionList(Model model) {
        List<Transaction> transactionsList = transactionRepository.findAll();
        model.addAttribute("transactionsList", transactionsList);

        return "transaction/transactionsList";
    }

    @RequestMapping("/transactions/add")
    public String transactionAdd(Model model) {
        Transaction transaction = new Transaction();
        model.addAttribute("transaction", transaction);

        List<PackageModel> packagesList = packageRepository.findAll();
        model.addAttribute("packagesList", packagesList);

        List<CoverageCity> coverageCityList = coverageCityRepository.findAll();
        model.addAttribute("coverageCityList", coverageCityList);

        return "transaction/transactionAdd";
    }

    @RequestMapping(value = "/api/transactions/add", method = RequestMethod.POST)
    public String transactionAddAPI(@ModelAttribute("transaction") Transaction transaction) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        transaction.setTrx_date(timestamp);

        if(transaction.getTrx_city_src() == transaction.getTrx_city_dst()) {
            transaction.setTrx_type("DK");
        } else {
            transaction.setTrx_type("AK");
        }

        transactionRepository.save(transaction);

        return "redirect:/transactions";
    }

}
