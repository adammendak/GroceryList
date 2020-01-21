package com.grocerylist.core.controller;

import com.grocerylist.core.CoreApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoreApplication.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getUser() {
    }

    @Test
    public void loginUser() {
    }

    @Test
    public void getAllUsers() {
    }

    @Test
    public void shouldPassCreateUser() throws Exception {
        String userDtoJson = "{\"userName\": \"pierwszy\", \"email\": \"pierwszy@gmail.com\", \"password\": \"haslo\"}";
        mockMvc.perform(post("/api/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userDtoJson))
                .andExpect(status()
                        .is2xxSuccessful());
    }

    @Test
    public void shouldFailCauseInvalidJson() throws Exception {
        String userDtoJson = "{\"email\": \"pierwszy@gmail.com\", \"password\": \"haslo\"}";
        mockMvc.perform(post("/api/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userDtoJson))
                .andExpect(status()
                        .is4xxClientError());
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void deleteUser() {
    }
}