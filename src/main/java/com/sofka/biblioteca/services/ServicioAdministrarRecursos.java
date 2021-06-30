package com.sofka.biblioteca.services;

import com.sofka.biblioteca.dto.RecursosDTO;
import com.sofka.biblioteca.dto.RespuestaDTO;
import com.sofka.biblioteca.mappers.RecursosMapper;
import com.sofka.biblioteca.repositories.RepositorioRecursos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class ServicioAdministrarRecursos {
    @Autowired
    RepositorioRecursos repositorioRecursos;
    RecursosMapper mapper = new RecursosMapper();

    private Date fechaActual = new Date();
    private String strDateFormat = "hh: mm: ss a dd-MMM-aaaa";
    private SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);

    public RespuestaDTO consultarDisponibilidadPorid(String idRecurso){
        RespuestaDTO respuestaDTO = new RespuestaDTO();
        var recurso = repositorioRecursos.findById(idRecurso);
        if(recurso.get().getDisponible()){
            respuestaDTO.setfechaPrestamo(null);
            respuestaDTO.setDisponible(true);
            respuestaDTO.setMensaje("El recurso " + recurso.get().getNombreRecurso() + " esta disponible");
            return respuestaDTO;
        }
        respuestaDTO.setfechaPrestamo(recurso.get().getFechaPrestamo());
        respuestaDTO.setDisponible(false);
        respuestaDTO.setMensaje("El recurso " + recurso.get().getNombreRecurso() + " no esta disponible");
        return respuestaDTO;
    }

    public RespuestaDTO pretarRecurso(String idRecurso){
        RespuestaDTO respuestaDTO = new RespuestaDTO();
        var recurso = repositorioRecursos.findById(idRecurso);
        if(recurso.get().getDisponible()){
            recurso.get().setDisponible(false);
            recurso.get().setFechaPrestamo(objSDF.format(fechaActual));
            repositorioRecursos.save(recurso.get());
            respuestaDTO.setfechaPrestamo(recurso.get().getFechaPrestamo());
            respuestaDTO.setDisponible(false);
            respuestaDTO.setMensaje("El recurso " + recurso.get().getNombreRecurso() + " fue prestado");
            return respuestaDTO;
        }
        respuestaDTO.setfechaPrestamo(recurso.get().getFechaPrestamo());
        respuestaDTO.setDisponible(false);
        respuestaDTO.setMensaje("El recurso " + recurso.get().getNombreRecurso() + " se encuentra en prestamo ");
        return respuestaDTO;
    }

    public RespuestaDTO devolverRecurso(String idRecurso){
        RespuestaDTO respuestaDTO = new RespuestaDTO();
        var recurso = repositorioRecursos.findById(idRecurso);
        if(recurso.get().getDisponible()){
            recurso.get().setDisponible(true);
            recurso.get().setFechaPrestamo(null);
            repositorioRecursos.save(recurso.get());
            respuestaDTO.setfechaPrestamo(recurso.get().getFechaPrestamo());
            respuestaDTO.setDisponible(true);
            respuestaDTO.setMensaje("El recurso " + recurso.get().getNombreRecurso() + " no esta en prestamo");
            return respuestaDTO;
        }
        recurso.get().setDisponible(true);
        recurso.get().setFechaPrestamo(null);
        repositorioRecursos.save(recurso.get());
        respuestaDTO.setfechaPrestamo(recurso.get().getFechaPrestamo());
        respuestaDTO.setDisponible(true);
        respuestaDTO.setMensaje("El recurso " + recurso.get().getNombreRecurso() + " ha sido devuelto exitosamente ");
        return respuestaDTO;
    }

}
