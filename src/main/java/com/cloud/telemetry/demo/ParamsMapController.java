package com.cloud.telemetry.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ParamsMapController {


    @Autowired
    ParamsMapRepo paramsMapRepo;


    // przekazanie listy parametrow
    @RequestMapping( value="/registers" , method ={ RequestMethod.GET, RequestMethod.POST})
    public String registers(Model model) {

        List<ParamsMap> parametry = paramsMapRepo.findAll();

        model.addAttribute("params", parametry);

        return "registers";
    }






}
