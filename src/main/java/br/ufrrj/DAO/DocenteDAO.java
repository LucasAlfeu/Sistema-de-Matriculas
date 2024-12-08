package br.ufrrj.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufrrj.connection.Conexao;
import br.ufrrj.model.Discente;
import br.ufrrj.model.Docente;

public class DocenteDAO {
	public void cadastrarDocente(Docente d) throws ClassNotFoundException {
		String sql = "INSERT INTO docente (usuario, senha, nome, identificacao) VALUES (?,?,?,?)";
		
		try {
			PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
			
			ps.setString(1, d.getUsuario());
			ps.setString(2, d.getSenha());
			ps.setString(3, d.getNome());
			ps.setString(4, d.getIdentificacao());
			
            ps.executeUpdate();
            System.out.println("Docente cadastrado com sucesso!");
		} catch (SQLException e) {
            System.out.println("Erro ao cadastrar docente: " + e.getMessage());
            e.printStackTrace();
        }
	}
	
	public Docente buscarUsuario(String usuario, String senha) {
		String sql = "SELECT * FROM docente WHERE usuario = ? AND senha = ?";
		try{
			PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
			ps.setString(1, usuario);
			ps.setString(2, senha);
			ResultSet rs = ps.executeQuery();
			Docente d = new Docente();
			rs.next();
			d.setIdDocente(rs.getInt("ID_Docente"));
			d.setNome(rs.getString("nome"));
			d.setUsuario(rs.getString("usuario"));
			d.setSenha(rs.getString("senha"));
			d.setEhChefeDeDepartamento(Boolean.parseBoolean(rs.getString("eh_chefe_de_departamento")));
			d.setEhCoordenador(Boolean.parseBoolean(rs.getString("eh_coordenador")));
			
			return d;
		}
		catch (Exception e){
			System.out.println("Erro ao buscar usuario: " + e.getMessage());
			return null;
		}
	}
}
