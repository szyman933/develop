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
        List<Integer> dane = new ArrayList(); //lista na wartosci odczytu
        List<String> opisy = new ArrayList();//lista na daty odczytu

        //petla iteracyjna wypelniająca modele danymi
        for (Readings readings : readingsList) {
            dane.add(readings.getValue());
            opisy.add(readings.getReadDate().toString());
        }

        model.addAttribute("lista", readingsList);
        model.addAttribute("dane", dane);
        model.addAttribute("opisy", opisy);

        return "index";
    }

    }




