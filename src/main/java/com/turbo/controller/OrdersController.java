package com.turbo.controller;

import com.turbo.model.Order;
import com.turbo.service.OrderService;
import com.turbo.service.PartService;
import com.turbo.service.ReasonService;
import com.turbo.service.TurbochargerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class OrdersController {

    private TurbochargerService turbochargerService;
    private PartService partService;
    private ReasonService reasonService;
    private OrderService orderService;

    @Autowired
    public OrdersController(TurbochargerService turbochargerService, PartService partService, ReasonService reasonService, OrderService orderService) {
        this.turbochargerService = turbochargerService;
        this.partService = partService;
        this.reasonService = reasonService;
        this.orderService = orderService;
    }


    @GetMapping("/create")
    public String createOrder(Model model) {
        model.addAttribute("orderTurbos", turbochargerService.getAllTurbos());
        model.addAttribute("partTurbos", partService.getAllParts());
        model.addAttribute("reasonsTurbos", reasonService.getAllReasons());
        model.addAttribute("order", new Order());
        return "newOrder";
    }

    @PostMapping("/create")
    public String createNewOrder(
            @ModelAttribute @Valid Order order,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "newOrder";
        }
        orderService.createNewOrder(order.getTurbocharger(), order.getParts(), order.getReason());
        return "redirect:/";

    }

}
