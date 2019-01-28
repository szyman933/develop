package com.cloud.telemetry.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
@NoArgsConstructor
@Setter
@Getter
class Chart {

    private Integer unitNetIdent;
    private Integer inputNumber;
    private Integer netIdent;
    private Timestamp dateDown;
    private Timestamp dateUp;
}
