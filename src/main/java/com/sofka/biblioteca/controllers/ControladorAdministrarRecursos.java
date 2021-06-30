package com.sofka.biblioteca.controllers;


import com.sofka.biblioteca.dto.RecursosDTO;
import com.sofka.biblioteca.dto.RespuestaDTO;
import com.sofka.biblioteca.services.ServicioAdministrarRecursos;
import com.sofka.biblioteca.services.ServicioRecursos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/administrar")
public class ControladorAdministrarRecursos {

    @Autowired
    ServicioAdministrarRecursos servicioAdministrarRecursos;

    @GetMapping("/consultardisponibilidad/{id}")
    public ResponseEntity<RespuestaDTO> consultarDisponibilidadPorid(@PathVariable("id") String id) {
        var respuesta = servicioAdministrarRecursos.consultarDisponibilidadPorid(id);
        if(respuesta == null){
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(respuesta, HttpStatus.OK);
    }

    @GetMapping("/prestar/{id}")
    public ResponseEntity<RespuestaDTO> prestarRecurso(@PathVariable("id") String id) {
        var respuesta = servicioAdministrarRecursos.pretarRecurso(id);
        if(respuesta == null){
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(respuesta, HttpStatus.OK);
    }
}
