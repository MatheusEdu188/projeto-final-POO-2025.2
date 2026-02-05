package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;
import utils.*;

public class UsuarioDAO {
    
    public UsuarioDAO() {};

    public void salvar(Usuario usuario) throws SQLException{
        String sql = "INSERT INTO usuario (nome, senha, cpf) VALUES (?,?,?)";
        try (Connection conn = ConnectionFactory.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1,usuario.getNome());
            pstmt.setString(2, usuario.getSenha());
            pstmt.setString(3, usuario.getCpf());

            pstmt.execute();

        }
    }

    public List<Usuario> listar() throws SQLException {
        String sql = "SELECT * FROM usuario";
        try(Connection conn = ConnectionFactory.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            List<Usuario> lista = new ArrayList<>();

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                lista.add(
                    new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nome"),
                        rs.getString("senha"),
                        rs.getString("cpf")
                    )
                );
            }
            return lista;
        }
    }

    public Usuario buscar(int id) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";

        try (Connection conn = ConnectionFactory.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                Usuario u = new Usuario();
                u.setId_usuario(id);
                u.setNome(rs.getString("nome"));
                u.setSenha(rs.getString("senha"));
                u.setCpf(rs.getString("cpf"));

                return u;
            }

            return null;
        }
    }

    
}
