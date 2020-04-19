package com.turbo.controller;

import com.turbo.service.PartService;
import com.turbo.service.ReasonService;
import com.turbo.service.TurbochargerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrdersController {

    private TurbochargerService turbochargerService;
    private PartService partService;
    private ReasonService reasonService;

    @Autowired
    public OrdersController(TurbochargerService turbochargerService, PartService partService, ReasonService reasonService) {
        this.turbochargerService = turbochargerService;
        this.partService = partService;
        this.reasonService = reasonService;
    }

    @GetMapping("/neworder")
    public String newOrder (Model model){
        model.addAttribute("orderTurbos", turbochargerService.getAllTurbos());
        model.addAttribute("partTurbos",  partService.getAllParts());
        model.addAttribute("reasonsTurbos", reasonService.getAllReasons());
return "newOrder";
    }


}
