package com.example.tugasmagang.repository;

import com.example.tugasmagang.model.CoverageCity;
import com.example.tugasmagang.model.TransactionAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionAssignmentRepository extends JpaRepository<TransactionAssignment, Integer> {

    @Query(value = "SELECT * \n" +
            "FROM transaction_assignment AS trx\n" +
            "JOIN courier AS co\n" +
            "ON trx.courier_id = co.courier_id\n" +
            "WHERE co.courier_name LIKE %:keyword%", nativeQuery = true)
    List<TransactionAssignment> findByKeyword(@Param("keyword") String keyword);
}
