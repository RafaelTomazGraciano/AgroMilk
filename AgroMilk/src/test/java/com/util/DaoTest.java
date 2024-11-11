package com.util;

import com.model.Usuario;
import com.model.Vaca;
import org.junit.jupiter.api.Test;

class DaoTest {

    @Test
    public void testInserirUsuario() {
        Usuario user = new Usuario("Rafael", "0123456789");
        Dao<Usuario> dao = new Dao(Usuario.class);
        dao.inserir(user);

    }

    @Test
    public void testInserirVaca() {
        Vaca vaca = new Vaca("A1","Mimosa","Gir");
        Dao<Vaca> dao = new Dao(Vaca.class);
        dao.inserir(vaca);
    }


}