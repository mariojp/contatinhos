package br.com.mariojp.mobile.aplicacaoads.persistencia;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.com.mariojp.mobile.aplicacaoads.model.Contato;

@Database(entities = {Contato.class}, version = 1)
public abstract class BancoDadosRoom extends RoomDatabase {

    private static BancoDadosRoom instacia;

    static ExecutorService databaseWriterExecutor = Executors.newFixedThreadPool(3);

    public static BancoDadosRoom getInstancia(Context context){

            if (instacia == null) {
                synchronized(BancoDadosRoom.class) {
                    instacia = Room.databaseBuilder(context, BancoDadosRoom.class, "contatos.db")
                            .allowMainThreadQueries()
                        //.setQueryExecutor(databaseWriterExecutor)
                            .build();
                }
            }
        return instacia;
    }



    public abstract ContatoRoomDAO contatoRoomDAO();
}
