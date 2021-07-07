package com.sofka.biblioteca.repositories;

import com.sofka.biblioteca.models.Recursos;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RepositorioRecursos extends MongoRepository<Recursos, String> {

    List<Recursos> findRecursosByidArea(String idArea);
}

