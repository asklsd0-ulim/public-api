package gov.mfds.example.udi.enums;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class CobFlagCodeSerializer extends JsonSerializer<CobFlagCode> {
    @Override
    public void serialize(CobFlagCode cobFlagCode, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(cobFlagCode.getCode());
    }
}
