package com.projeto.poo.controller;

import com.projeto.poo.dao.FilmeDAO;
import com.projeto.poo.model.Filme;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.List;

public class TelaListarController {

    @FXML

    private VBox vboxUsuarios;

    private FilmeDAO filmeDAO = new FilmeDAO();

    @FXML

    public void initialize(){
        carregarUsuarios();
    }

    private void carregarUsuarios(){
        List<Filme> lista = filmeDAO.listar();

        for(Filme u: lista){
            Label nome = new Label(
                "ID: " + u.getId() + "\n| Titulo: " + u.getTitulo() + "\n| Classificação: " + u.getClassificacao() + "\n| Duração: " + u.getDuracao() + "\n| Genero: " + u.getGenero()

            );

            nome.setStyle(
                    "-fx-background-color: #2c3e50;" +
                    "-fx-text-fill: white;" +
                    "-fx-padding: 10;" +
                    "-fx-background-radius: 5;"
            );

            nome.setMaxWidth(Double.MAX_VALUE);

            vboxUsuarios.getChildren().add(nome);
        }
    }
    
}
