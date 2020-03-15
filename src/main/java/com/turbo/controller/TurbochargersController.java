package com.turbo.controller;

import com.turbo.service.TurbochargerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TurbochargersController {

    private TurbochargerService turbochargerService;

    @Autowired
    public TurbochargersController(TurbochargerService turbochargerService) {
        this.turbochargerService = turbochargerService;
    }

    @GetMapping("/turbochargers")
    public String turbochargers(Model model){
        model.addAttribute("turbos", turbochargerService.getAllTurbos());
        return "turbochargers";
    }

}
