package com.sofka.biblioteca.dto;

import java.util.List;

public class RespuestaAreaTematicaDTO {

    private String areaTematica;
    private List<RecursosDTO> recursosArea;

    public String getAreaTematica() {
        return areaTematica;
    }

    public void setAreaTematica(String areaTematica) {
        this.areaTematica = areaTematica;
    }

    public List<RecursosDTO> getRecursosArea() {
        return recursosArea;
    }

    public void setRecursosArea(List<RecursosDTO> recursosArea) {
        this.recursosArea = recursosArea;
    }
}
