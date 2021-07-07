package com.sofka.biblioteca.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sofka.biblioteca.dto.RecursosDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


import java.util.ArrayList;

@SpringBootTest
@AutoConfigureMockMvc
public class ControladorRecursosTest {
   /* @MockBean
    private ServicioRecursos servicioRecursos;

    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("GET /recursos success")
    public void findAll() throws Exception {
        //setup mock service
        var recurso1 = new RecursosDTO();
        recurso1.setId("1111");
        recurso1.setNombreRecurso("La Biblia");
        recurso1.setTipoRecurso("Libro");
        recurso1.setIdArea("Religion");
        recurso1.setFechaPrestamo("02: 32: 07 AM 30-Jun-AM");
        recurso1.setDisponible(true);
        var recurso2 = new RecursosDTO();
        recurso1.setId("2222");
        recurso1.setNombreRecurso("Nuevo Testamento");
        recurso1.setTipoRecurso("Libro");
        recurso1.setIdArea("Religion");
        recurso1.setFechaPrestamo("02: 32: 07 AM 28-Jun-AM");
        recurso1.setDisponible(true);
        var lista = new ArrayList<RecursosDTO>();
        lista.add(recurso1);
        lista.add(recurso2);
        Mockito.when(servicioRecursos.obtenerTodos()).thenReturn(lista);

        //execute Get request
        mockMvc.perform(get("/recursos"))
                // Validate the response code and content type
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                // Validate the returned fields
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect( jsonPath("$[0].id", is("1111")))
                .andExpect( jsonPath("$[0].nombre", is("Jorge Ramirez")))
                .andExpect(jsonPath("$[0].rol", is("Gerente")))
                .andExpect( jsonPath("$[1].id", is("2222")))
                .andExpect(jsonPath("$[1].nombre", is("Pedro Contreras")))
                .andExpect( jsonPath("$[1].rol", is("Vicepresidente")));
    }

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/

}
