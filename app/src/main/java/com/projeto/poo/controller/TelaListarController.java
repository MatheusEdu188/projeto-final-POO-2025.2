package com.projeto.poo.controller;

import com.projeto.poo.dao.FilmeDAO;
import com.projeto.poo.dao.UsuarioDAO;
import com.projeto.poo.model.Filme;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class TelaListarController {

    @FXML

    private VBox vboxUsuarios;

    private FilmeDAO filmeDAO = new FilmeDAO();

    @FXML

    public void initialize(){
        carregarFilmes();
    }

    private void carregarFilmes(){
        
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

    @FXML

    private TextField formBuscaFilme;

    @FXML

    private Button btnBusca;



    @FXML

    private void carregarBusca(){
        vboxUsuarios.getChildren().clear();


        FilmeDAO filmeDAO = new FilmeDAO();

        String texto = formBuscaFilme.getText();

        List<Filme> filmes = filmeDAO.buscarPorTitulo(texto);

        for(Filme f: filmes){
            Label nome = new Label(
                "ID: " + f.getId() + "\n| Titulo: " + f.getTitulo() + "\n| Classificação: " + f.getClassificacao() + "\n| Duração: " + f.getDuracao() + "\n| Genero: " + f.getGenero()
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

    @FXML

    private Button btnAtualizar;

    @FXML

    private void atualizarLista(){
        vboxUsuarios.getChildren().clear();
        carregarFilmes();

    }
    
}
