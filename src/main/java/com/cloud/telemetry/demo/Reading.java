package com.cloud.telemetry.demo;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Setter
@Getter
@Table(name = "readings")
@ToString
@NoArgsConstructor
@EqualsAndHashCode
class Reading implements Serializable {

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

}
