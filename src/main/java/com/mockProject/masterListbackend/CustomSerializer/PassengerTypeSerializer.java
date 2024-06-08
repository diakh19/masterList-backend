package com.mockProject.masterListbackend.CustomSerializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.mockProject.masterListbackend.Enum.PassengerType;

import java.io.IOException;

public class PassengerTypeSerializer  extends JsonSerializer<PassengerType> {
    @Override
    public void serialize(PassengerType passengerType, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(passengerType.getDisplayName());
    }
}
