package com.cloud.telemetry.demo;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table( name = "unit")
@Setter
@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Units implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "unit_type")
    private Integer UnitType;

    @Column(name = "net_ident")
    public Integer NetIdent;

    @Column(name = "reg_date")
    private Timestamp RegDate;


}
