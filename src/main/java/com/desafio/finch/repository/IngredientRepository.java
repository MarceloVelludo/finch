package com.desafio.finch.repository;

import com.desafio.finch.model.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

//CRUD
public interface IngredientRepository extends MongoRepository<Ingredient, String> {

    Ingredient findByName(@Param("name") String name);

}
