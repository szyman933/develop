package com.cloud.telemetry.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
interface ReadingsRepo extends JpaRepository<Reading, Long> {

    @Transactional
    @Query("SELECT r FROM Reading r WHERE r.unitId = :unitId")
    List<Reading> getByUnit(@Param("unitId") Integer unitId);

    @Transactional
    @Query(value = "SELECT * FROM readings ORDER BY id desc LIMIT 10", nativeQuery = true)
    List<Reading> getLatestTen();

    @Transactional
    @Query(value = "SELECT * FROM readings where value <> 99 ORDER BY id desc LIMIT 10", nativeQuery = true)
    List<Reading> getLatestTenCorrect();


    @Transactional
    @Query("SELECT r FROM Reading r WHERE r.unitId = :unitId AND r.unitInputId = :unitInputId")
    List<Reading> getReadByUnitAndInput(@Param("unitId") Integer unitId, @Param("unitInputId") Integer unitInputId);

}
