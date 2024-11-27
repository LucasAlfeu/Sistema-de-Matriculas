package br.ufrrj.servlet;

import java.sql.Connection;

import br.ufrrj.DAO.DocenteDAO;
import br.ufrrj.DAO.ResultadoDAO;

public class CadastrarNotas {
    private DocenteDAO docenteDAO;
    private ResultadoDAO resultadoDAO;

    public CadastrarNotas(Connection connection) {
        this.docenteDAO = new DocenteDAO(connection);
        this.resultadoDAO = new ResultadoDAO(connection);
    }

    public void doGet() {
        // Implementation for GET request
    }

    public void doPost() {
        // Implementation for POST request
    }
}