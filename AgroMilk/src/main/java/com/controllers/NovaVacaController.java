package com.controllers;

import com.App;
import com.model.Usuario;
import com.model.Vaca;
import com.util.Dao;
import com.util.GerenciadorDeSenhas;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class NovaVacaController {

    @FXML
    private TextField nome;

    @FXML
    private TextField brinco;

    @FXML
    private TextField raca;


    @FXML
    public void cadastrar(){
        if (nome.getText().isEmpty() || brinco.getText().isEmpty() || raca.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Ocorreu um erro!");
            alert.setContentText("Preencha os campos");
            alert.show();
            return;
        }

        Dao<Vaca> dao = new Dao<Vaca>(Vaca.class);
        Vaca vaca = dao.buscarPorChave("brinco", brinco.getText());
        if(vaca == null) {

            vaca = new Vaca(brinco.getText(), nome.getText(), raca.getText());
            dao.inserir(vaca);

            //aviso de sucesso
            Alert sucesso = new Alert(Alert.AlertType.INFORMATION);
            sucesso.setTitle("Sucesso");
            sucesso.setHeaderText("Sucesso");
            sucesso.setContentText("Cadastro realizado com sucesso!");
            sucesso.show();

            //deixa os campos em branco
            nome.setText("");
            brinco.setText("");
            raca.setText("");
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Ocorreu um erro!");
            alert.setContentText("Ja existe uma vaca com este brinco");
            alert.show();
        }
    }

    @FXML
    public void voltar(){
        try{
            App.trocarTela("menu.fxml");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
