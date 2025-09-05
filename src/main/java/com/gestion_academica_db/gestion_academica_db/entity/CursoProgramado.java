package com.gestion_academica_db.gestion_academica_db.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "curso_programado")
public class CursoProgramado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso_programado")
    private Integer idCursoProgramado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "codigo_curso", referencedColumnName = "codigo_curso", nullable = false)
    private CatalogoCurso curso;  // catálago al que pertenece

    @Column(name = "semestre", nullable = false)
    private Integer semestre;

    @Column(name = "ciclo", nullable = false)
    private Integer ciclo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "codigo_profesor", referencedColumnName = "codigo_profesor", nullable = false)
    private Profesor profesor;

    public Integer getIdCursoProgramado() { return idCursoProgramado; }
    public void setIdCursoProgramado(Integer idCursoProgramado) { this.idCursoProgramado = idCursoProgramado; }
    public CatalogoCurso getCurso() { return curso; }
    public void setCurso(CatalogoCurso curso) { this.curso = curso; }
    public Integer getSemestre() { return semestre; }
    public void setSemestre(Integer semestre) { this.semestre = semestre; }
    public Integer getCiclo() { return ciclo; }
    public void setCiclo(Integer ciclo) { this.ciclo = ciclo; }
    public Profesor getProfesor() { return profesor; }
    public void setProfesor(Profesor profesor) { this.profesor = profesor; }
}
