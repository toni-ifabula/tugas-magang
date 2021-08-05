package com.example.tugasmagang.service;

import com.example.tugasmagang.model.CoverageCity;
import com.example.tugasmagang.model.PackageModel;
import com.example.tugasmagang.repository.CoverageCityRepository;
import com.example.tugasmagang.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CoverageCityService {

    @Autowired
    CoverageCityRepository repository;

    public List<CoverageCity> findAll() {
        return repository.findAll();
    }

    public Optional<CoverageCity> findById(int id) {
        return repository.findById(id);
    }

    public void save(CoverageCity coverageCity) {
        repository.save(coverageCity);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public List<CoverageCity> findByKeyword(String keyword) {
        return repository.findByKeyword(keyword);
    }
}
