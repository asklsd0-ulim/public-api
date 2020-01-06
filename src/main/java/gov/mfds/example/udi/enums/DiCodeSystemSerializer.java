package gov.mfds.example.udi.enums;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class DiCodeSystemSerializer extends JsonSerializer<DiCodeSystem> {
    @Override
    public void serialize(DiCodeSystem diCodeSystem, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(diCodeSystem.name());
    }
}
