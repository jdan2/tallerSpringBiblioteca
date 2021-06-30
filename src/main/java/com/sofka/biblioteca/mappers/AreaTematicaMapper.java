package com.sofka.biblioteca.mappers;

import com.sofka.biblioteca.dto.AreaTematicaDTO;
import com.sofka.biblioteca.models.AreaTematica;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AreaTematicaMapper {

    public AreaTematica fromDTO(AreaTematicaDTO dto) {
        AreaTematica areaTematica = new AreaTematica();
        areaTematica.setIdArea(dto.getIdArea());
        areaTematica.setNombreArea(dto.getNombreArea());

        return areaTematica;
    }

    public AreaTematicaDTO fromCollection(AreaTematica areaTematica){
        AreaTematicaDTO areaTematicaDTO = new AreaTematicaDTO();
        areaTematicaDTO.setIdArea(areaTematica.getIdArea());
        areaTematicaDTO.setNombreArea(areaTematica.getNombreArea());
        return areaTematicaDTO;
    }

    public List<AreaTematicaDTO> fromCollectionList(List<AreaTematica> collection) {
        if (collection == null) {
            return null;

        }
        List<AreaTematicaDTO> list = new ArrayList(collection.size());
        Iterator listTracks = collection.iterator();

        while(listTracks.hasNext()) {
            AreaTematica areaTematica = (AreaTematica)listTracks.next();
            list.add(fromCollection(areaTematica));
        }

        return list;
    }
}
