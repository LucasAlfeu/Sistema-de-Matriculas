package br.ufrrj.servlet;

import java.sql.Connection;

import br.ufrrj.DAO.DiscenteDAO;
import br.ufrrj.DAO.DisciplinaDAO;

public class MatricularEmDisciplina {
    private DiscenteDAO discenteDAO;
    private DisciplinaDAO disciplinaDAO;

    public MatricularEmDisciplina(Connection connection) {
        this.discenteDAO = new DiscenteDAO(connection);
        this.disciplinaDAO = new DisciplinaDAO(connection);
    }

    public void doGet() {
        // Implementation for GET request
    }

    public void doPost() {
        // Implementation for POST request
    }
}