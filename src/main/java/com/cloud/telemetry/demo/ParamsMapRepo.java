package com.cloud.telemetry.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
interface ParamsMapRepo  extends JpaRepository<ParamsMap,Long> {

    @Transactional
    @Query(value = "SELECT * FROM params_map where active='y'", nativeQuery = true)
    List<ParamsMap> getAllReqActive();

    @Transactional
    @Query(value = "SELECT * FROM params_map where rw = 'r' ", nativeQuery = true)
    List<ParamsMap> getReadOnly();

    @Transactional
    @Query(value = "SELECT * FROM params_map where rw = 'w' ", nativeQuery = true)
    List<ParamsMap> getWriteOnly();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE ParamsMap r SET r.active = :active WHERE r.id = :id")
    int updateActivebyId(@Param("id") Long id, @Param("active") String active);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE ParamsMap r SET r.active = :active WHERE r.index = :index ")
    int updateActivebyIndex(@Param("index") Integer index, @Param("active") String active);


    @Transactional
    @Modifying
    @Query(value = "update params_map u set u.active = ? where u.index = ?",nativeQuery = true)
    int updateActivebyIndexNative(String active, Integer index);

    @Transactional
    @Modifying
    @Query(value = "insert into params_map (id, input_device_id, unit_input_id, rw, `index`, active, description) VALUES(0, ?, ?, ?, ?, ?, ?)",nativeQuery = true)
    int insertNewReg(Integer idi, Integer uid, String rw, Integer index, String active, String description);


}
