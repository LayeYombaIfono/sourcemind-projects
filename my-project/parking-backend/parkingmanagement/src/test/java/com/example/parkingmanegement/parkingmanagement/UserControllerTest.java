package com.example.parkingmanegement.parkingmanagement;
import com.example.parkingmanegement.parkingmanagement.controller.UserController;
import com.example.parkingmanegement.parkingmanagement.entity.User;
import com.example.parkingmanegement.parkingmanagement.service.UserService;
//import com.parkingmanagement.entity.User;
//import com.parkingmanagement.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @Test
    void registerUser_Success() throws Exception {
        User user = new User(1L, "testUser", "encodedPassword", "test@example.com", "USER", null);

        when(userService.registerUser(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/api/users/register")
                        .with(SecurityMockMvcRequestPostProcessors.csrf()) // Jeton CSRF
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"testUser\",\"password\":\"password123\",\"email\":\"test@example.com\",\"role\":\"USER\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("testUser"));
    }

    @Test
    void getAllUsers_Success() throws Exception {
        User user1 = new User(1L, "testUser1", "password", "test1@example.com", "USER", null);
        User user2 = new User(2L, "testUser2", "password", "test2@example.com", "USER", null);

        when(userService.getAllUsers()).thenReturn(List.of(user1, user2));

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].username").value("testUser1"))
                .andExpect(jsonPath("$[1].username").value("testUser2"));
    }
}
