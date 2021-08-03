package com.example.tugasmagang.repository;

import com.example.tugasmagang.model.PackageModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<PackageModel, Integer> {
}
