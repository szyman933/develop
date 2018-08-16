package com.cloud.telemetry.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static java.sql.Types.NULL;

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



    @RequestMapping(value = "/updateActive", method={RequestMethod.POST})
    public String updateParamMap(Model model, @Validated NewRegister mapa,BindingResult bindingResult ) {



        //update na bazie
        ParamsMap r = new ParamsMap();
        r.setId(mapa.id);
        r.setActive(mapa.active);
        r.setIndex(mapa.index);
        System.out.println(r);
        if(mapa.index == NULL){

            paramsMapRepo.updateActivebyId(mapa.id,mapa.active);

        }else{     paramsMapRepo.updateActivebyIndexNative(mapa.active,mapa.index);        };


        //ponowne pobranie aktualnej listy
        List<ParamsMap> parametry = paramsMapRepo.findAll();

        model.addAttribute("params", parametry);

        return "registers";
    }


    @RequestMapping(value = "/addRegister", method={RequestMethod.POST})
    public ModelAndView addRegister(Model model, NewRegister mapa ) {




        ParamsMap r = new ParamsMap();
        r.setInputDeviceId(mapa.input_device_id);
        r.setUnitInputId(mapa.unit_input_id);
        r.setRW(mapa.rw);
        r.setIndex(mapa.index);
        r.setActive(mapa.active);
        r.setDescription(mapa.description);



        System.out.println(r);

        paramsMapRepo.insertNewReg(mapa.input_device_id,mapa.unit_input_id,mapa.rw,mapa.index,mapa.active,mapa.description);




        //ponowne pobranie aktualnej listy
        List<ParamsMap> parametry = paramsMapRepo.findAll();

        model.addAttribute("params", parametry);

        return new ModelAndView("redirect:/registers", "command", new NewRegister());
    }





}
