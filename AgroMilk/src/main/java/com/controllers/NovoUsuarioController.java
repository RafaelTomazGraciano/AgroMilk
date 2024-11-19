package com.controllers;

import com.App;
import com.model.Usuario;
import com.util.Dao;
import com.util.GerenciadorDeSenhas;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class NovoUsuarioController {
    @FXML
    private TextField nome;

    @FXML
    private PasswordField senha;


    @FXML
    public void cadastrar(){
        if (nome.getText().isEmpty() || senha.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Ocorreu um erro!");
            alert.setContentText("Preencha os campos");
            alert.show();
            return;
        }
        Dao<Usuario> dao = new Dao(Usuario.class);
        Usuario user = dao.buscarPorChave("nome", nome.getText());
        if(user == null) {
            String hashSenha = GerenciadorDeSenhas.gerarHashSenha(senha.getText());
            user = new Usuario(nome.getText(), hashSenha);
            dao.inserir(user);

            //aviso de sucesso
            Alert sucesso = new Alert(Alert.AlertType.INFORMATION);
            sucesso.setTitle("Sucesso");
            sucesso.setHeaderText("Sucesso");
            sucesso.setContentText("Cadastro realizado com sucesso!");
            sucesso.show();

            //deixa os campos em branco
            nome.setText("");
            senha.setText("");
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Ocorreu um erro!");
            alert.setContentText("Ja existe um usuario com este nome");
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
