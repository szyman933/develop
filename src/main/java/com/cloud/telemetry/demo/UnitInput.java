package com.cloud.telemetry.demo;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "unit_input")
@Setter
@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class UnitInput implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "unitNetIdent")
    private Integer unitNetIdent;

    @Column(name = "input_type_id")
    private Integer inputTypeID;

    @Column(name = "input_number")
    private Integer inputNumber;


}
