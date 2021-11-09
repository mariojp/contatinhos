package br.com.mariojp.mobile.aplicacaoads.persistencia;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.mariojp.mobile.aplicacaoads.model.Contato;

public class ContatoDAO {

    private BancoDados bancoDados;

    public ContatoDAO(BancoDados bancoDados){
        this.bancoDados = bancoDados;
    }

    public List<Contato> obterTodos(){
        // SELECT DISTINCT NOME FROM CONTATO;
        String[] colunas =new String[]{"NOME","TELEFONE","NOTA"};
        // SELECT NOME, TELEFONE, NOTA
        // FROM CONTATO WHERE  NOME LIKE '?%' AND TELEFONE LIKE '?%'
        // GROUP BY TELEFONE HAVING NOTA > 3ORDER BY NOME DESC;
        Cursor cursor = bancoDados.getReadableDatabase().query("CONTATO",colunas, "NOME LIKE '?%' AND TELEFONE LIKE '?%'",
                new String[]{"A","71"}, "TELEFONE", "NOTA > 3", "NOME DESC");

        //dados = GerenciadorContatos.listaContatos();
        List<Contato> dados = new ArrayList<Contato>();
        while (cursor.moveToNext()){
            Contato contato = new Contato();
            contato.setNome(cursor.getString(
                    cursor.getColumnIndexOrThrow("NOME")));
            dados.add(contato);
        }

        return dados;
    }

    public void inserir(Contato contato){
        //INSERT INTO CONTATO (NOME,TELEFONE) VALUES(? , ? )
        ContentValues values = new ContentValues();
        values.put("NOME", contato.getNome());
        values.put("TELEFONE", contato.getTelefone());
        bancoDados.getWritableDatabase().insert("CONTATO","NOTA",values );

    }

}
