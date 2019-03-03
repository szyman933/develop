package com.cloud.telemetry.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UnitsController {

    @Autowired
    private UnitRepo unitRepo;

    @RequestMapping("/units")
    public String index(Model model) {

        List<Unit> units = unitRepo.getUnits();
        model.addAttribute("listaUnit", units);

        return "units";
    }

}
