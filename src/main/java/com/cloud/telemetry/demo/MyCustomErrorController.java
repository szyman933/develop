package com.cloud.telemetry.demo;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

public class MyCustomErrorController implements ErrorController {
	  
    private static final String PATH = "/error";
     
    @RequestMapping(value=PATH)
    public String error() {
        return "Error heaven";
    }
 
    @Override
    public String getErrorPath() {
        return PATH;
    }
}
