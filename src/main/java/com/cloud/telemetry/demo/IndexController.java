package com.cloud.telemetry.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    ReadingsRepo readingsRepo;


    @RequestMapping("/")
    public String index(Model model) {

        List<Reading> readingsList = readingsRepo.getLatestTenCorrect();
        List<Integer> valueList = new ArrayList<>();
        List<String> dataList = new ArrayList<>();


        for (Reading readings : readingsList) {
            valueList.add(readings.getValue());
            dataList.add(readings.getReadDate().toString());
        }

        model.addAttribute("lista", readingsList);
        model.addAttribute("dane", valueList);
        model.addAttribute("opisy", dataList);

        return "index";
    }

}




