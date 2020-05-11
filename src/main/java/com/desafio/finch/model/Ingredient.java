package com.desafio.finch.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "ingredients")
public class Ingredient{
    @Id
    private String id;
    private String name;
    private double price;

    public Ingredient(){
    }

    public Ingredient(@NonNull @JsonProperty("name") String name, @JsonProperty("price") int price){
        this.name = name;
        this.price = price;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public double getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

}
