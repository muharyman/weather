package com.muharyman.weather.service;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class LongTypeAdapter extends TypeAdapter<Long> {
    @Override
    public void write(JsonWriter writer, Long value) throws IOException {
        if (value == null) {
            writer.nullValue();
            return;
        }
        writer.value(value);
    }

    @Override
    public Long read(JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return null;
        }
        String stringValue = reader.nextString();
        return Long.valueOf(stringValue);
    }
}
