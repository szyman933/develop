package com.cloud.telemetry.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.List;

@Controller
public class RequestTypeController {


    @Autowired
    RequestTypeRepo requestTypeRepo;

    @Autowired
    UnitRequestRepo unitRequestRepo;

    @RequestMapping( value="/request" , method = RequestMethod.GET)
    public ModelAndView req(Model model) {

        List<RequestType> requestype = requestTypeRepo.getAllTypeReq();

        List<UnitRequest> requesty = unitRequestRepo.getNew10Req();

        model.addAttribute("listaTypow", requestype);
        model.addAttribute("listaRequestow", requesty);

        return new ModelAndView("request", "command", new NewRequest());
}



    @RequestMapping(value = "/addRequest", method={RequestMethod.POST, RequestMethod.GET})
    public ModelAndView addRequest(Model model,NewRequest polecenie) {


        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        UnitRequest r;
        r = new UnitRequest();
        r.setUnitNetIdent(polecenie.unit_net_ident);
        r.setRequestType(polecenie.request_type);
        r.setRegDate(timestamp);
        r.setUnit_input_id(polecenie.unit_input_id);
        r.setValue(polecenie.value);
        unitRequestRepo.saveAndFlush(r);

        List<UnitRequest> requesty = unitRequestRepo.getNew10Req();
        model.addAttribute("listaRequestow", requesty);

        return new ModelAndView("request", "command", new NewRequest());
    }








}
