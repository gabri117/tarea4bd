package com.gestion_academica_db.gestion_academica_db.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class InscripcionId implements Serializable {

    @Column(name = "carnet", length = 15)
    private String carnet;

    @Column(name = "id_curso_programado")
    private Integer idCursoProgramado;

    public InscripcionId() {}
    public InscripcionId(String carnet, Integer idCursoProgramado) {
        this.carnet = carnet;
        this.idCursoProgramado = idCursoProgramado;
    }

    public String getCarnet() { return carnet; }
    public void setCarnet(String carnet) { this.carnet = carnet; }
    public Integer getIdCursoProgramado() { return idCursoProgramado; }
    public void setIdCursoProgramado(Integer idCursoProgramado) { this.idCursoProgramado = idCursoProgramado; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InscripcionId that)) return false;
        return Objects.equals(carnet, that.carnet) &&
               Objects.equals(idCursoProgramado, that.idCursoProgramado);
    }
    @Override public int hashCode() {
        return Objects.hash(carnet, idCursoProgramado);
    }
}
