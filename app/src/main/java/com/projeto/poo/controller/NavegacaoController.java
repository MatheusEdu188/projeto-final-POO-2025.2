package com.projeto.poo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NavegacaoController {

    private void trocarTela(ActionEvent event, String caminho) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource(caminho));

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void irParaPrincipal(ActionEvent event) throws IOException {
        trocarTela(event, "/home.fxml");
    }

    @FXML
    private void login(ActionEvent event) throws IOException {
        trocarTela(event, "/login.fxml");
    }

    @FXML
    private void registrar(ActionEvent event) throws IOException {
        trocarTela(event, "/register.fxml");
    }

    @FXML
    private void salvar(ActionEvent event) throws IOException {
        trocarTela(event, "/salvarFilme.fxml");
    }

    @FXML
    private void editar(ActionEvent event) throws IOException {
        trocarTela(event, "/editarFilme.fxml");
    }
}
