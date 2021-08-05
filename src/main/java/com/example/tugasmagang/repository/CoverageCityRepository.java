package com.example.tugasmagang.repository;

import com.example.tugasmagang.model.CoverageCity;
import com.example.tugasmagang.model.PackageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoverageCityRepository extends JpaRepository<CoverageCity, Integer> {

    @Query(value = "SELECT * FROM coverage_city \n" +
            "WHERE city_name LIKE %:keyword%", nativeQuery = true)
    List<CoverageCity> findByKeyword(@Param("keyword") String keyword);
}
