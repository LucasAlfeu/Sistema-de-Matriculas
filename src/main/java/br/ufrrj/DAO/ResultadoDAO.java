package br.ufrrj.DAO;

import br.ufrrj.model.Resultado;
import br.ufrrj.model.Disciplina;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResultadoDAO {
    private Connection connection;
    private DisciplinaDAO disciplinaDAO;

    public ResultadoDAO(Connection connection) {
        this.connection = connection;
        this.disciplinaDAO = new DisciplinaDAO(connection);
    }

    public void salvar(Resultado resultado, int discenteId) throws SQLException {
        String sql = "INSERT INTO resultado (disciplina_id, discente_id, status, data, nota) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, resultado.getDisciplina().getId());
            stmt.setInt(2, discenteId);
            stmt.setBoolean(3, resultado.isStatus());
            stmt.setDate(4, resultado.getData());
            stmt.setFloat(5, resultado.getNota());
            
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                resultado.setId(rs.getInt(1));
            }
        }
    }

    public List<Resultado> buscarPorDiscente(int discenteId) throws SQLException {
        List<Resultado> resultados = new ArrayList<>();
        String sql = "SELECT * FROM resultado WHERE discente_id = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, discenteId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Disciplina disciplina = disciplinaDAO.buscarDisciplina(rs.getInt("disciplina_id"));
                Resultado resultado = new Resultado(
                    rs.getInt("id"),
                    disciplina,
                    rs.getBoolean("status"),
                    rs.getDate("data"),
                    rs.getFloat("nota")
                );
                resultados.add(resultado);
            }
        }
        return resultados;
    }

    public void atualizar(Resultado resultado) throws SQLException {
        String sql = "UPDATE resultado SET status = ?, nota = ? WHERE id = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setBoolean(1, resultado.isStatus());
            stmt.setFloat(2, resultado.getNota());
            stmt.setInt(3, resultado.getId());
            
            stmt.executeUpdate();
        }
    }
}