package com.cloud.telemetry.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Null;
import java.sql.Timestamp;

@NoArgsConstructor
@Setter
@Getter
public class NewRequest {

    int unitNetIdent;
    int requestType;
    Timestamp regdate;
    int unitInputId;
    int value;
    int register;

}

