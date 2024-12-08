package br.ufrrj.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufrrj.connection.Conexao;
import br.ufrrj.model.Discente;

public class DiscenteDAO {
	public void cadastrarDiscente(Discente d) throws ClassNotFoundException {
		String sql = "INSERT INTO discente (nome, usuario, senha, matricula, email) VALUES (?,?,?,?,?)";
		
		try {
			PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
			
			ps.setString(1, d.getNome());
			ps.setString(2, d.getUsuario());
			ps.setString(3, d.getSenha());
			ps.setString(4, d.getMatricula());
			ps.setString(5, d.getEmail());
			
            ps.executeUpdate();
            System.out.println("Discente cadastrado com sucesso!");
		} catch (SQLException e) {
            System.out.println("Erro ao cadastrar carona: " + e.getMessage());
            e.printStackTrace();
        }
	}
	
	public Discente buscarUsuario(String usuario, String senha) {
		String sql = "SELECT * FROM discente WHERE usuario = ? AND senha = ?";
		try{
			PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
			ps.setString(1, usuario);
			ps.setString(2, senha);
			ResultSet rs = ps.executeQuery();
			Discente d = new Discente();
			rs.next();
			d.setIdDiscente(rs.getInt("ID_Discente"));
			d.setNome(rs.getString("nome"));
			d.setUsuario(rs.getString("usuario"));
			d.setSenha(rs.getString("senha"));
			d.setEmail(rs.getString("email"));

			return d;
		}
		catch (Exception e){
			System.out.println("Erro ao buscar usuario: " + e.getMessage());
			return null;
		}
	}
}
