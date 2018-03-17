package com.cloud.telemetry.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UnitInputRepo extends JpaRepository<UnitInput, Long> {

    @Transactional
    @Query("SELECT r FROM UnitInput r WHERE r.InputNumber = :input_number")
    List<UnitInput> getByInput(@Param("input_number") Integer input_number);
    //zapytanie parametryczne do bazy o konkretne wejscia danego urzadzenia
    // w zapytaniu to nie jest nazwa tabeli a nazwa klasy entity odnoszacej sie do danej tabeli

    @Transactional
    @Query("SELECT r FROM UnitInput r WHERE r.UnitNetIdent = :unit_net_ident")
    List<UnitInput> getByUnit(@Param("unit_net_ident") Integer unit_net_ident);

    @Transactional
    @Query("SELECT r FROM UnitInput r WHERE r.UnitNetIdent = :unit_net_ident AND r.InputNumber = :input_number")
    List<UnitInput> getByUnitAndInput(@Param("unit_net_ident") Integer unit_net_ident, @Param("input_number") Integer input_number);


}
