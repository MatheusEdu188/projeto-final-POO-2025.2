package com.projeto.poo.controller.user;

import java.io.IOException;
import java.util.List;

import com.projeto.poo.DAO.FilmeDAO;
import com.projeto.poo.DAO.UsuarioDAO;
import com.projeto.poo.controller.NavegacaoController;
import com.projeto.poo.model.Filme;
import com.projeto.poo.model.Usuario;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class EditarUsuarioController {
    NavegacaoController navegacao = new NavegacaoController();

    @FXML
    private Spinner<Integer> campoID;
    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoSenha;
    @FXML
    private Text textoSalvo;
    
    
    @FXML
    private void editarUsuario(){
        Usuario usuario = new Usuario();

        String nome = campoNome.getText().trim();
        String senha = campoSenha.getText().trim();
        int id = campoID.getValue();

        if(nome.isEmpty() || senha.isEmpty() || id == 0){
            textoSalvo.setText("Preencha todos os campos!");
            return;
        }

        usuario.setNome_usuario(nome);
        usuario.setSenha(senha);
        usuario.setId_usuario(id);

        

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        usuarioDAO.editarUsuario(usuario);;
        textoSalvo.setText("Usuario Editado Com Sucesso!");
        
        campoNome.clear();
        campoSenha.clear();
        campoID.getValueFactory().setValue(0);

    }



    @FXML
    private void irParaHome(ActionEvent event) throws IOException {
        navegacao.trocarTela(event, "/home.fxml");
    }
}
