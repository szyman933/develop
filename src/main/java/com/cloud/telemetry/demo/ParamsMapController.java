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
import java.util.logging.Level;
import java.util.logging.Logger;


import static java.sql.Types.NULL;


@Controller
public class ParamsMapController {

    private final static  String PARAMS = "params";
    protected final Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    ParamsMapRepo paramsMapRepo;


    // przekazanie listy parametrow
    @RequestMapping(value = "/registers", method = {RequestMethod.GET, RequestMethod.POST})
    public String registers(Model model) {

        List<ParamsMap> parametry = paramsMapRepo.findAll();

        model.addAttribute(PARAMS, parametry);

        return "registers";
    }


    @RequestMapping(value = "/updateActive", method = {RequestMethod.POST})
    public String updateParamMap(Model model, @Validated NewRegister mapa, BindingResult bindingResult) {

        ParamsMap r = new ParamsMap();
        r.setId(mapa.getId());
        r.setActive(mapa.getActive());
        r.setIndex(mapa.getIndex());

        logger.log(Level.INFO," Change active parameter: {0} ",r);

        if (mapa.getIndex() == NULL) {

            paramsMapRepo.updateActivebyId(mapa.getId(), mapa.getActive());

        } else {
            paramsMapRepo.updateActivebyIndexNative(mapa.getActive(), mapa.getIndex());
        }


        //ponowne pobranie aktualnej listy
        List<ParamsMap> parametry = paramsMapRepo.findAll();

        model.addAttribute(PARAMS, parametry);

        return "registers";
    }


    @RequestMapping(value = "/addRegister", method = {RequestMethod.POST})
    public ModelAndView addRegister(Model model, NewRegister mapa) {


        ParamsMap r = new ParamsMap();
        r.setInputDeviceId(mapa.getInput_device_id());
        r.setUnitInputId(mapa.getUnit_input_id());
        r.setRW(mapa.getRw());
        r.setIndex(mapa.getIndex());
        r.setActive(mapa.getActive());
        r.setDescription(mapa.getDescription());


        paramsMapRepo.insertNewReg(mapa.getInput_device_id(), mapa.getUnit_input_id(), mapa.getRw(), mapa.getIndex(), mapa.getActive(), mapa.getDescription());

        logger.log(Level.INFO," Adding new register: {0} ",r);

        //ponowne pobranie aktualnej listy
        List<ParamsMap> parametry = paramsMapRepo.findAll();

        model.addAttribute(PARAMS, parametry);

        return new ModelAndView("redirect:/registers", "command", new NewRegister());
    }


}
