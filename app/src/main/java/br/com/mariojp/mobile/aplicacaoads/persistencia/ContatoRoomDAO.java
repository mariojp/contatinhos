package br.com.mariojp.mobile.aplicacaoads.persistencia;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import br.com.mariojp.mobile.aplicacaoads.model.Contato;

@Dao
public interface ContatoRoomDAO {


    @Insert
    void  insert(Contato  contato);

    @Delete
    int excluir(Contato ... contato);

    @Query("SELECT * FROM Contato")
    List<Contato> listAll();
}
