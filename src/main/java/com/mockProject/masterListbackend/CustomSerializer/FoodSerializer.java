package com.mockProject.masterListbackend.CustomSerializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.mockProject.masterListbackend.Enum.Food;

import java.io.IOException;

public class FoodSerializer extends JsonSerializer<Food> {
    @Override
    public void serialize(Food food, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(food.getDisplayName());
    }
}
