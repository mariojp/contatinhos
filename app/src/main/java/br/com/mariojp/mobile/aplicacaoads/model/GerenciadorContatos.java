package br.com.mariojp.mobile.aplicacaoads.model;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorContatos {

    public static List<Contato> listaContatos(){
        List<Contato> lista = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            lista.add(new Contato("Marcos", "1111111", "marcos@email", 1));
            lista.add(new Contato("Felipe", "2222222", "felipe@email", 1));
            lista.add(new Contato("Ian", "3333333", "ian@email", 1));
            lista.add(new Contato("Samuel", "444444", "samuel@email", 1));
            lista.add(new Contato("Sidney", "555555", "sidney@email", 1));
        }
        return lista;
    }
}
