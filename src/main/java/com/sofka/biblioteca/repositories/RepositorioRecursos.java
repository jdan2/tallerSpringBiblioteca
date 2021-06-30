package com.sofka.biblioteca.repositories;

import com.sofka.biblioteca.models.Recursos;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioRecursos extends MongoRepository<Recursos, String> {
}
