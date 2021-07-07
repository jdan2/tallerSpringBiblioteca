package com.sofka.biblioteca.services;

import com.sofka.biblioteca.models.Recursos;
import com.sofka.biblioteca.repositories.RepositorioRecursos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class ServicioAdministrarRecursosTest {

    @MockBean
    private RepositorioRecursos repositorioRecursos;

    @Autowired
    private ServicioRecursos servicioRecursos;

    @Test
    @DisplayName("Test findId Success")
    public void consultarDisponibilidadPorid() {
        var recurso1 = new Recursos();
        recurso1.setId("1111");
        recurso1.setNombreRecurso("La Biblia");
        recurso1.setTipoRecurso("Libro");
        recurso1.setIdArea("Religion");
        recurso1.setFechaPrestamo("02: 32: 07 AM 30-Jun-AM");
        recurso1.setDisponible(true);
        var recurso2 = new Recursos();
        recurso2.setId("2222");
        recurso2.setNombreRecurso("La Biblia RNV");
        recurso2.setTipoRecurso("Libro");
        recurso2.setIdArea("Religion");
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