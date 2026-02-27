package com.projeto.poo.controller;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.projeto.poo.controller.user.EditarUsuarioController;

public class NavegacaoController {

    public void trocarTela(Event event, String caminho) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource(caminho));

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }

    public void trocarTela(Event event, String caminho, int id) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(caminho));
        Parent root = loader.load();

        EditarUsuarioController controller = loader.getController();
        controller.receberId(id);

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }
}
