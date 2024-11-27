package br.ufrrj.servlet;

import java.sql.Connection;

import br.ufrrj.DAO.DisciplinaDAO;

public class CadastrarDisciplina {
    private DisciplinaDAO disciplinaDAO;

    public CadastrarDisciplina(Connection connection) {
        this.disciplinaDAO = new DisciplinaDAO(connection);
    }

    public void doGet() {
        // Implementation for GET request
    }

    public void doPost() {
        // Implementation for POST request
    }
}
