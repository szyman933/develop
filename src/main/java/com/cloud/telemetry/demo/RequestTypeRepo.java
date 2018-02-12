package com.cloud.telemetry.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RequestTypeRepo extends JpaRepository<RequestType,Long> {


    @Transactional
    @Query(value = "SELECT * FROM request_type", nativeQuery = true)
    List<RequestType> getAllTypeReq();


}
