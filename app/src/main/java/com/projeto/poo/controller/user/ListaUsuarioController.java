package com.projeto.poo.controller.user;

import java.io.IOException;
import java.util.List;

import com.projeto.poo.dao.UsuarioDAO;
import com.projeto.poo.controller.NavegacaoController;
import com.projeto.poo.model.Usuario;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ListaUsuarioController {
    
    @FXML
    private VBox vboxUsuarios;

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    private NavegacaoController navegacao = new NavegacaoController();

    @FXML
    public void initialize(){
        carregarUsuarios();
    }

    private void carregarUsuarios(){
        
        List<Usuario> lista = usuarioDAO.listarUsuario();

        for(Usuario u: lista){
            HBox linha = new HBox(10);

            Label nome = new Label(
                "ID: " + u.getId_usuario() + "\n| Nome: " + u.getNome_usuario()
            );

            Button btnExcluir = new Button("Excluir");

            Button btnEditar = new Button("Editar");

            btnExcluir.setOnAction(e -> {
                usuarioDAO.deletarUsuario(u.getId_usuario());
                atualizarLista();
            });

            btnEditar.setOnAction(e -> {
                try {
                    navegacao.trocarTela(e, "/user/editarUsuario.fxml", u.getId_usuario());
                } catch (Exception erro) {
                    System.out.println(erro);
                }
            });

        
            nome.setStyle(
                    "-fx-background-color: #2c3e50;" +
                    "-fx-text-fill: white;" +
                    "-fx-padding: 10;" +
                    "-fx-background-radius: 5;"
            );

            linha.getChildren().addAll(nome, btnExcluir);
            linha.getChildren().add(btnEditar);

            nome.setMaxWidth(Double.MAX_VALUE);

            vboxUsuarios.getChildren().add(linha);

            
        }
    }

    @FXML

    private void atualizarLista(){
        vboxUsuarios.getChildren().clear();
        carregarUsuarios();
    }




    @FXML
    private TextField formBuscaUsuario;

    @FXML
    private Button btnBusca;

    @FXML
    private void carregarBusca(){
        vboxUsuarios.getChildren().clear();


        UsuarioDAO usuarioDAO = new UsuarioDAO();

        String texto = formBuscaUsuario.getText();

        List<Usuario> usuarios = usuarioDAO.buscarPorNome(texto);

        for(Usuario u: usuarios){
            Label nome = new Label(
                "ID: " + u.getId_usuario() + "\n| Nome: " + u.getNome_usuario()
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
    private void irParaHome(ActionEvent event) throws IOException {
        navegacao.trocarTela(event, "/home.fxml");
    }

    @FXML
    private void irParaEditarUsuario(ActionEvent event) throws IOException {
        navegacao.trocarTela(event, "/user/editarUsuario.fxml");
    }
}
