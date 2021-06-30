package com.sofka.biblioteca.dto;


import java.util.Date;

public class RespuestaDTO {

    private String mensaje;
    private boolean disponible;
    private String fechaPrestamo;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getfechaPrestamo() {
        return fechaPrestamo;
    }

    public void setfechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
}
