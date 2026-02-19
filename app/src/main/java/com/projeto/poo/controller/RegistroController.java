package com.projeto.poo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;

import java.io.IOException;
import java.sql.SQLException;

import com.projeto.poo.dao.UsuarioDAO;
import com.projeto.poo.model.Usuario;

public class RegistroController {

    @FXML 
    private TextField txtuser;

    @FXML
    private PasswordField txtsenha;

    @FXML 
    private Label lblSucesso;


    private UsuarioDAO usuariodao = new UsuarioDAO();

    public void gerarRegistro(){
        String nome = txtuser.getText();
        String senha = txtsenha.getText();

        if(senha.isEmpty() || nome.isEmpty()){
            lblSucesso.setText("Preencha todos os campos.");
            return;
        }

        if (usuariodao.existeUsuario(nome)) {
            lblSucesso.setText("Usuario já registrado");
            return;
            
        }

        try {
            Usuario usuario = new Usuario();
            usuario.setNome_usuario(nome);
            usuario.setSenha(senha);

            usuariodao.registro(usuario);
            lblSucesso.setText("Usuario Registrado Com Sucesso.");
        } catch (Exception e) {
            if (e.getMessage().contains("unique")) {
                lblSucesso.setText("Usuário já existe!");
             }
        }
    }

    private NavegacaoController navegacao = new NavegacaoController();


    @FXML

    private void irParaLogin(MouseEvent event) throws IOException {
        navegacao.trocarTela(event, "/login.fxml");
    }
    
}
