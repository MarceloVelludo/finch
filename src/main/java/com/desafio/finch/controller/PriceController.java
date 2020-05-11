package com.desafio.finch.controller;

import com.desafio.finch.model.Ingredient;
import com.desafio.finch.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/price")
public class PriceController {
    @Autowired
    private PriceService priceService;

    @GetMapping(value = "/calcPrice")
    public int getResultadoPreco(@RequestBody List<String> NomeIngredients) {
        return priceService.calcPrice(NomeIngredients);
    }
}
