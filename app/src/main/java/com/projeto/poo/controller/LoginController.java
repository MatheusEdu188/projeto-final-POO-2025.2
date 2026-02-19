package com.projeto.poo.controller;

import java.io.IOException;

import com.projeto.poo.DAO.UsuarioDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController {

    private NavegacaoController navegacao = new NavegacaoController();


    @FXML

    private void irParaHome(ActionEvent event) throws IOException {
        navegacao.trocarTela(event, "/home.fxml");
    }
    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private Label lblMensagem;


    private UsuarioDAO usuariodao = new UsuarioDAO();


    @FXML
    private void fazerLogin(ActionEvent event) throws IOException {

        String usuario = txtUsuario.getText();
        String senha = txtSenha.getText();

        if (usuariodao.buscarUsuario(usuario, senha) != null) {
            lblMensagem.setText("Login realizado com sucesso!");
            irParaHome(event);
        } else {
            lblMensagem.setText("Usuário ou senha inválidos.");
        }
    }


    @FXML

    private void irParaRegistro(MouseEvent event) throws IOException {
        navegacao.trocarTela(event, "/register.fxml");
    }




    
}
