package com.sofka.biblioteca.services;

import com.sofka.biblioteca.dto.RecursosDTO;
import com.sofka.biblioteca.mappers.RecursosMapper;
import com.sofka.biblioteca.models.Recursos;
import com.sofka.biblioteca.repositories.RepositorioRecursos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioRecursos {

    @Autowired
    RepositorioRecursos repositorioRecursos;
    RecursosMapper mapper = new RecursosMapper();

    public List<RecursosDTO> obtenerTodos() {
        List<Recursos> recursos = (List<Recursos>) repositorioRecursos.findAll();
        return mapper.fromCollectionList(recursos);
    }
    public RecursosDTO obtenerPorId(String id) {
        Recursos recurso = repositorioRecursos.findById(id).orElseThrow(() -> new RuntimeException("Recurso no encontrado"));
        return mapper.fromCollection(recurso);
    }
    public RecursosDTO crear(RecursosDTO recursoDTO) {
        Recursos recurso = mapper.fromDTO(recursoDTO);
        return mapper.fromCollection(repositorioRecursos.save(recurso));
    }
    public RecursosDTO modificar(RecursosDTO empleadoDTO) {
        Recursos recursos = mapper.fromDTO(empleadoDTO);
        repositorioRecursos.findById(recursos.getId()).orElseThrow(() -> new RuntimeException("Recurso no encontrado"));
        return mapper.fromCollection(repositorioRecursos.save(recursos));
    }
    public void borrar(String id) {
        repositorioRecursos.deleteById(id);
    }

}
