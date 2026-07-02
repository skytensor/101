package com.project.code.controller;

import com.project.code.model.Pizza;
import com.project.code.repository.PizzaRepository;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pizza")
public class PizzaApiController {

    private final PizzaRepository pizzaRepository;

    public PizzaApiController(PizzaRepository pizzaRepository) {

        this.pizzaRepository = pizzaRepository;

    }

    @PostMapping
    public String addPizza(@RequestBody Pizza pizza) {

        pizzaRepository.save(pizza);
        return "Pizza added with id: " + pizza.getId();

    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public String delete(@PathVariable Long id) {

        pizzaRepository.deleteById(id);
        return "Pizza deleted with id: " + id;

    }

}
