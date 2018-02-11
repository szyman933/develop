package com.cloud.telemetry.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UnitRepo extends JpaRepository<Units, Long> {


    @Transactional
    @Query(value = "SELECT * FROM unit", nativeQuery = true)
    List<Units> getUnits();


}
