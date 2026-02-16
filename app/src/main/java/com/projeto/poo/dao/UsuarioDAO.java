package com.projeto.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.projeto.poo.model.Usuario;
import com.projeto.poo.util.ConnectionFactory;


public class UsuarioDAO{
    public void registro(Usuario usuario){
        String sql = "INSERT INTO usuario(nome_usuario, senha) Values(?, ?)";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
    ) {
        ps.setString(1, usuario.getNome_usuario());
        ps.setString(2, usuario.getSenha());

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

}