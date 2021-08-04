package com.example.tugasmagang.repository;

import com.example.tugasmagang.model.Courier;
import com.example.tugasmagang.model.modelCustom.CourierCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourierRepository extends JpaRepository<Courier, Integer> {

//    String queryString = "SELECT new com.example.tugasmagang.model.modelcustom.CourierCustom(co.courier_id, co.courier_name, co.courier_type, ci.city_name AS coverage_city)\n" +
//            "FROM courier AS co\n" +
//            "JOIN coverage_city AS ci\n" +
//            "ON co.coverage_city = ci.city_id";

//    String queryString = "SELECT new com.example.tugasmagang.model.modelcustom.CourierCustom(co.courier_id, co.courier_name, co.courier_type, ci.city_name AS coverage_city)\n" +
//            "FROM Courier co\n" +
//            "JOIN co.coverage_city ci\n";
//
//    @Query(queryString)
//    List<CourierCustom> findAllCustom();

}
