package com.mockProject.masterListbackend.CustomDeserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.mockProject.masterListbackend.Enum.Food;

import java.io.IOException;

public class FoodDeserializer extends JsonDeserializer<Food> {
    @Override
    public Food deserialize(JsonParser p, DeserializationContext context) throws IOException {
        String displayName=p.getText();
        for(Food food:Food.values()){
            if(food.getDisplayName().equals(displayName)){
                return food;
            }
        }
        throw new IllegalArgumentException("Unknown Food Choice:"+displayName);
    }
}
