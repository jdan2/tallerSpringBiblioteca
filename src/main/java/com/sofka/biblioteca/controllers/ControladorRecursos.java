package com.sofka.biblioteca.controllers;

import com.sofka.biblioteca.dto.AreaTematicaDTO;
import com.sofka.biblioteca.dto.RecursosDTO;
import com.sofka.biblioteca.services.ServicioRecursos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recursos")
public class ControladorRecursos {
    @Autowired
    ServicioRecursos servicioRecursos;
    @GetMapping("/{id}")
    public ResponseEntity<RecursosDTO> findbyId(@PathVariable("id") String id) {
        return new ResponseEntity(servicioRecursos.obtenerPorId(id), HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<RecursosDTO>> findAll() {
        return new ResponseEntity(servicioRecursos.obtenerTodos(), HttpStatus.OK);
    }
    @PostMapping("/crear")
    public ResponseEntity<RecursosDTO> create(@RequestBody RecursosDTO recursosDTO) {
        return new ResponseEntity(servicioRecursos.crear(recursosDTO), HttpStatus.CREATED);
    }

    @PostMapping("/creararea")
    public ResponseEntity<AreaTematicaDTO> createarea(@RequestBody AreaTematicaDTO areaTematicaDTO) {
        return new ResponseEntity(servicioRecursos.crearArea(areaTematicaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/modificar")
    public ResponseEntity<RecursosDTO> update(@RequestBody RecursosDTO recursosDTO){
        if (recursosDTO.getId() != null){
            return new ResponseEntity(servicioRecursos.modificar(recursosDTO),HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) {
        try {
            servicioRecursos.borrar(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
