package com.controllers;



import com.App;
import com.model.Usuario;
import com.util.Dao;
import com.util.GerenciadorDeSenhas;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.time.LocalDate;


public class LoginController {
    @FXML
    private TextField nome;

    @FXML
    private PasswordField senha;


    @FXML
    public void entrar(){
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
        if (user == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Ocorreu um erro!");
            alert.setContentText("Nome de usuario incorreto");
            alert.show();
        }
        if (GerenciadorDeSenhas.verificarSenha(senha.getText(), user.getSenha())){
            try{
                App.trocarTela("menu.fxml");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Ocorreu um erro!");
            alert.setContentText("Senha incorreta");
            alert.show();
        }
    }


}
