package org.springsandbox.security.repo.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springsandbox.security.repo.dto.Role;


import java.io.IOException;

public class RoleDeserializer extends JsonDeserializer<Role> {
    @Override
    public Role deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jp.readValueAsTree();
        String enumName = node.findValue("name").asText();
        return Enum.valueOf(Role.class, enumName);
    }
}
