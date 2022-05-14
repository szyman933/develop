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

    Integer modul;
    private static final String LISTUNIT = "listaUnit";
    private static final String VIEWMODEL = "charts";
    private static final String MODELNAME = "command";

    @RequestMapping("/charts")
    public ModelAndView charts(Model model) {

        List<Unit> units = unitRepo.findAll();
        model.addAttribute(LISTUNIT, units);
        return new ModelAndView(VIEWMODEL, MODELNAME, new Chart());
    }


    @RequestMapping(value = "/chartunit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView charts(Model model, Chart chart) {

        modul = chart.getNetIdent();
        List<UnitInput> inputs = unitInputRepo.getByUnit(chart.getNetIdent());
        List<Unit> units = unitRepo.getByUnit(modul);
        model.addAttribute(LISTUNIT, units);
        model.addAttribute("listaInput", inputs);

        return new ModelAndView(VIEWMODEL, MODELNAME, new Chart());
    }

    @RequestMapping(value = "/chartinput", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView chartsfeed(Model model, Chart chart) {

        List<Integer> values = new ArrayList<>();
        List<String> labels = new ArrayList<>();

        if (modul == null || chart.getInputNumber() == null) {

            return new ModelAndView("redirect:/charts");
        } else {

            List<UnitInput> unitInput = unitInputRepo.getByUnitAndInput(modul, chart.getInputNumber());
            UnitInput chosen = unitInput.get(0);
            Integer inputId = Math.toIntExact(chosen.getId());

            List<Reading> readingsList = readingsRepo.getReadByUnitAndInput(chosen.getUnitNetIdent(), inputId);

            for (Reading readings : readingsList) {
                values.add(readings.getValue());
                labels.add(readings.getReadDate().toString());
            }
        }
        model.addAttribute("values", values);
        model.addAttribute("labels", labels);

        List<Unit> units = unitRepo.findAll();
        model.addAttribute(LISTUNIT, units);

        return new ModelAndView(VIEWMODEL, MODELNAME, new Chart());

    }


}
