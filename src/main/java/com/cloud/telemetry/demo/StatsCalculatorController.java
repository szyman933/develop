package com.cloud.telemetry.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StatsCalculatorController {

    @RequestMapping("/stats")
    public String index(Model model) {

        StatsCalculator statsCalculator= new StatsCalculator();
        statsCalculator.calculateStats();
        statsCalculator.printStats();
        double max=statsCalculator.getMaxRAM() / statsCalculator.getMega();
        double mem=statsCalculator.getFreeRAM() / statsCalculator.getMega();
        int core=statsCalculator.getNumCores();
        model.addAttribute("core", core);
        model.addAttribute("memmax", max);
        model.addAttribute("mem", mem);

        return "stats";
    }





}
