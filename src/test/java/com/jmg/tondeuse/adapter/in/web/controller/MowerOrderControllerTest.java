package com.jmg.tondeuse.adapter.in.web.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MowerOrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetOrder() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = Files.readString(
                Paths.get("src/test/resources/in/request.json"),
                StandardCharsets.UTF_8
        );
        String expectedJson = Files.readString(
                Paths.get("src/test/resources/out/responce.json"),
                StandardCharsets.UTF_8
        );
        JsonNode expected = objectMapper.readTree(expectedJson);

        String jsonResponce = mockMvc.perform(post("/api/mowerorder")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk()).andReturn()
                .getResponse()
                .getContentAsString();
        JsonNode responce = objectMapper.readTree(jsonResponce);

        assertEquals(expected, responce);
    }
}
