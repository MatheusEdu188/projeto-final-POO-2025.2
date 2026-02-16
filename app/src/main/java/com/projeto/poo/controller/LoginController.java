package com.projeto.poo.controller;

import com.projeto.poo.dao.UsuarioDAO;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private Label lblMensagem;


    @FXML
    private UsuarioDAO usuariodao = new UsuarioDAO();


    public void fazerLogin(){

        String usuario = txtUsuario.getText();
        String senha = txtSenha.getText();

        if (usuariodao.existeUsuario(usuario) && usuariodao.existeUsuario(senha)) {
            lblMensagem.setText("Login realizado com sucesso!");
        } else {
            lblMensagem.setText("Usuário ou senha inválidos.");
        }
    }
}
