package com.cloud.telemetry.demo;

import com.cloud.telemetry.demo.StatsCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StatsCalculatorController {

 //   @Autowired
 //   StatsCalculator statsCalculator;
   // UnitRepo unitRepo;

    @RequestMapping("/stats")
    public String index(Model model) {

        //List<Units> unity = unitRepo.getUnits();
        StatsCalculator statsCalculator= new StatsCalculator();
        statsCalculator.calculateStats();
        statsCalculator.printStats();
        double max=statsCalculator.getMaxRAM();
        double mem=statsCalculator.getFreeRAM();
        int core=statsCalculator.getNumCores();
        model.addAttribute("core", core);
        model.addAttribute("memmax", max);
        model.addAttribute("mem", mem);

        return "stats";
    }





}
