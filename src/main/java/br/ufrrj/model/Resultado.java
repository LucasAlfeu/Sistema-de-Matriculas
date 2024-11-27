package br.ufrrj.model;

import java.sql.Date;

public class Resultado {
    private int id;
    private Disciplina disciplina;
    private boolean status;
    private Date data;
    private float nota;

    public Resultado(Disciplina disciplina, Date data) {
        this.disciplina = disciplina;
        this.data = data;
        this.status = false;
        this.nota = 0.0f;
    }

    public Resultado(int id, Disciplina disciplina, boolean status, Date data, float nota) {
        this.id = id;
        this.disciplina = disciplina;
        this.status = status;
        this.data = data;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public float calcularResultado(float nota) {
        this.nota = nota;
        this.status = nota >= 5.0f; // média 5
        return this.nota;
    }
}
