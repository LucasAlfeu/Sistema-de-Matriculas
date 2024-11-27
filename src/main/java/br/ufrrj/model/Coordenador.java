package br.ufrrj.model;

public class Coordenador extends Docente {
    public Coordenador(String nomeDocente, String identificacao) {
        super(nomeDocente, identificacao);
        setEhCoordenador(true);
    }

    public void pedirAberturaDisciplina() {
        // implementação
    }
}
