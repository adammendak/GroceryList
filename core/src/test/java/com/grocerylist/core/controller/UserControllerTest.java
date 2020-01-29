package com.grocerylist.core.controller;

import com.grocerylist.core.CoreApplication;
import com.grocerylist.dto.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * @author  Elżbieta Dutkiewicz
 * @version 1.0
 * @since   2019-01-21
 *
 * This is test class for check if UserController works properly
 * Contains test method from mockito library
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoreApplication.class)
@ActiveProfiles("dev")
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getUser() throws Exception {
        String userDtoJson = "{\"userName\": \"pierwszy\", \"email\": \"pierwszy@gmail.com\", \"password\": \"haslo\"}";
        mockMvc.perform(get("/api/user/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userDtoJson))
                .andExpect(status()
                        .is2xxSuccessful());
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
                        .isBadRequest());
    }

}
