package br.com.mariojp.mobile.aplicacaoads;

import br.com.mariojp.mobile.aplicacaoads.persistencia.ContatoRoomDAO;

public class Repository {

    private ContatoRoomDAO contatoRoomDAO;

    public Repository(ContatoRoomDAO contatoRoomDAO){
        this.contatoRoomDAO = contatoRoomDAO;
    }
}
