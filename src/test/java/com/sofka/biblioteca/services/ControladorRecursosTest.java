package com.sofka.biblioteca.services;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sofka.biblioteca.dto.RecursosDTO;
import com.sofka.biblioteca.dto.RespuestaDTO;
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

    @MockBean
    private ServicioAdministrarRecursos servicioAdministrarRecursos;

    @Autowired
    private MockMvc mockMvc;

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


        mockMvc.perform(post("/recursos/crear")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(recursosDTO)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is("xxxx")));

    }

    @Test
    @DisplayName("Get /consultar/id Success")
    public void obtenerRecurso() throws Exception {

        RespuestaDTO respuestaDTO = new RespuestaDTO();

        respuestaDTO.setDisponible(true);
        respuestaDTO.setMensaje("El recurso se encuentra disponible");
        respuestaDTO.setfechaPrestamo("6/30/2021");

        doReturn(respuestaDTO).when(servicioAdministrarRecursos).consultarDisponibilidadPorid("3");

        mockMvc.perform(get("/administrar/consultardisponibilidad/{id}", "3"))
                .andExpect(jsonPath("$.mensaje", is("El recurso se encuentra disponible")))
                .andExpect(jsonPath("$.disponible", is(true)))
                .andExpect(jsonPath("$.fechaPrestamo", is("6/30/2021")));
    }


    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}