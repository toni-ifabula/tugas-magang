package com.example.tugasmagang.service;

import com.example.tugasmagang.model.Courier;
import com.example.tugasmagang.model.CoverageCity;
import com.example.tugasmagang.repository.CourierRepository;
import com.example.tugasmagang.repository.CoverageCityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourierService {

    @Autowired
    CourierRepository repository;

    public List<Courier> findAll() {
        return repository.findAll();
    }

    public Optional<Courier> findById(int id) {
        return repository.findById(id);
    }

    public void save(Courier courier) {
        repository.save(courier);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public List<Courier> findByKeyword(String keywordName, String keywordType, String keywordCIty) {
        return repository.findByKeyword(keywordName, keywordType, keywordCIty);
    }

    public List<Courier> getTypeMCY() {
        return repository.getTypeMCY();
    }

    public List<Courier> getTypeCAR() {
        return repository.getTypeCAR();
    }
}
