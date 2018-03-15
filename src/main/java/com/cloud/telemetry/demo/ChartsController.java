package com.cloud.telemetry.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ChartsController {

    @Autowired
    ReadingsRepo readingsRepo;

    @Autowired
    UnitRepo unitRepo;

    @Autowired
    UnitInputRepo unitInputRepo;


    @RequestMapping("/charts")
    public ModelAndView charts(Model model) {


        List<UnitInput> unit_input = unitInputRepo.findAll();
        model.addAttribute("listaUnitInput", unit_input);
        return new ModelAndView("charts", "command", new Chart());
    }


    @RequestMapping(value = "/chartunit", method={RequestMethod.POST, RequestMethod.GET})
    public ModelAndView charts(Model model,Chart wybor) {


        List<UnitInput> wejscia = unitInputRepo.getByUnit(wybor.unit_net_ident);

        model.addAttribute("listaUnitInput", wejscia);
        model.addAttribute("listaInput", wejscia);

        return new ModelAndView("charts", "command", new Chart());
    }
/*
    @RequestMapping("/chartinput")
    public ModelAndView charts(Model model) {


        List<UnitInput> unit_input = unitInputRepo.findAll();
        model.addAttribute("listaUnitInput", unit_input);
        return new ModelAndView("charts", "command", new Chart());
    }
*/


}
