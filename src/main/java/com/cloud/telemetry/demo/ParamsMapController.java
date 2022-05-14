package com.cloud.telemetry.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static java.sql.Types.NULL;


@Slf4j
@Controller
public class ParamsMapController {

    private static String PARAMS = "params";


    @Autowired
    ParamsMapRepo paramsMapRepo;

    @RequestMapping(value = "/registers", method = {RequestMethod.GET, RequestMethod.POST})
    public String registers(Model model) {

        List<ParamsMap> parameters = paramsMapRepo.findAll();

        model.addAttribute(PARAMS, parameters);

        return "registers";
    }


    @PostMapping(value = "/updateActive")
    public String updateParamMap(Model model, @Validated NewRegister mapa, BindingResult bindingResult) {

        ParamsMap r = new ParamsMap();
        r.setId(mapa.getId());
        r.setActive(mapa.getActive());
        r.setIndex(mapa.getIndex());

        log.info(" Change active parameter: {0} ".concat(r.toString()));

        if (mapa.getIndex() == NULL) {

            paramsMapRepo.updateActivebyId(mapa.getId(), mapa.getActive());

        } else {
            paramsMapRepo.updateActivebyIndexNative(mapa.getActive(), mapa.getIndex());
        }

        List<ParamsMap> parametry = paramsMapRepo.findAll();

        model.addAttribute(PARAMS, parametry);

        return "registers";
    }


    @PostMapping(value = "/addRegister")
    public ModelAndView addRegister(Model model, NewRegister map) {

        ParamsMap r = new ParamsMap();
        r.setInputDeviceId(map.getInputDeviceId());
        r.setUnitInputId(map.getUnitInputId());
        r.setRw(map.getRw());
        r.setIndex(map.getIndex());
        r.setActive(map.getActive());
        r.setDescription(map.getDescription());

        paramsMapRepo.insertNewReg(map.getInputDeviceId(), map.getUnitInputId(), map.getRw(), map.getIndex(), map.getActive(), map.getDescription());

        log.info("Adding new register:".concat(r.toString()));

        List<ParamsMap> parameters = paramsMapRepo.findAll();

        model.addAttribute(PARAMS, parameters);

        return new ModelAndView("redirect:/registers", "command", new NewRegister());
    }


}
