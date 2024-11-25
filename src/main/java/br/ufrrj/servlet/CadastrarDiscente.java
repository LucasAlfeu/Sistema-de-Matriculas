package br.ufrrj.servlet;

import java.sql.Connection;

import br.ufrrj.DAO.DiscenteDAO;

public class CadastrarDiscente {
    private DiscenteDAO discenteDAO;

    public CadastrarDiscente(Connection connection) {
        this.discenteDAO = new DiscenteDAO(connection);
    }

    public void doGet() {
        // Implementation for GET request
    }

    public void doPost() {
        // Implementation for POST request
    }
}