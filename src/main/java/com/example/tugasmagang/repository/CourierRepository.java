package com.example.tugasmagang.repository;

import com.example.tugasmagang.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourierRepository extends JpaRepository<Courier, Integer> {

    @Query(value = "SELECT * \n" +
            "FROM courier AS co\n" +
            "JOIN coverage_city AS ci\n" +
            "ON co.coverage_city = ci.city_id\n" +
            "WHERE co.courier_name LIKE %:keywordName%\n" +
            "AND co.courier_type = :keywordType\n" +
            "AND ci.city_name = :keywordCity", nativeQuery = true)
    List<Courier> findByKeyword(@Param("keywordName") String keywordName,
                                @Param("keywordType") String keywordType,
                                @Param("keywordCity") String keywordCity);

    @Query(value = "SELECT * \n" +
            "FROM courier\n" +
            "WHERE courier_type = 'MCY'", nativeQuery = true)
    List<Courier> getTypeMCY();

    @Query(value = "SELECT * \n" +
            "FROM courier\n" +
            "WHERE courier_type = 'CAR'", nativeQuery = true)
    List<Courier> getTypeCAR();

}
