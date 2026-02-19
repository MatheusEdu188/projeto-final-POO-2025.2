package com.projeto.poo.controller;

import com.projeto.poo.DAO.FilmeDAO;
import com.projeto.poo.DAO.UsuarioDAO;
import com.projeto.poo.model.Filme;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.io.IOException;
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
            HBox linha = new HBox(10);

            Label nome = new Label(
                "ID: " + u.getId() + "\n| Titulo: " + u.getTitulo() + "\n| Classificação: " + u.getClassificacao() + "\n| Duração: " + u.getDuracao() + "\n| Genero: " + u.getGenero()

            );

            Button btnExcluir = new Button("Excluir");

            btnExcluir.setOnAction(e -> {
                filmeDAO.remover(u.getId());
                atualizarLista();
            });

            nome.setStyle(
                    "-fx-background-color: #2c3e50;" +
                    "-fx-text-fill: white;" +
                    "-fx-padding: 10;" +
                    "-fx-background-radius: 5;"
            );

            linha.getChildren().addAll(nome, btnExcluir);

            nome.setMaxWidth(Double.MAX_VALUE);

            vboxUsuarios.getChildren().add(linha);
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

    private NavegacaoController navegacao = new NavegacaoController();

    @FXML

    private void irParaSalvar(ActionEvent event) throws IOException {
        navegacao.trocarTela(event, "/salvarFilme.fxml");
    }

    @FXML

    private void irParaEditar(ActionEvent event) throws IOException {
        navegacao.trocarTela(event, "/editarFilme.fxml");
    }

    @FXML

    private void irParaLogin(ActionEvent event) throws IOException {
        navegacao.trocarTela(event, "/login.fxml");
    }

    @FXML
    private void irParaUsuario(ActionEvent event) throws IOException {
        navegacao.trocarTela(event, "/user/listaUsuario.fxml");
    }
    
}
