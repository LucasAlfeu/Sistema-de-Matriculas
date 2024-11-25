package br.ufrrj.DAO;

import br.ufrrj.model.Disciplina;
import br.ufrrj.model.Discente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO {
    private Connection connection;

    public DisciplinaDAO(Connection connection) {
        this.connection = connection;
    }

    public void cadastrarDisciplina(Disciplina disciplina) throws SQLException {
        String sql = "INSERT INTO disciplina (nome_disciplina, carga_horaria, max_docentes) VALUES (?, ?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, disciplina.getNomeDisciplina());
            stmt.setInt(2, disciplina.getCargaHoraria());
            stmt.setInt(3, disciplina.getMaxDocentes());
            
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                disciplina.setId(rs.getInt(1));
            }
        }
    }

    public void atualizarDisciplina(Disciplina disciplina) throws SQLException {
        String sql = "UPDATE disciplina SET nome_disciplina = ?, carga_horaria = ?, max_docentes = ? WHERE id = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, disciplina.getNomeDisciplina());
            stmt.setInt(2, disciplina.getCargaHoraria());
            stmt.setInt(3, disciplina.getMaxDocentes());
            stmt.setInt(4, disciplina.getId());
            
            stmt.executeUpdate();
        }
    }

    public void deletarDisciplina(int id) throws SQLException {
        String sql = "DELETE FROM disciplina WHERE id = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public Disciplina buscarDisciplina(int id) throws SQLException {
        String sql = "SELECT * FROM disciplina WHERE id = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Disciplina(
                    rs.getInt("id"),
                    rs.getString("nome_disciplina"),
                    rs.getInt("carga_horaria"),
                    rs.getInt("max_docentes")
                );
            }
        }
        return null;
    }

    public List<Disciplina> listarTodas() throws SQLException {
        List<Disciplina> disciplinas = new ArrayList<>();
        String sql = "SELECT * FROM disciplina";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Disciplina disciplina = new Disciplina(
                    rs.getInt("id"),
                    rs.getString("nome_disciplina"),
                    rs.getInt("carga_horaria"),
                    rs.getInt("max_docentes")
                );
                disciplinas.add(disciplina);
            }
        }
        return disciplinas;
    }
}