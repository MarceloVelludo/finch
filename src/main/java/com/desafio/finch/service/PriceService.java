package com.desafio.finch.service;

import com.desafio.finch.model.Ingredient;

import java.util.List;

public interface PriceService {

    double calcPrice(List<String> NomeIngredients);

}
