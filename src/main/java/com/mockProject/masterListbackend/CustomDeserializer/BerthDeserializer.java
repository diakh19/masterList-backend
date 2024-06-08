package com.mockProject.masterListbackend.CustomDeserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.mockProject.masterListbackend.Enum.Berth;

import java.io.IOException;

public class BerthDeserializer extends JsonDeserializer<Berth> {
    @Override
    public Berth deserialize(JsonParser p, DeserializationContext context) throws IOException{
        String displayName=p.getText();
        for(Berth berth:Berth.values()){
            if(berth.getDisplayName().equals(displayName)){
                return berth;
            }
        }
        throw new IllegalArgumentException("Unknown berth:"+displayName);
    }

}
