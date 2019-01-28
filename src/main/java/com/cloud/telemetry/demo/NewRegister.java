package com.cloud.telemetry.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
class NewRegister {

    private Long id;

    private int inputDeviceId;

    private int unitInputId;

    private String rw;

    private int index;

    private String active;

    private String description;

}
