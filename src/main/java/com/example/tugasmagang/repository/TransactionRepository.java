package com.example.tugasmagang.repository;

import com.example.tugasmagang.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

//    String queryString = "SELECT trx.trx_id, trx.trx_date, pkg.package_description, trx.trx_type, ci1.city_name, ci2.city_name\n" +
//            "FROM transaction AS trx\n" +
//            "JOIN package AS pkg\n" +
//            "ON trx.trx_package = pkg.package_id\n" +
//            "JOIN coverage_city AS ci1\n" +
//            "ON trx.trx_city_src = ci1.city_id\n" +
//            "JOIN coverage_city AS ci2\n" +
//            "ON trx.trx_city_dst = ci2.city_id\n";
//
//    @Query(value = queryString, nativeQuery = true)
//    List<Transaction> findAllCustom();
}
