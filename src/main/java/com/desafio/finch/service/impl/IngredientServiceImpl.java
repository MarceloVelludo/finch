package com.desafio.finch.service.impl;

import com.desafio.finch.model.Ingredient;
import com.desafio.finch.repository.IngredientRepository;
import com.desafio.finch.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient saveOrUpdateIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public void deleteIngredientById(String id) {
        ingredientRepository.deleteById(id);
    }

    @Override
    public Ingredient IngredientByName(String Name) {
        return ingredientRepository.findByName(Name);
    }

}
