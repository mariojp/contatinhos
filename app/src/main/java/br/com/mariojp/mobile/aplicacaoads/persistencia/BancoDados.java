package br.com.mariojp.mobile.aplicacaoads.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BancoDados extends SQLiteOpenHelper {

    public static final String BANCO_NOME = "banco.db";
    public static final int BANCO_VERSAO = 3;




    public BancoDados(Context context){
        super(context,BANCO_NOME,null,BANCO_VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CONTATO (_id INTEGER PRIMARY KEY," +
                "NOME TEXT," +
                "TELEFONE TEXT );");
    }

    //1 - 1 -> A onCreate 01/01 v1
    //2 - 1 -> A          05/01 v2
    //3 - 1 -> A    B onCreate
    //4 - 2 -> A onUpgrade
    //5 - 3 -> A onUpgrade   B onUpgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 2:
                db.execSQL("ALTER TABLE CONTATO ADD NOTA INTEGER");
            case 3:
                db.execSQL("ALTER TABLE CONTATO ADD COLUNA2 INTEGER");
            case 4:
                db.execSQL("DROP TABLE CONTATO");
        }
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS CONTATO");
    }

    //url
}
