package com.cloud.telemetry.demo;


import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "readings")
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Reading implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "unit_id")
    private Integer unitId;

    @Column(name = "unit_input_id")
    private Integer unitInputId;

    @Column(name = "value")
    private Integer value;

    @Column(name = "read_date")
    private Timestamp readDate;

    @Column(name = "param_id")
    private Integer paramId;


    public Long getId() {
        return id;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public Integer getUnitInputId() {
        return unitInputId;
    }

    public Integer getValue() {
        return value;
    }

    public Timestamp getReadDate() {
        return readDate;
    }

    public Integer getParamId() {
        return paramId;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public void setUnitInputId(Integer unitInputId) {
        this.unitInputId = unitInputId;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setReadDate(Timestamp readDate) {
        this.readDate = readDate;
    }

    public void setParamId(Integer paramId) {
        this.paramId = paramId;
    }
}
