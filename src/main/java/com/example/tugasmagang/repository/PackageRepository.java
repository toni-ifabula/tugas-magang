package com.example.tugasmagang.repository;

import com.example.tugasmagang.model.PackageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PackageRepository extends JpaRepository<PackageModel, Integer> {

    @Query(value = "SELECT * FROM package \n" +
            "WHERE package_description LIKE %:keyword%", nativeQuery = true)
    List<PackageModel> findByKeyword(@Param("keyword") String keyword);
}
