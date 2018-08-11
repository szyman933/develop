package com.cloud.telemetry.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ParamsMapRepo  extends JpaRepository<ParamsMap,Long> {

    @Transactional
    @Query(value = "SELECT * FROM params_map where active='y'", nativeQuery = true)
    List<ParamsMap> getAllReqActive();

    @Transactional
    @Query(value = "SELECT * FROM params_map where rw = 'r' ", nativeQuery = true)
    List<ParamsMap> getReadOnly();

    @Transactional
    @Query(value = "SELECT * FROM params_map where rw = 'w' ", nativeQuery = true)
    List<ParamsMap> getWriteOnly();

}
