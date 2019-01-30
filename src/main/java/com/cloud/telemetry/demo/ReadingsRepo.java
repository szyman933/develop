package com.cloud.telemetry.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface ReadingsRepo extends JpaRepository <Readings, Long> {

    @Transactional
    @Query("SELECT r FROM Readings r WHERE r.unitId = :unitId")
    List<Readings> getByUnit(@Param("unitId") Integer unitId);

    @Transactional
    @Query(value = "SELECT * FROM readings ORDER BY id desc LIMIT 10", nativeQuery = true)
    List<Readings> getLatestTen();

    @Transactional
    @Query(value = "SELECT * FROM readings where value <> 99 ORDER BY id desc LIMIT 10", nativeQuery = true)
    List<Readings> getLatestTenCorrect();


    @Transactional
    @Query("SELECT r FROM Readings r WHERE r.unitId = :unit_id AND r.unitInputId = :unitInputId")
    List<Readings> getReadByUnitAndInput(@Param("unit_id") Integer unitId, @Param("unitInputId") Integer unitInputId);

}
