package com.cloud.telemetry.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class NewRegister {

    private Long id;

    private int input_device_id;

    private int unit_input_id;

    private String rw;

    private int index;

    private String active;

    private String description;

}
