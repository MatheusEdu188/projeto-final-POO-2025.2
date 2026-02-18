package com.projeto.poo.controller;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NavegacaoController {

    public void trocarTela(Event event, String caminho) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource(caminho));

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }
}
