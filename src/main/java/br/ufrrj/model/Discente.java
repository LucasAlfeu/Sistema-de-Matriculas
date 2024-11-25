package br.ufrrj.model;

import java.util.ArrayList;
import java.util.List;

public class Discente {
    private int id;
    private String nomeAluno;
    private String matriculaAluno;
    private String emailAluno;
    private List<Resultado> resultados;

    public Discente(String nomeAluno, String matriculaAluno, String emailAluno) {
        this.nomeAluno = nomeAluno;
        this.matriculaAluno = matriculaAluno;
        this.emailAluno = emailAluno;
        this.resultados = new ArrayList<>();
    }

    public Discente(int id, String nomeAluno, String matriculaAluno, String emailAluno) {
        this(nomeAluno, matriculaAluno, emailAluno);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(String matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public String getEmailAluno() {
        return emailAluno;
    }

    public void setEmailAluno(String emailAluno) {
        this.emailAluno = emailAluno;
    }

    public List<Resultado> getResultados() {
        return resultados;
    }

    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }
}