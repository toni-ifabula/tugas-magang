package com.example.tugasmagang.repository;

import com.example.tugasmagang.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourierRepository extends JpaRepository<Courier, Integer> {

    String queryString = "SELECT co.courier_id, co.courier_name, co.courier_type, ci.city_name\n" +
            "FROM courier AS co\n" +
            "JOIN coverage_city AS ci\n" +
            "ON co.coverage_city = ci.city_id";

    @Query(value = queryString, nativeQuery = true)
    List<Courier> findAllCustom();

}
