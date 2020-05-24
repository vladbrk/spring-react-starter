package org.springsandbox.security.repo.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springsandbox.security.repo.dto.Role;

import java.io.IOException;

public class RoleSerializer extends JsonSerializer<Role> {
    @Override
    public void serialize(Role value, JsonGenerator jgen, SerializerProvider serializers) throws IOException {
        jgen.writeStartObject();
        jgen.writeStringField("name", value.toString());
        jgen.writeStringField("id", String.valueOf(value.getId()));
        jgen.writeStringField("value", value.getValue());
        jgen.writeEndObject();
    }
}
