package com.projeto.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;
import java.util.ArrayList;
import java.util.List;

import com.projeto.poo.model.Usuario;
import com.projeto.poo.util.ConnectionFactory;

public class UsuarioDAO {
    public void registro(Usuario usuario) {
        String sql = "INSERT INTO usuario(nome_usuario, senha) Values(?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, usuario.getNome_usuario());

            String senhahash = BCrypt.hashpw(usuario.getSenha(), BCrypt.gensalt());
            ps.setString(2, senhahash);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean existeUsuario(String nome) {

        String sql = "SELECT COUNT(*) FROM usuario WHERE nome_usuario = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Usuario buscarUsuario(String nome, String senha) {
        String sql = "SELECT * FROM usuario WHERE nome_usuario = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    String senhaHashBanco = rs.getString("senha");
                    if (BCrypt.checkpw(senha, senhaHashBanco)) {
                        Usuario usuario = new Usuario();

                        usuario.setNome_usuario(rs.getString("nome_usuario"));
                        usuario.setSenha(senhaHashBanco);

                        return usuario;
                    }
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void deletarUsuario(int id) {
        String sql = "DELETE FROM usuario where id_usuario = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public List<Usuario> listarUsuario() {
        String sql = "Select * from usuario";
        List<Usuario> usuarios = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setNome_usuario(rs.getString("nome_usuario"));

                usuarios.add(usuario);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public void editarUsuario(Usuario usuario) {
        String sql = "UPDATE usuario SET nome_usuario = ?, senha = ?  WHERE id_usuario = ?;";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome_usuario());

            String senhahash = BCrypt.hashpw(usuario.getSenha(), BCrypt.gensalt());
            stmt.setString(2, senhahash);

            stmt.setInt(3, usuario.getId_usuario());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> buscarPorNome(String nome) {
        String sql = "SELECT * FROM usuario WHERE nome_usuario LIKE ?";
        List<Usuario> usuarios = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + nome + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setNome_usuario(rs.getString("nome_usuario"));

                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;

    }

    public Usuario buscarUsuario(int id) {
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario(
                        id,
                        rs.getString("nome_usuario"),
                        "");
                return usuario;
            }
            return null;
        } catch (SQLException e) {
            
            e.printStackTrace();
            return null;
        }

    }
}