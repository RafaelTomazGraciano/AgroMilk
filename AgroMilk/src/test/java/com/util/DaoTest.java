package com.util;

import com.model.Usuario;
import com.model.Vaca;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DaoTest {

    @Test
    public void testInserirUsuario() {
        Usuario user = new Usuario("Rafael", GerenciadorDeSenhas.gerarHashSenha("abcd1234"));
        Dao<Usuario> dao = new Dao(Usuario.class);
        dao.inserir(user);

    }

    @Test
    public void testInserirVaca() {
        Vaca vaca = new Vaca("A1","Mimosa","Gir");
        Dao<Vaca> dao = new Dao(Vaca.class);
        dao.inserir(vaca);
    }

    @Test
    public void testBuscarPorChave(){
        Dao<Usuario> dao = new Dao(Usuario.class);
        Usuario user = dao.buscarPorChave("nome", "Rafael");
        System.out.println(user.getSenha());
    }


}