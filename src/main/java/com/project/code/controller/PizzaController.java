package com.project.code.controller;

import com.project.code.model.Pizza;
import com.project.code.repository.PizzaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pizza")
public class PizzaController {

    private final PizzaRepository pizzaRepository;

    public PizzaController(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @GetMapping("/{id}")
    public String getPizza(
            @PathVariable Long id,
            Model model
    ) {

        Pizza pizza = pizzaRepository.findById(id).orElseThrow();
        model.addAttribute("pizza", pizza);
        return "pizza";

    }

}
