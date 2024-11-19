package com.controllers;

import com.App;
import com.model.Usuario;
import com.util.Dao;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

public class ExcluirUsuarioController {
    @FXML
    private ComboBox<String> listar;

    @FXML
    private void initialize() {
        Dao<Usuario> dao = new Dao(Usuario.class);
        ArrayList<String> listaTemp = new ArrayList<>();
        for (Usuario user : dao.listarTodos()){
            listaTemp.add(user.getNome());
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
        Dao<Usuario> dao = new Dao(Usuario.class);
        dao.excluir("nome", listar.getValue());

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
