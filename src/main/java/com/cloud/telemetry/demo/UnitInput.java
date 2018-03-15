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

    @Column(name = "unit_net_ident")
    private Integer UnitNetIdent;

    @Column(name = "input_type_id")
    private Integer InputTypeID;

    @Column(name = "input_number")
    private Integer InputNumber;


}
