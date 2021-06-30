package com.sofka.biblioteca.repositories;

import com.sofka.biblioteca.models.AreaTematica;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioAreaTematica extends MongoRepository<AreaTematica, String> {
}


