package com.example.tugasmagang.service;

import com.example.tugasmagang.model.PackageModel;
import com.example.tugasmagang.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PackageService {

    @Autowired
    PackageRepository repository;

    public List<PackageModel> findAll() {
        return repository.findAll();
    }

    public Optional<PackageModel> findById(int id) {
        return repository.findById(id);
    }

    public void save(PackageModel packageModel) {
        repository.save(packageModel);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public List<PackageModel> findByKeyword(String keyword) {
        return repository.findByKeyword(keyword);
    }
}
