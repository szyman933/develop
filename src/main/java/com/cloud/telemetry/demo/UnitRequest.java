package com.cloud.telemetry.demo;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table( name = "unit_request")
@Setter
@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class UnitRequest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "unitNetIdent")
    private Integer unitNetIdent;

    @Column(name = "requestType")
    private Integer requestType;

    @Column(name = "reg_date")
    private Timestamp regDate;

    @Column(name = "send_date")
    private Timestamp sendDate;

    @Column(name = "unitInputId")
    private Integer unitInputId;

    @Column(name = "value")
    private Integer value;

    @Column(name = "register")
    private Integer register;



}
