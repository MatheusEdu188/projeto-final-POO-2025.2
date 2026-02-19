package com.projeto.poo.controller;


import java.io.IOException;

import com.projeto.poo.dao.FilmeDAO;
import com.projeto.poo.model.Filme;




import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class AdicionarFilmeController {

    @FXML

    private TextField campoTitulo;

    @FXML

    private Spinner<Integer> campoDuracao;

    @FXML
    public void initialize() {
        campoDuracao.setValueFactory(
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
    private void salvarFilme(){
        String titulo = campoTitulo.getText().trim();
        int duracao = campoDuracao.getValue();
        String genero = campoGenero.getText().trim();
        String classi = campoClassi.getText().trim();

        if(titulo.isEmpty() || genero.isEmpty() || classi.isEmpty() || duracao == 0){
            textoSalvo.setText("Preencha todos os campos!");
            return;
        }

        Filme filme = new Filme();
        filme.setTitulo(titulo);
        filme.setDuracao(duracao);
        filme.setGenero(genero);
        filme.setClassificacao(classi);

        

        FilmeDAO filmedao = new FilmeDAO();

        filmedao.salvar(filme);
        textoSalvo.setText("Filme Salvo Com Sucesso!");
        
        campoTitulo.clear();
        campoGenero.clear();
        campoClassi.clear();
        campoDuracao.getValueFactory().setValue(0);



    }
    


    private NavegacaoController navegacao = new NavegacaoController();


    @FXML

    private void irParaHome(ActionEvent event) throws IOException {
        navegacao.trocarTela(event, "/home.fxml");
    }

}
