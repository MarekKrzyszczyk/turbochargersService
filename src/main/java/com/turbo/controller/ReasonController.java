package com.turbo.controller;

import com.turbo.service.PartService;
import com.turbo.service.ReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReasonController {

    private ReasonService reasonService;

    @Autowired
    public ReasonController(ReasonService reasonService) {
        this.reasonService = reasonService;
    }

    @GetMapping("/reasons")
    public String parts(Model model){
        model.addAttribute("reasons", reasonService.getAllParts());
        return "reasons";
    }

}
