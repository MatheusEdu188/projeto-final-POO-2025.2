package com.projeto.poo.controller;

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
    private void fazerLogin() {

        String usuario = txtUsuario.getText();
        String senha = txtSenha.getText();

        if (usuario.equals("admin") && senha.equals("123")) {
            lblMensagem.setText("Login realizado com sucesso!");
        } else {
            lblMensagem.setText("Usuário ou senha inválidos.");
        }
    }
}
