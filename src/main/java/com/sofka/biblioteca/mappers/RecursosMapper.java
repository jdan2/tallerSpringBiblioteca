package com.sofka.biblioteca.mappers;

import com.sofka.biblioteca.dto.RecursosDTO;
import com.sofka.biblioteca.models.Recursos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecursosMapper {

    public Recursos fromDTO(RecursosDTO dto) {
        Recursos recursos = new Recursos();
        recursos.setId(dto.getId());
        recursos.setNombreRecurso(dto.getNombreRecurso());
        recursos.setIdArea(dto.getIdArea());
        recursos.setDisponible(dto.getDisponible());
        recursos.setTipoRecurso(dto.getTipoRecurso());
        recursos.setFechaPrestamo(dto.getFechaPrestamo());
        return recursos;
    }

    public RecursosDTO fromCollection(Recursos recursos){
        RecursosDTO recursosDTO = new RecursosDTO();
        recursosDTO.setId(recursos.getId());
        recursosDTO.setIdArea(recursos.getIdArea());
        recursosDTO.setNombreRecurso(recursos.getNombreRecurso());
        recursosDTO.setTipoRecurso(recursos.getTipoRecurso());
        recursosDTO.setDisponible(recursos.getDisponible());
        recursosDTO.setFechaPrestamo(recursos.getFechaPrestamo());
        return recursosDTO;
    }

    public List<RecursosDTO> fromCollectionList(List<Recursos> collection) {
        if (collection == null) {
            return null;

        }
        List<RecursosDTO> list = new ArrayList(collection.size());
        Iterator listTracks = collection.iterator();

        while(listTracks.hasNext()) {
            Recursos recursos = (Recursos)listTracks.next();
            list.add(fromCollection(recursos));
        }

        return list;
    }
}
