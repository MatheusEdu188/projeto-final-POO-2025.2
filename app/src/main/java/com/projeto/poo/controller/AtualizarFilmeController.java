package com.projeto.poo.controller;
import java.io.IOException;

import com.projeto.poo.DAO.FilmeDAO;
import com.projeto.poo.DAO.UsuarioDAO;
import com.projeto.poo.model.Filme;




import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class AtualizarFilmeController {

    @FXML

    private TextField campoTitulo;

    @FXML 
    private Spinner<Integer> campoID;

    

    @FXML

    private Spinner<Integer> campoDuracao;



    @FXML
    public void initialize() {
        campoDuracao.setValueFactory(
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 500, 0)
        );
        campoID.setValueFactory(
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 500, 0)
        );
    }

    @FXML

    private TextField campoGenero;

    @FXML

    private TextField campoClassi;

    @FXML

    private Text textoSalvo;

    
    

    @FXML

    private void editarFilme(){
        Filme filme = new Filme();

        String titulo = campoTitulo.getText().trim();
        int duracao = campoDuracao.getValue();
        String genero = campoGenero.getText().trim();
        String classi = campoClassi.getText().trim();
        int id = campoID.getValue();

        if(titulo.isEmpty() || genero.isEmpty() || classi.isEmpty() || duracao == 0 || id == 0){
            textoSalvo.setText("Preencha todos os campos!");
            return;
        }

        filme.setTitulo(titulo);
        filme.setDuracao(duracao);
        filme.setGenero(genero);
        filme.setClassificacao(classi);
        filme.setId(id);

        

        FilmeDAO filmedao = new FilmeDAO();

        filmedao.updateFilme(filme);
        textoSalvo.setText("Filme Salvo Com Sucesso!");
        
        campoTitulo.clear();
        campoGenero.clear();
        campoClassi.clear();
        campoDuracao.getValueFactory().setValue(0);
        campoID.getValueFactory().setValue(0);

    }



    private NavegacaoController navegacao = new NavegacaoController();


    @FXML

    private void irParaHome(ActionEvent event) throws IOException {
        navegacao.trocarTela(event, "/home.fxml");
    }
    
}
