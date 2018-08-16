package com.cloud.telemetry.demo;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "params_map")
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class ParamsMap implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "input_device_id")
    private Integer InputDeviceId;

    @Column(name = "unit_input_id")
    private Integer UnitInputId;

    @Column(name = "rw")
    private String RW;

    @Column(name = "index")
    private Integer Index;

    @Column(name = "active")
    private String Active;

    @Column(name = "description")
    private String Description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Integer getInputDeviceId() {
        return InputDeviceId;
    }

    public void setInputDeviceId(Integer inputDeviceId) {
        InputDeviceId = inputDeviceId;
    }

    public Integer getUnitInputId() {
        return UnitInputId;
    }

    public void setUnitInputId(Integer unitInputId) {
        UnitInputId = unitInputId;
    }

    public String getRW() {
        return RW;
    }

    public void setRW(String RW) {
        this.RW = RW;
    }

    public Integer getIndex() {
        return Index;
    }

    public void setIndex(Integer index) {
        Index = index;
    }

    public String getActive() {
        return Active;
    }

    public void setActive(String active) {
        Active = active;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
