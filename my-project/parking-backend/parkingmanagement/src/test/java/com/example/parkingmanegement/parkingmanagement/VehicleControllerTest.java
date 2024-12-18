package com.example.parkingmanegement.parkingmanagement;

import com.example.parkingmanegement.parkingmanagement.controller.VehicleController;
import com.example.parkingmanegement.parkingmanagement.entity.Vehicle;
import com.example.parkingmanegement.parkingmanagement.service.VehicleService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Base64;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(VehicleController.class)
public class VehicleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private VehicleService vehicleService;
    private Base64.Encoder Base64Utils;


    @Test
    @WithMockUser(username = "testUser", roles = {"USER"})
    void getAllVehicles_WithMockUser_Success() throws Exception {
        Vehicle vehicle1 = new Vehicle(1L, "ABC123", "Model S", "Tesla", "Red", "Car");
        Vehicle vehicle2 = new Vehicle(2L, "XYZ789", "Model X", "Tesla", "Blue", "Car");

        when(vehicleService.getAllVehicles()).thenReturn(List.of(vehicle1, vehicle2));

        mockMvc.perform(get("/api/vehicles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].licensePlate").value("ABC123"))
                .andExpect(jsonPath("$[1].licensePlate").value("XYZ789"));
    }

    @Test
    void getAllVehicles_Success_WithAuthenticatedUser() throws Exception {
        Vehicle vehicle1 = new Vehicle(1L, "ABC123", "Model S", "Tesla", "Red", "Car");
        Vehicle vehicle2 = new Vehicle(2L, "XYZ789", "Model X", "Tesla", "Blue", "Car");

        when(vehicleService.getAllVehicles()).thenReturn(List.of(vehicle1, vehicle2));

        mockMvc.perform(get("/api/vehicles")
                        .header("Authorization", "Bearer your-test-jwt-token")) // Token d'utilisateur test
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].licensePlate").value("ABC123"))
                .andExpect(jsonPath("$[1].licensePlate").value("XYZ789"));
    }



    @Test
    void registerVehicle_WithDefaultUser_Success() throws Exception {
        Vehicle vehicle = new Vehicle(1L, "ABC123", "Model S", "Tesla", "Red", "Car");

        when(vehicleService.registerVehicle(any(Vehicle.class))).thenReturn(vehicle);

        String username = "user";
        String password = "c3a11962-f8f0-42ff-99df-b5ea143a3034"; // Remplacez par le mot de passe généré

        mockMvc.perform(post("/api/vehicles/register")
                        .header(HttpHeaders.AUTHORIZATION, "Basic " + Base64Utils.encodeToString((username + ":" + password).getBytes()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vehicle)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.licensePlate").value("ABC123"));
    }



    @Test
    void registerVehicle_Success() throws Exception {
        Vehicle vehicle = new Vehicle(1L, "ABC123", "Model S", "Tesla", "Red", "Car");

        doReturn(vehicle).when(vehicleService).registerVehicle(any(Vehicle.class));

        mockMvc.perform(post("/api/vehicles/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vehicle)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.licensePlate").value("ABC123"));
    }

    @Test
    void getAllVehicles_Success() throws Exception {
        Vehicle vehicle1 = new Vehicle(1L, "ABC123", "Model S", "Tesla", "Red", "Car");
        Vehicle vehicle2 = new Vehicle(2L, "XYZ789", "Model X", "Tesla", "Blue", "Car");

        doReturn(List.of(vehicle1, vehicle2)).when(vehicleService).getAllVehicles();

        mockMvc.perform(get("/api/vehicles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].licensePlate").value("ABC123"))
                .andExpect(jsonPath("$[1].licensePlate").value("XYZ789"));
    }

    @Test
    void getVehicleById_Success() throws Exception {
        Vehicle vehicle = new Vehicle(1L, "ABC123", "Model S", "Tesla", "Red", "Car");

        doReturn(java.util.Optional.of(vehicle)).when(vehicleService).getVehicleById(1L);

        mockMvc.perform(get("/api/vehicles/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.licensePlate").value("ABC123"));
    }

    @Test
    void updateVehicle_Success() throws Exception {
        Vehicle vehicle = new Vehicle(1L, "ABC123", "Model S", "Tesla", "Red", "Car");

        doReturn(vehicle).when(vehicleService).updateVehicle(eq(1L), any(Vehicle.class));

        mockMvc.perform(put("/api/vehicles/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vehicle)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.licensePlate").value("ABC123"));
    }

    @Test
    void deleteVehicle_Success() throws Exception {
        doNothing().when(vehicleService).deleteVehicle(1L);

        mockMvc.perform(delete("/api/vehicles/1"))
                .andExpect(status().isNoContent());
    }

}
