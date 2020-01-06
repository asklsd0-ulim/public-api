package gov.mfds.example.udi.enums;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class DiCodeSystemDeserializer extends JsonDeserializer<DiCodeSystem> {
    @Override
    public DiCodeSystem deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return DiCodeSystem.valueOf(jsonParser.getValueAsString());
    }
}
