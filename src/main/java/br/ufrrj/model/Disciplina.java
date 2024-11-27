package br.ufrrj.model;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private int id;
    private String nomeDisciplina;
    private int cargaHoraria;
    private List<String> aulas;
    private List<Discente> discentesMatriculados;
    private int maxDocentes;

    public Disciplina(String nomeDisciplina, int cargaHoraria, int maxDocentes) {
        this.nomeDisciplina = nomeDisciplina;
        this.cargaHoraria = cargaHoraria;
        this.maxDocentes = maxDocentes;
        this.aulas = new ArrayList<>();
        this.discentesMatriculados = new ArrayList<>();
    }

    public Disciplina(int id, String nomeDisciplina, int cargaHoraria, int maxDocentes) {
        this(nomeDisciplina, cargaHoraria, maxDocentes);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public List<String> getAulas() {
        return aulas;
    }

    public void setAulas(List<String> aulas) {
        this.aulas = aulas;
    }

    public List<Discente> getDiscentesMatriculados() {
        return discentesMatriculados;
    }

    public void setDiscentesMatriculados(List<Discente> discentesMatriculados) {
        this.discentesMatriculados = discentesMatriculados;
    }

    public int getMaxDocentes() {
        return maxDocentes;
    }

    public void setMaxDocentes(int maxDocentes) {
        this.maxDocentes = maxDocentes;
    }
}
