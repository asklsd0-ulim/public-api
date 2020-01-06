package gov.mfds.example.udi.enums;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class CobFlagCodeDeserializer extends JsonDeserializer<CobFlagCode> {
    @Override
    public CobFlagCode deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return CobFlagCode.valueOf(jsonParser.getValueAsString());
    }
}
