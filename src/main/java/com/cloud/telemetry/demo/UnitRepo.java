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

    @Transactional
    @Query("SELECT r FROM Units r WHERE r.NetIdent = :net_ident")
    List<Units> getByUnit(@Param("net_ident") Integer net_ident);

}
