package com.mockProject.masterListbackend.CustomSerializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.mockProject.masterListbackend.Enum.Berth;

import java.io.IOException;

public class BerthSerializer extends JsonSerializer<Berth> {
    @Override
    public void serialize(Berth berth, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(berth.getDisplayName());
    }
}
