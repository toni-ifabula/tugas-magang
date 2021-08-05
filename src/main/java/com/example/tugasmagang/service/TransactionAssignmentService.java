package com.example.tugasmagang.service;

import com.example.tugasmagang.model.CoverageCity;
import com.example.tugasmagang.model.PackageModel;
import com.example.tugasmagang.model.TransactionAssignment;
import com.example.tugasmagang.repository.PackageRepository;
import com.example.tugasmagang.repository.TransactionAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TransactionAssignmentService {

    @Autowired
    TransactionAssignmentRepository repository;

    public List<TransactionAssignment> findAll() {
        return repository.findAll();
    }

    public Optional<TransactionAssignment> findById(int id) {
        return repository.findById(id);
    }

    public void save(TransactionAssignment transactionAssignment) {
        repository.save(transactionAssignment);
    }

    public List<TransactionAssignment> findByKeyword(String keyword) {
        return repository.findByKeyword(keyword);
    }
}
