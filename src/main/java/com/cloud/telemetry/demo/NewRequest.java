package com.cloud.telemetry.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@NoArgsConstructor
@Setter
@Getter
public class NewRequest {

    int unit_net_ident;
    int request_type;
    Timestamp regdate;
    int unit_input_id;
    int value;

}
