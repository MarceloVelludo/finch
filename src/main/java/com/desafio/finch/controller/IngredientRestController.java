package com.desafio.finch.controller;


import com.desafio.finch.model.Ingredient;
import com.desafio.finch.service.IngredientService;
import com.desafio.finch.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientRestController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping(value = "/all")
    public List<Ingredient> getAllIngredient() {
        return ingredientService.findAll();
    }

    @GetMapping(value = "/ByName/{name}")
    public Ingredient getIngredientByName (@PathVariable String name) {
        return  ingredientService.IngredientByName(name);
    }

    @PostMapping(value = "/saveAll")
    public ResponseEntity<?> saveOrUpdateAll(@RequestBody List<Ingredient> ingredients) {
        for (Ingredient ingredient:ingredients){
            ingredientService.saveOrUpdateIngredient(ingredient);
        }

        return new ResponseEntity("Ingredients adicionado corretamente!", HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveOrUpdateIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.saveOrUpdateIngredient(ingredient);
        return new ResponseEntity("Ingredient adicionado corretamente!", HttpStatus.OK);
    }

    @DeleteMapping(value =  "/delete/{id}")
    public ResponseEntity deleteIngredient(@PathVariable String id){
        System.out.println(id);
        ingredientService.deleteIngredientById(id);
        return  new ResponseEntity("Ingredient deletado corretamente!", HttpStatus.OK);
    }



}
