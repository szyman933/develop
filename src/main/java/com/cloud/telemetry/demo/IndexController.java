package com.cloud.telemetry.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    ReadingsRepo readingsRepo;


    @RequestMapping("/")
    public String index(Model model) {

        List<Readings> readingsList = readingsRepo.getLatestTenCorrect();
        List<Integer> dane = new ArrayList();
        dane.add(1);
        dane.add(2);
        dane.add(3);
        model.addAttribute("lista", readingsList);
        model.addAttribute("wykres", dane);

        return "index";
    }

    }




