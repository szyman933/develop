package com.cloud.telemetry.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UnitRequestRepo extends JpaRepository<UnitRequest,Long> {


    @Transactional
    @Query(value = "SELECT * FROM unit_request", nativeQuery = true)
    List<UnitRequest> getAllReq();

    @Transactional
    @Query(value = "SELECT * FROM unit_request ORDER BY reg_date desc LIMIT 10", nativeQuery = true)
    List<UnitRequest> getNew10Req();


}
