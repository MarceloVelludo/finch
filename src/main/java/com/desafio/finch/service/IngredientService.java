package com.desafio.finch.service;

import  com.desafio.finch.model.Ingredient;

import java.util.List;

public interface IngredientService {

    List<Ingredient> findAll();

    Ingredient saveOrUpdateIngredient(Ingredient ingredient);

    Ingredient IngredientByName(String Name);

    void deleteIngredientById(String id);

}
