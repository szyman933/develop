package com.cloud.telemetry.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
@NoArgsConstructor
@Setter
@Getter
public class Chart {

    Integer unit_net_ident;
    Integer input_number;
    Timestamp datedown;
    Timestamp dateup;
}
