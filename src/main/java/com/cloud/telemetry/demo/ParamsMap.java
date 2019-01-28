package com.cloud.telemetry.demo;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table( name = "params_map")
@ToString
@NoArgsConstructor
@EqualsAndHashCode
class ParamsMap implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "inputDeviceId")
    private Integer inputDeviceId;

    @Column(name = "unitInputId")
    private Integer unitInputId;

    @Column(name = "rw")
    private String rw;

    @Column(name = "index")
    private Integer index;

    @Column(name = "active")
    private String active;

    @Column(name = "description")
    private String description;

}
