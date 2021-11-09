package br.com.mariojp.mobile.aplicacaoads;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
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

import java.util.ArrayList;
import java.util.List;

import br.com.mariojp.mobile.aplicacaoads.adapter.ContatoAdapter;
import br.com.mariojp.mobile.aplicacaoads.adapter.CustomAdapter;
import br.com.mariojp.mobile.aplicacaoads.model.Contato;
import br.com.mariojp.mobile.aplicacaoads.model.GerenciadorContatos;
import br.com.mariojp.mobile.aplicacaoads.persistencia.BancoDados;
import br.com.mariojp.mobile.aplicacaoads.persistencia.BancoDadosRoom;
import br.com.mariojp.mobile.aplicacaoads.persistencia.ContatoDAO;

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


    private FloatingActionButton adicionar;
    private RecyclerView listView;
    private List<Contato> dados =new ArrayList<>();
    private CustomAdapter adapter;

    private ContatoViewModel contatoViewModel;


    private ActivityResultLauncher<Intent> contatoActivityResultLauncher;

    BancoDadosRoom room;
    public static final int CONTACT_REQUEST = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        BancoDados banco = new BancoDados(this);
//         dao = new ContatoDAO(banco);


        //BancoDadosRoom.getInstancia(this).contatoRoomDAO().insert(new Contato("NOme","telefone","email@email",2));

        Repository repository = new Repository(BancoDadosRoom.getInstancia(this).contatoRoomDAO());
        ContatoModelFactory fabrica = new ContatoModelFactory(repository);
        ViewModelProvider provider = new ViewModelProvider(this,fabrica);
        contatoViewModel = provider.get(ContatoViewModel.class);

        listView = findViewById(R.id.main_list_contatos);
        adapter = new CustomAdapter(dados);
        listView.setAdapter(adapter);
        listView.setLayoutManager(new LinearLayoutManager(this));

        contatoViewModel.getContatos().observe(this, list -> adapter.update(list));


        contatoActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        contatoActivityResult(data);
                    }
                });

        adicionar = findViewById(R.id.main_fab_adicionar);
        Log.d("AppADS","AppADS onCreate");




    }


    public void excluiContato(Contato contato){
        dados.remove(contato);
        adapter.notifyDataSetChanged();
        Toast.makeText(MainActivity.this,"Removido: "+contato.getNome(), Toast.LENGTH_LONG ).show();

    }


    public void actionAdicionar(View v ){
        Intent intent = new Intent(this, ContatoActivity.class);
        //startActivityForResult(intent,CONTACT_REQUEST);
        contatoActivityResultLauncher.launch(intent);
//        dados.add(new Contato("Marcos", "1111111", "marcos@email"));
//        adapter.notifyDataSetChanged();
    }

    protected void contatoActivityResult(Intent data) {
        Contato contato = (Contato) data.getSerializableExtra(Contato.CONTATO);
        room.contatoRoomDAO().insert(contato);
        dados.clear();
        dados.addAll(room.contatoRoomDAO().listAll());
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == CONTACT_REQUEST) {
            if(resultCode == RESULT_OK){
                Contato contato = (Contato) data.getSerializableExtra(Contato.CONTATO);
                dados.add(contato);
                adapter.notifyDataSetChanged();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
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