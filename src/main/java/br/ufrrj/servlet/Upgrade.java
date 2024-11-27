package br.ufrrj.servlet;

import java.sql.Connection;

import br.ufrrj.DAO.DocenteDAO;

public class Upgrade {
    private DocenteDAO docenteDAO;

    public Upgrade(Connection connection) {
        this.docenteDAO = new DocenteDAO(connection);
    }

    public void doGet() {
        // Implementation for GET request
    }

    public void doPost() {
        // Implementation for POST request
    }
}