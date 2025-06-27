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

    public static final String PATH = "/api/mowerorder";
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetOrder_OK() throws Exception {

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

        String jsonResponce = mockMvc.perform(post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk()).andReturn()
                .getResponse()
                .getContentAsString();
        JsonNode responce = objectMapper.readTree(jsonResponce);

        assertEquals(expected, responce);
    }



    @Test
    void testGetOrder_EmptyJson() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = Files.readString(
                Paths.get("src/test/resources/in/empty.json"),
                StandardCharsets.UTF_8
        );
        String expectedJson = Files.readString(
                Paths.get("src/test/resources/out/empty.json"),
                StandardCharsets.UTF_8
        );
        JsonNode expected = objectMapper.readTree(expectedJson);

        String jsonResponce = mockMvc.perform(post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isBadRequest()).andReturn()
                .getResponse()
                .getContentAsString();
        JsonNode responce = objectMapper.readTree(jsonResponce);

        assertEquals(expected, responce);
    }



    @Test
    void testGetOrder_BadField() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = Files.readString(
                Paths.get("src/test/resources/in/badfield.json"),
                StandardCharsets.UTF_8
        );
        String expectedJson = Files.readString(
                Paths.get("src/test/resources/out/badfield.json"),
                StandardCharsets.UTF_8
        );
        JsonNode expected = objectMapper.readTree(expectedJson);

        String jsonResponce = mockMvc.perform(post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isBadRequest()).andReturn()
                .getResponse()
                .getContentAsString();
        JsonNode responce = objectMapper.readTree(jsonResponce);

        assertEquals(expected, responce);
    }



    @Test
    void testGetOrder_BadStart_Position() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = Files.readString(
                Paths.get("src/test/resources/in/badstart_position.json"),
                StandardCharsets.UTF_8
        );
        String expectedJson = Files.readString(
                Paths.get("src/test/resources/out/badstart_position.json"),
                StandardCharsets.UTF_8
        );
        JsonNode expected = objectMapper.readTree(expectedJson);

        String jsonResponce = mockMvc.perform(post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isBadRequest()).andReturn()
                .getResponse()
                .getContentAsString();
        JsonNode responce = objectMapper.readTree(jsonResponce);

        assertEquals(expected, responce);
    }



    @Test
    void testGetOrder_EmptyMowers() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = Files.readString(
                Paths.get("src/test/resources/in/emptymowers.json"),
                StandardCharsets.UTF_8
        );
        String expectedJson = Files.readString(
                Paths.get("src/test/resources/out/emptymowers.json"),
                StandardCharsets.UTF_8
        );
        JsonNode expected = objectMapper.readTree(expectedJson);

        String jsonResponce = mockMvc.perform(post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isBadRequest()).andReturn()
                .getResponse()
                .getContentAsString();
        JsonNode responce = objectMapper.readTree(jsonResponce);

        assertEquals(expected, responce);
    }



    @Test
    void testGetOrder_NoField() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = Files.readString(
                Paths.get("src/test/resources/in/nofield.json"),
                StandardCharsets.UTF_8
        );
        String expectedJson = Files.readString(
                Paths.get("src/test/resources/out/nofield.json"),
                StandardCharsets.UTF_8
        );
        JsonNode expected = objectMapper.readTree(expectedJson);

        String jsonResponce = mockMvc.perform(post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isBadRequest()).andReturn()
                .getResponse()
                .getContentAsString();
        JsonNode responce = objectMapper.readTree(jsonResponce);

        assertEquals(expected, responce);
    }



    @Test
    void testGetOrder_NoMowers() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = Files.readString(
                Paths.get("src/test/resources/in/nomowers.json"),
                StandardCharsets.UTF_8
        );
        String expectedJson = Files.readString(
                Paths.get("src/test/resources/out/nomowers.json"),
                StandardCharsets.UTF_8
        );
        JsonNode expected = objectMapper.readTree(expectedJson);

        String jsonResponce = mockMvc.perform(post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isBadRequest()).andReturn()
                .getResponse()
                .getContentAsString();
        JsonNode responce = objectMapper.readTree(jsonResponce);

        assertEquals(expected, responce);
    }
}
