package br.com.mariojp.mobile.aplicacaoads;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import br.com.mariojp.mobile.aplicacaoads.adapter.ContatoAdapter;
import br.com.mariojp.mobile.aplicacaoads.model.Contato;
import br.com.mariojp.mobile.aplicacaoads.model.GerenciadorContatos;

public class MainActivity extends AppCompatActivity {

    //AVI
    //TODO: TELA DE CADASTRO
    //TODO: LIGAR PRA O TELEFONE
    //TODO: MENU DE CONTEXTO
    //TODO: CONFIRMAR EXCLUSÃO
    //TODO: FOTO NO CONTATO

    //AVII
    //TODO: GRAVAR EM BANCO LOCAL
    //TODO: CONSUMIR UM SERVIÇO CEP
    //TODO: ENDERECO

    //KOTLIN

    private FloatingActionButton adicionar;
    private ListView listView;
    private final List<Contato> dados = GerenciadorContatos.listaContatos();
    private ContatoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.main_list_contatos);
        adicionar = findViewById(R.id.main_fab_adicionar);
        Log.d("AppADS","AppADS onCreate");
        adapter = new ContatoAdapter(this,dados);
        listView.setAdapter(adapter);
        //Evento -> Click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contato contato = (Contato) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,contato.toString(), Toast.LENGTH_LONG ).show();
            }
        });


        //Evento -> Click longo
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Contato contato = (Contato) parent.getItemAtPosition(position);
                excluiContato(contato);
                return true;
            }
        });

    }


    public void excluiContato(Contato contato){
        dados.remove(contato);
        adapter.notifyDataSetChanged();
        Toast.makeText(MainActivity.this,"Removido: "+contato.getNome(), Toast.LENGTH_LONG ).show();

    }


    public void actionAdicionar(View v ){
        dados.add(new Contato("Marcos", "1111111", "marcos@email"));
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_1:
                Toast toast1 = Toast.makeText(this,"OLA ITEM 1!",Toast.LENGTH_LONG);
                toast1.show();
                break;
            case R.id.menu_item_2:
                Toast toast2 = Toast.makeText(this,"OLA ITEM 2!",Toast.LENGTH_LONG);
                toast2.show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("AppADS","AppADS onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("AppADS","AppADS onResume");

    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d("AppADS","AppADS onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("AppADS","AppADS onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("AppADS","AppADS onDestroy");

    }




    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("AppADS","AppADS onRestart");

    }
}