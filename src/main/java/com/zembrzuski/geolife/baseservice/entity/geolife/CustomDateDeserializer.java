package com.zembrzuski.geolife.baseservice.entity.geolife;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.joda.time.DateTime;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class CustomDateDeserializer extends StdDeserializer<DateTime> {

    private SimpleDateFormat formatter
            = new SimpleDateFormat("dd-MM-yyyyThh:mm:ssZ");

    public CustomDateDeserializer() {
        this(null);
    }

    @Override
    public DateTime deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String date = jsonParser.getText();

        return null;
    }

    public CustomDateDeserializer(Class t) {
        super(t);
    }

}