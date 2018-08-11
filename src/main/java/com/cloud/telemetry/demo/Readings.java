package com.cloud.telemetry.demo;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table( name = "readings")
@Setter
@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Readings implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "unit_id")
    private Integer UnitId;

    @Column(name = "unit_input_id")
    private Integer UnitInputId;

    @Column(name = "value")
    private Integer Value;

    @Column(name = "read_date")
    private Timestamp ReadDate;

    @Column(name = "param_id")
    private Integer Param_id;

}
