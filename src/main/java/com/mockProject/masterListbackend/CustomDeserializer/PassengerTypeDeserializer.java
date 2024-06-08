package com.mockProject.masterListbackend.CustomDeserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.mockProject.masterListbackend.Enum.PassengerType;

import java.io.IOException;

public class PassengerTypeDeserializer extends JsonDeserializer<PassengerType> {
    @Override
    public PassengerType deserialize(JsonParser p, DeserializationContext context) throws IOException {
        String displayName=p.getText();
        for(PassengerType passengerType:PassengerType.values()){
            if(passengerType.getDisplayName().equals(displayName)){
                return passengerType;
            }
        }
        throw new IllegalArgumentException("Unknown Passenger Type:"+displayName);
    }
}
