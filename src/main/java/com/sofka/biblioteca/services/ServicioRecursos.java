package com.sofka.biblioteca.services;

import com.sofka.biblioteca.dto.AreaTematicaDTO;
import com.sofka.biblioteca.dto.RecursosDTO;
import com.sofka.biblioteca.mappers.AreaTematicaMapper;
import com.sofka.biblioteca.mappers.RecursosMapper;
import com.sofka.biblioteca.models.AreaTematica;
import com.sofka.biblioteca.models.Recursos;
import com.sofka.biblioteca.repositories.RepositorioAreaTematica;
import com.sofka.biblioteca.repositories.RepositorioRecursos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioRecursos {

    @Autowired
    RepositorioRecursos repositorioRecursos;
    @Autowired
    RepositorioAreaTematica repositorioAreaTematica;

    RecursosMapper mapper = new RecursosMapper();
    AreaTematicaMapper areaTematicaMapper = new AreaTematicaMapper();


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

    public AreaTematicaDTO crearArea(AreaTematicaDTO areaTematicaDTO) {
        AreaTematica areaTematica = areaTematicaMapper.fromDTO(areaTematicaDTO);
        return areaTematicaMapper.fromCollection(repositorioAreaTematica.save(areaTematica));
    }

    public RecursosDTO modificar(RecursosDTO recursosDTO) {
        Recursos recursos = mapper.fromDTO(recursosDTO);
        repositorioRecursos.findById(recursos.getId()).orElseThrow(() -> new RuntimeException("Recurso no encontrado"));
        return mapper.fromCollection(repositorioRecursos.save(recursos));
    }
    public void borrar(String id) {
        repositorioRecursos.deleteById(id);
    }

}
