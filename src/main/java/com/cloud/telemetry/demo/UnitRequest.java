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

    @Column(name = "unit_net_ident")
    private Integer UnitNetIdent;

    @Column(name = "request_type")
    private Integer RequestType;

    @Column(name = "reg_date")
    private Timestamp RegDate;

    @Column(name = "send_date")
    private Timestamp SendDate;

    @Column(name = "unit_input_id")
    private Integer unit_input_id;

    @Column(name = "value")
    private Integer Value;



}
