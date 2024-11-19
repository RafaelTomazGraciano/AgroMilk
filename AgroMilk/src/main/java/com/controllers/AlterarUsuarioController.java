package com.controllers;

import com.App;
import com.model.Usuario;
import com.model.Usuario;
import com.util.Dao;
import com.util.GerenciadorDeSenhas;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class AlterarUsuarioController {

    @FXML
    TextField nome;

    @FXML
    PasswordField senha;

    @FXML
    private ComboBox<String> listar;

    @FXML
    private void initialize() {
        Dao<Usuario> dao = new Dao<Usuario>(Usuario.class);
        ArrayList<String> listaTemp = new ArrayList<>();
        for (Usuario user : dao.listarTodos()){
            listaTemp.add(user.getNome());
        }
        listar.getItems().setAll(listaTemp);
    }

    @FXML
    public void alterar(){
        if (nome.getText().isEmpty() || senha.getText().isEmpty() || listar.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Ocorreu um erro!");
            alert.setContentText("Preencha os campos");
            alert.show();
            return;
        }
        Dao<Usuario> dao = new Dao(Usuario.class);
        String hashSenha = GerenciadorDeSenhas.gerarHashSenha(senha.getText());
        Usuario usuario = new Usuario(nome.getText(), hashSenha);
        dao.alterar("nome", listar.getValue(), usuario);

        //aviso de sucesso
        Alert sucesso = new Alert(Alert.AlertType.INFORMATION);
        sucesso.setTitle("Sucesso");
        sucesso.setHeaderText("Sucesso");
        sucesso.setContentText("Alteração realizada com sucesso!");
        sucesso.show();

        //deixa os campos em branco
        nome.setText("");
        senha.setText("");
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
