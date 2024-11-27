package br.ufrrj.model;

public class ChefeDeDepartamento extends Docente {
    public ChefeDeDepartamento(String nomeDocente, String identificacao) {
        super(nomeDocente, identificacao);
        setEhChefeDepartamento(true);
    }

    public void cadastrarDisciplina(Disciplina disciplina) {
        // implementação
    }
}
