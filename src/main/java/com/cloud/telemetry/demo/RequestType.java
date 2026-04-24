package com.cloud.telemetry.demo;

import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "request_type")
@Setter
@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class RequestType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "request")
    private String request;


}
