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

    @RequestMapping("/charts")
    public ModelAndView charts(Model model) {

        //wypenienie listy dostepnych urządzen
        List<UnitInput> unit_input = unitInputRepo.findAll();
        model.addAttribute("listaUnitInput", unit_input);
        return new ModelAndView("charts", "command", new Chart());
    }


    @RequestMapping(value = "/chartunit", method={RequestMethod.POST, RequestMethod.GET})
    public ModelAndView charts(Model model,Chart wybor) {

        //wypelnienie listy wejsc wybranego urzadzenia
        modul = wybor.unit_net_ident;
        List<UnitInput> wejscia = unitInputRepo.getByUnit(wybor.unit_net_ident);
        model.addAttribute("listaUnitInput", wejscia);
        model.addAttribute("listaInput", wejscia);

        return new ModelAndView("charts", "command", new Chart());
    }

    @RequestMapping(value = "/chartinput", method={RequestMethod.POST, RequestMethod.GET})
    public ModelAndView chartsfeed(Model model,Chart wybor) {
        //listy do wypelnienia danymi z odczytow
        List<Integer> dane = new ArrayList(); //lista na wartosci odczytu
        List<String> opisy = new ArrayList();//lista na daty odczytu

        //pobranie z unit_input numeru urzadzenia i jego id wejscia
        if(modul == null || wybor.input_number == null){
                //idioto odpornosc na niewypelniony formularz, przekierowanie do bazowej strony charts
            return new ModelAndView("redirect:/charts");
        }else {

            List<UnitInput> unit_input = unitInputRepo.getByUnitAndInput(modul, wybor.input_number);
            UnitInput wybrany = unit_input.get(0);

            //pobranie odczytow dla danego urzadzenia o danym wejsciu
            List<Readings> readingsList = readingsRepo.getReadByUnitAndInput(wybrany.getUnitNetIdent(), Math.toIntExact(wybrany.getId()));

            //petla iteracyjna wypelniająca modele danymi
            for (Readings readings : readingsList) {
                dane.add(readings.getValue());
                opisy.add(readings.getReadDate().toString());
            }
        } //koniec if elsa na sprawdzanie czy dane z formularzy sa wypelnione
            model.addAttribute("dane", dane);
            model.addAttribute("opisy", opisy);

            //napelnienie listy unitow
            List<UnitInput> unit_input2 = unitInputRepo.findAll();
            model.addAttribute("listaUnitInput", unit_input2);

            return new ModelAndView("charts", "command", new Chart());

    }



}
