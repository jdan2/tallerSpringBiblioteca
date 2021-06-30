package com.sofka.biblioteca.services;

import com.sofka.biblioteca.dto.RecursosDTO;
import com.sofka.biblioteca.models.Recursos;
import com.sofka.biblioteca.repositories.RepositorioRecursos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class ServicioRecursosTest {

    @MockBean
    private RepositorioRecursos repositorioRecursos;

    @Autowired
    private ServicioRecursos servicioRecursos;


    @Test
    @DisplayName("Test save Success")
    public void crear() {

        var recurso1 = new Recursos();
        recurso1.setId("1111");
        recurso1.setNombreRecurso("La Biblia");
        recurso1.setTipoRecurso("Libro");
        recurso1.setAreaTematica("Religion");
        recurso1.setFechaPrestamo("02: 32: 07 AM 30-Jun-AM");
        recurso1.setDisponible(true);


        var recurso2 = new RecursosDTO();
        recurso2.setNombreRecurso("La Biblia");
        recurso2.setTipoRecurso("Libro");
        recurso2.setAreaTematica("Religion");
        recurso2.setFechaPrestamo("02: 32: 07 AM 30-Jun-AM");
        recurso2.setDisponible(true);

        Mockito.when(repositorioRecursos.save(any())).thenReturn(recurso1);

        var resultado = servicioRecursos.crear(recurso2);

        Assertions.assertNotNull(resultado, "el valor guardado no debe ser nulo");

        Assertions.assertEquals(recurso1.getNombreRecurso(), resultado.getNombreRecurso(), "El nombre de recurso no corresponde");
        Assertions.assertEquals(recurso1.getTipoRecurso(), resultado.getTipoRecurso(), "El Tipo Recurso no corresponde");
        Assertions.assertEquals(recurso1.getAreaTematica(), resultado.getAreaTematica(), "El area tematica no corresponde");
        Assertions.assertEquals(recurso1.getFechaPrestamo(), resultado.getFechaPrestamo(), "La fecha de prestamo no corresponde");
        Assertions.assertEquals(recurso1.getDisponible(), resultado.getDisponible(), "La disponibilidad no corresponde");
    }

    @Test
    @DisplayName("Test findAll Success")
    public void obtenerTodos() {
        var recurso1 = new Recursos();
        recurso1.setId("1111");
        recurso1.setNombreRecurso("La Biblia");
        recurso1.setTipoRecurso("Libro");
        recurso1.setAreaTematica("Religion");
        recurso1.setFechaPrestamo("02: 32: 07 AM 30-Jun-AM");
        recurso1.setDisponible(true);
        var recurso2 = new Recursos();
        recurso2.setId("2222");
        recurso2.setNombreRecurso("La Biblia RNV");
        recurso2.setTipoRecurso("Libro");
        recurso2.setAreaTematica("Religion");
        recurso2.setFechaPrestamo("02: 32: 07 AM 28-Jun-AM");
        recurso2.setDisponible(false);

        var lista = new ArrayList<Recursos>();
        lista.add(recurso1);
        lista.add(recurso2);
        Mockito.when(repositorioRecursos.findAll()).thenReturn(lista);

        var resultado = servicioRecursos.obtenerTodos();

        Assertions.assertEquals(2, resultado.size());
        Assertions.assertEquals(recurso1.getId(), resultado.get(0).getId());
        Assertions.assertEquals(recurso1.getNombreRecurso(), resultado.get(0).getNombreRecurso());
        Assertions.assertEquals(recurso1.getTipoRecurso(), resultado.get(0).getTipoRecurso());
        Assertions.assertEquals(recurso1.getAreaTematica(), resultado.get(0).getAreaTematica());
        Assertions.assertEquals(recurso1.getFechaPrestamo(), resultado.get(0).getFechaPrestamo());
        Assertions.assertEquals(recurso1.getDisponible(), resultado.get(0).getDisponible());

        Assertions.assertEquals(recurso2.getId(), resultado.get(1).getId());
        Assertions.assertEquals(recurso2.getNombreRecurso(), resultado.get(1).getNombreRecurso());
        Assertions.assertEquals(recurso2.getTipoRecurso(), resultado.get(1).getTipoRecurso());
        Assertions.assertEquals(recurso2.getAreaTematica(), resultado.get(1).getAreaTematica());
        Assertions.assertEquals(recurso2.getFechaPrestamo(), resultado.get(1).getFechaPrestamo());
        Assertions.assertEquals(recurso2.getDisponible(), resultado.get(1).getDisponible());
    }


    @Test
    @DisplayName("Test findId Success")
    public void obtenerPorid() {
        var recurso1 = new Recursos();
        recurso1.setId("1111");
        recurso1.setNombreRecurso("La Biblia");
        recurso1.setTipoRecurso("Libro");
        recurso1.setAreaTematica("Religion");
        recurso1.setFechaPrestamo("02: 32: 07 AM 30-Jun-AM");
        recurso1.setDisponible(true);
        var recurso2 = new Recursos();
        recurso2.setId("2222");
        recurso2.setNombreRecurso("La Biblia RNV");
        recurso2.setTipoRecurso("Libro");
        recurso2.setAreaTematica("Religion");
        recurso2.setFechaPrestamo("02: 32: 07 AM 28-Jun-AM");
        recurso2.setDisponible(false);


        Mockito.when(repositorioRecursos.findById(any())).thenReturn(java.util.Optional.of(recurso1));

        var resultado = servicioRecursos.obtenerPorId("1111");

        Assertions.assertEquals(recurso1.getNombreRecurso(), resultado.getNombreRecurso());
        Assertions.assertEquals(recurso1.getTipoRecurso(), resultado.getTipoRecurso());
        Assertions.assertEquals(recurso1.getTipoRecurso(), resultado.getTipoRecurso());
        Assertions.assertEquals(recurso1.getFechaPrestamo(), resultado.getFechaPrestamo());
        Assertions.assertEquals(recurso1.getDisponible(), resultado.getDisponible());
    }


}