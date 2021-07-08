package com.sofka.biblioteca.services;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sofka.biblioteca.dto.RecursosDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class ControladorRecursosTest {


    @MockBean
    private ServicioRecursos servicioRecursos;

    @Autowired
    private MockMvc mockMvc1;

    @Test
    @DisplayName("Post /Happy case  create")
    public void crear() throws Exception {


        RecursosDTO recursosDTO = new RecursosDTO();
        RecursosDTO recurso2DTO = new RecursosDTO();

        recursosDTO.setTipoRecurso("libro");
        recursosDTO.setDisponible(true);
        recursosDTO.setFechaPrestamo("30/06/2021");
        recursosDTO.setNombreRecurso("La biblia");
        recursosDTO.setIdArea("xx");


        recurso2DTO.setId("xxxx");
        recursosDTO.setTipoRecurso("libro");
        recursosDTO.setDisponible(true);
        recursosDTO.setFechaPrestamo("30/06/2021");
        recursosDTO.setNombreRecurso("La biblia");
        recursosDTO.setIdArea("xx");

        doReturn(recurso2DTO).when(servicioRecursos).crear(any());


        mockMvc1.perform(post("/recursos/crear")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(recursosDTO)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is("xxxx")));

    }



    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}