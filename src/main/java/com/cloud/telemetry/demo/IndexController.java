package com.cloud.telemetry.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    ReadingsRepo readingsRepo;


    @RequestMapping("/")
    public String index(Model model) {

        List<Readings> readingsList = readingsRepo.getLatestTen();
        model.addAttribute("lista", readingsList);


        return "index";
    }





}
