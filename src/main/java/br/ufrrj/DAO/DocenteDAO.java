package br.ufrrj.DAO;

import br.ufrrj.model.Docente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DocenteDAO {
    private Connection connection;

    public DocenteDAO(Connection connection) {
        this.connection = connection;
    }

    public void cadastrarDocente(Docente docente) throws SQLException {
        String sql = "INSERT INTO docente (nome_docente, identificacao, eh_coordenador, eh_chefe_departamento) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, docente.getNomeDocente());
            stmt.setString(2, docente.getIdentificacao());
            stmt.setBoolean(3, docente.isEhCoordenador());
            stmt.setBoolean(4, docente.isEhChefeDepartamento());
            stmt.executeUpdate();
        }
    }

    public void atualizarDocente(Docente docente) throws SQLException {
        String sql = "UPDATE docente SET nome_docente = ?, eh_coordenador = ?, eh_chefe_departamento = ? WHERE identificacao = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, docente.getNomeDocente());
            stmt.setBoolean(2, docente.isEhCoordenador());
            stmt.setBoolean(3, docente.isEhChefeDepartamento());
            stmt.setString(4, docente.getIdentificacao());
            stmt.executeUpdate();
        }
    }

    public void deletarDocente(String identificacao) throws SQLException {
        String sql = "DELETE FROM docente WHERE identificacao = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, identificacao);
            stmt.executeUpdate();
        }
    }

    public Docente buscarDocente(String identificacao) throws SQLException {
        String sql = "SELECT * FROM docente WHERE identificacao = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, identificacao);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Docente docente = new Docente(
                    rs.getString("nome_docente"),
                    rs.getString("identificacao")
                );
                docente.setEhCoordenador(rs.getBoolean("eh_coordenador"));
                docente.setEhChefeDepartamento(rs.getBoolean("eh_chefe_departamento"));
                return docente;
            }
        }
        return null;
    }
}
