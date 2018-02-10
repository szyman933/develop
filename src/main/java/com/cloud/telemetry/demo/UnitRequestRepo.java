package com.cloud.telemetry.demo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface UnitRequestRepo extends JpaRepository<UnitRequest, Long> {

    @Transactional
    @Query("SELECT u FROM UnitRequest u WHERE u.UnitNetIdent = :unit_net_ident")
    List<UnitRequest> getUnitRequests(@Param("unit_net_ident") Integer unit_net_ident);


}
