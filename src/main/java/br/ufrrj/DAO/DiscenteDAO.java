package br.ufrrj.DAO;

import br.ufrrj.model.Discente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiscenteDAO {
    private Connection connection;
    private ResultadoDAO resultadoDAO;

    public DiscenteDAO(Connection connection) {
        this.connection = connection;
        this.resultadoDAO = new ResultadoDAO(connection);
    }

    public void cadastrarDiscente(Discente discente) throws SQLException {
        String sql = "INSERT INTO discente (nome_aluno, matricula_aluno, email_aluno) VALUES (?, ?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, discente.getNomeAluno());
            stmt.setString(2, discente.getMatriculaAluno());
            stmt.setString(3, discente.getEmailAluno());
            
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                discente.setId(rs.getInt(1));
            }
        }
    }

    public void atualizarDiscente(Discente discente) throws SQLException {
        String sql = "UPDATE discente SET nome_aluno = ?, email_aluno = ? WHERE matricula_aluno = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, discente.getNomeAluno());
            stmt.setString(2, discente.getEmailAluno());
            stmt.setString(3, discente.getMatriculaAluno());
            
            stmt.executeUpdate();
        }
    }

    public void deletarDiscente(String matricula) throws SQLException {
        String sql = "DELETE FROM discente WHERE matricula_aluno = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, matricula);
            stmt.executeUpdate();
        }
    }

    public Discente buscarDiscente(String matricula) throws SQLException {
        String sql = "SELECT * FROM discente WHERE matricula_aluno = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, matricula);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Discente discente = new Discente(
                    rs.getInt("id"),
                    rs.getString("nome_aluno"),
                    rs.getString("matricula_aluno"),
                    rs.getString("email_aluno")
                );
                discente.setResultados(resultadoDAO.buscarPorDiscente(discente.getId()));
                return discente;
            }
        }
        return null;
    }
}