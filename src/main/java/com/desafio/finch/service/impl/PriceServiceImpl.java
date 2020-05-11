package com.desafio.finch.service.impl;

import com.desafio.finch.model.Ingredient;
import com.desafio.finch.service.IngredientService;
import com.desafio.finch.service.PriceService;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    private IngredientService ingredientService;
    private double light;

    PriceServiceImpl(){
        this.light = 1;
        //10% de desconto OFF!
    }

    private List<Ingredient> promocoes(List<Ingredient> ingredients){
       //Light
        if(ingredients.contains("Alface") && !ingredients.contains("bacon")){
            //10% de desconto ON!
            light = 0.9;
        }

        //Muita Carne e Muito Queijo
        int countCarne=0;
        int countQueijo=0;
        for (Ingredient ingredient:ingredients){
            if (ingredient.getName() == "hamburguer"){
                countCarne += 1;
                if(countCarne == 3) {
                    countCarne = 0;
                    ingredients.remove(ingredient);
                }
            }
            if (ingredient.getName() == "queijo"){
                countQueijo += 1;
                if(countQueijo == 3){
                    countQueijo = 0;
                    ingredients.remove(ingredient);
                }
            }

        }

        return ingredients;
    }

    private List<Ingredient> getIngredientsByName(List<String> nomeIngredients){
        List<Ingredient> ingredients = null;
        for(String nomeIngredient: nomeIngredients){
            ingredients.add(ingredientService.IngredientByName(nomeIngredient));
        }

        return ingredients;
    }


    private double finalPrice(List<Ingredient> ingredients){
        double calc = 0;
        for(Ingredient ingredient: ingredients){
           calc += ingredient.getPrice();
        }
        return  (calc*light) ;
    }

    @Override
    public double calcPrice(List<String> nomeIngredients) {
        //Captura os nomes dos ingredientes para utilizar na função promocoes.
        List<Ingredient> ingredients = getIngredientsByName(nomeIngredients);
        //Promoções compara a lista de regras promocionais para verificar se o pedido possui alguma promocao.
        ingredients = promocoes(ingredients);

        return finalPrice(ingredients);
    }
}
