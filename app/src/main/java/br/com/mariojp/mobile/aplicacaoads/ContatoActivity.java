package br.com.mariojp.mobile.aplicacaoads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;

import br.com.mariojp.mobile.aplicacaoads.model.Contato;

public class ContatoActivity extends AppCompatActivity {

    private TextInputLayout til;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);
        til = findViewById(R.id.contato_til_name);
    }

    public void adicionar(View view){
        String name = til.getEditText().getText().toString();
        getIntent().putExtra(Contato.CONTATO,new Contato(name,"88888","email@email.com", 1));
        setResult(RESULT_OK,getIntent());
        finish();
    }
}