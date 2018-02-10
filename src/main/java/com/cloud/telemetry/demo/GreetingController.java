package com.cloud.telemetry.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class GreetingController {
    @Autowired
    ReadingsRepo readingsRepo;

    @Autowired
    UnitRequestRepo unitRequestRepo;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
/*
        List<UnitRequest> requesty = unitRequestRepo.getUnitRequests(1);

        List<Readings> myMethod = readingsRepo.getMyMethod(1);
        //List<Readings> myMethod = readingsRepo.findAll();
       // List<Readings> readingsList = readingsRepo.getMyMethod(1);

        Readings r;
        r = new Readings();
        r.setUnitId(1);
        r.setUnitInputId(6);
        r.setValue(33);
        r.setValue(10);
        r = readingsRepo.save(r);

        model.addAttribute("name", name);

        //model.addAttribute("list", readingsList);
*/
        return "greeting";
    }


}