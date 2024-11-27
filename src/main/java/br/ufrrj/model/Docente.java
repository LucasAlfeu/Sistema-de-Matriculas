package br.ufrrj.model;

public class Docente {
    private String nomeDocente;
    private String identificacao;
    private boolean ehCoordenador;
    private boolean ehChefeDepartamento;

    public Docente(String nomeDocente, String identificacao) {
        this.nomeDocente = nomeDocente;
        this.identificacao = identificacao;
        this.ehCoordenador = false;
        this.ehChefeDepartamento = false;
    }

    public String getNomeDocente() {
        return nomeDocente;
    }

    public void setNomeDocente(String nomeDocente) {
        this.nomeDocente = nomeDocente;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public boolean isEhCoordenador() {
        return ehCoordenador;
    }

    public void setEhCoordenador(boolean ehCoordenador) {
        this.ehCoordenador = ehCoordenador;
    }

    public boolean isEhChefeDepartamento() {
        return ehChefeDepartamento;
    }

    public void setEhChefeDepartamento(boolean ehChefeDepartamento) {
        this.ehChefeDepartamento = ehChefeDepartamento;
    }

    public void atribuirNotaDiscente(Resultado resultado, float nota) {
        resultado.setNota(nota);
        resultado.calcularResultado(nota);
    }
}
