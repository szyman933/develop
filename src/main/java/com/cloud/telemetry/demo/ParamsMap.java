package com.cloud.telemetry.demo;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "params_map")
@Setter
@Getter
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


}
