package br.com.mariojp.mobile.aplicacaoads.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.mariojp.mobile.aplicacaoads.R;
import br.com.mariojp.mobile.aplicacaoads.model.Contato;

public class ContatoAdapter extends BaseAdapter {

    private final List<Contato> dados;
    private Context context;

    public ContatoAdapter(Context context, List<Contato> dados){
        this.context = context;
        this.dados = dados;
    }


    @Override
    public int getCount() {
        return dados.size();
    }

    @Override
    public Object getItem(int position) {
        return dados.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        Log.d("AppADS","getView");
        if(view == null) {
            Log.d("AppADS","LayoutInflater");
            view = LayoutInflater.from(context).inflate(R.layout.contato_item_layout, parent, false);
        }
        TextView tvNome = view.findViewById(R.id.item_contato_nome);
        TextView tvEmail = view.findViewById(R.id.item_contato_email);
        TextView tvTelefone = view.findViewById(R.id.item_contato_telefone);

        Contato contato = dados.get(position);
        tvNome.setText(contato.getNome());
        tvEmail.setText(contato.getEmail());
        tvTelefone.setText(contato.getTelefone());

        return view;
    }


}
