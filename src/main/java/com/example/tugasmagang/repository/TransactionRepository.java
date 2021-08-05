package com.example.tugasmagang.repository;

import com.example.tugasmagang.model.Courier;
import com.example.tugasmagang.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query(value = "SELECT * \n" +
            "FROM transaction AS trx\n" +
            "JOIN package AS pkg\n" +
            "ON trx.trx_package = pkg.package_id\n" +
            "JOIN coverage_city AS ciSrc\n" +
            "ON trx.trx_city_src = ciSrc.city_id\n" +
            "JOIN coverage_city AS ciDst\n" +
            "ON trx.trx_city_dst = ciDst.city_id\n" +
            "WHERE pkg.package_description = :keywordPackage\n" +
            "AND trx.trx_type = :keywordType\n" +
            "AND ciSrc.city_name = :keywordCity", nativeQuery = true)
    List<Transaction> findByKeyword(@Param("keywordPackage") String keywordPackage,
                                @Param("keywordType") String keywordType,
                                @Param("keywordCity") String keywordCity);
}
