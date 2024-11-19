package com.controllers;

import com.App;
import com.model.Vaca;
import com.util.Dao;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ExcluirVacaController {

    @FXML
    private ComboBox<String> listar;

    @FXML
    private void initialize() {
        Dao<Vaca> dao = new Dao(Vaca.class);
        ArrayList<String> listaTemp = new ArrayList<>();
        for (Vaca v : dao.listarTodos()){
            listaTemp.add(v.getBrinco());
        }
        listar.getItems().setAll(listaTemp);
    }

    @FXML
    public void excluir() {
        if (listar.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Ocorreu um erro!");
            alert.setContentText("Preencha os campos");
            alert.show();
            return;
        }
        Dao<Vaca> dao = new Dao(Vaca.class);
        dao.excluir("brinco", listar.getValue());

        //aviso de sucesso
        Alert sucesso = new Alert(Alert.AlertType.INFORMATION);
        sucesso.setTitle("Sucesso");
        sucesso.setHeaderText("Sucesso");
        sucesso.setContentText("Exclusão realizada com sucesso!");
        sucesso.show();

        //deixa os campos em branco
        listar.setValue(null);
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
