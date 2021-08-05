package com.example.tugasmagang.service;

import com.example.tugasmagang.model.Courier;
import com.example.tugasmagang.model.PackageModel;
import com.example.tugasmagang.model.Transaction;
import com.example.tugasmagang.repository.PackageRepository;
import com.example.tugasmagang.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TransactionService {

    @Autowired
    TransactionRepository repository;

    public List<Transaction> findAll() {
        return repository.findAll();
    }

    public void save(Transaction transaction) {
        repository.save(transaction);
    }

    public List<Transaction> findByKeyword(String keywordPackage, String keywordType, String keywordCIty) {
        return repository.findByKeyword(keywordPackage, keywordType, keywordCIty);
    }
}
