package com.cloud.telemetry.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.sql.Timestamp;
import java.util.List;


@Slf4j
@Controller
public class RequestTypeController {

    @Autowired
    RequestTypeRepo requestTypeRepo;

    @Autowired
    UnitRequestRepo unitRequestRepo;

    @Autowired
    UnitRepo unitRepo;

    @RequestMapping(value = "/request", method = RequestMethod.GET)
    public ModelAndView req(Model model) {

        List<RequestType> requestype = requestTypeRepo.getAllTypeReq();
        model.addAttribute("listaTypow", requestype);

        List<UnitRequest> requesty = unitRequestRepo.getNew10Req();
        model.addAttribute("listaRequestow", requesty);

        List<Units> unity = unitRepo.getUnits();
        model.addAttribute("listaUnitow", unity);

        return new ModelAndView("request", "command", new NewRequest());
    }

    @RequestMapping(value = "/addRequest", method = {RequestMethod.POST})
    public ModelAndView addRequest(Model model, @Validated NewRequest polecenie, BindingResult bindingResult) {


        Timestamp timestamp = new Timestamp(System.currentTimeMillis()); //generowany czas wpisania requestu do bazy

        UnitRequest r; //wypełnianie nowej instancji encji UnitRequest
        r = new UnitRequest();
        r.setUnitNetIdent(polecenie.unit_net_ident);
        r.setRequestType(polecenie.request_type);
        r.setRegDate(timestamp);
        r.setUnitInputId(polecenie.unit_input_id);
        r.setValue(polecenie.value);
        r.setRegister(polecenie.register);
        log.info("Add new request ".concat(r.toString()));

        unitRequestRepo.saveAndFlush(r); //zapis do bazy

        //przekierowanie  na strone request i wypełnienie modelu danymi potrzebnymi na stronie
        List<UnitRequest> requesty = unitRequestRepo.getNew10Req();
        model.addAttribute("listaRequestow", requesty);

        List<RequestType> requestype = requestTypeRepo.getAllTypeReq();
        model.addAttribute("listaTypow", requestype);

        List<Units> unity = unitRepo.getUnits();
        model.addAttribute("listaUnitow", unity);

        return new ModelAndView("redirect:/request", "command", new NewRequest());
    }


}
