package com.turbo.controller;

import com.turbo.model.Turbocharger;
import com.turbo.service.TurbochargerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TurbochargersController {

    private TurbochargerService turbochargerService;

    @Autowired
    public TurbochargersController(TurbochargerService turbochargerService) {
        this.turbochargerService = turbochargerService;
    }

    @GetMapping("/turbochargers")
    public String turbochargers(Model model) {
        model.addAttribute("turbos", turbochargerService.getAllTurbos());
        return "turbochargers";
    }

    @GetMapping("/addTurbo")
    public String addTurbo(Model model) {
        model.addAttribute("turbo", new Turbocharger());
        return "addTurbo";
    }

    @PostMapping("/addTurbo")
    public String addTurbo(@ModelAttribute @Valid Turbocharger turbocharger, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addTurbo";
        }
        turbochargerService.addTurbo(turbocharger.getNumber(), turbocharger.getModel(), turbocharger.getProducer());
        return "redirect:/turbochargers";
    }

    @GetMapping(value = "/deleteTurbo/{id}")
    private String deleteTurbo(@PathVariable(name = "id") Integer id) {
        turbochargerService.deleteTurbo(id);
        return "redirect:/turbochargers";
    }

    @GetMapping("/updateTurbo/{id}")
    private String getUpdatedTurbo(@PathVariable(name = "id") Integer id, Model model) {
        model.addAttribute("updTurbo", turbochargerService.findTurboById(id));
        return "updateTurbo";
    }

//    @GetMapping("/updateTurbo")
//    private String getUpdatedTurboSite(Model model, @ModelAttribute Turbocharger turbo) {
//        turbochargerService.findTurboById(turbo.getId());
//        return "updateTurbo";
//    }

    @PostMapping("/updateTurbo/{id}")
    private String updateTurbo(@ModelAttribute @Valid Turbocharger turbo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(objectError -> System.out.println(objectError.getDefaultMessage()));
            return "turbochargers";
        }
        turbochargerService.updateTurbo(turbo);
        return "redirect:/turbochargers";
    }

}
