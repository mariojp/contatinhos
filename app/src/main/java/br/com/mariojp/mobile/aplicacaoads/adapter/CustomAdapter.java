package br.com.mariojp.mobile.aplicacaoads.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.mariojp.mobile.aplicacaoads.R;
import br.com.mariojp.mobile.aplicacaoads.model.Contato;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private final List<Contato> dados;

    public CustomAdapter(List<Contato> dados) {
        this.dados = dados;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contato_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contato contato = dados.get(position);
        holder.getTvEmail().setText(contato.getEmail());
        holder.getTvNome().setText(contato.getNome());
        holder.getTvTelefone().setText(contato.getTelefone());
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNome;
        private TextView tvEmail;
        private TextView tvTelefone;

        public ViewHolder(@NonNull View view) {
            super(view);
             tvNome = view.findViewById(R.id.item_contato_nome);
             tvEmail = view.findViewById(R.id.item_contato_email);
             tvTelefone = view.findViewById(R.id.item_contato_telefone);
        }

        public TextView getTvNome() {
            return tvNome;
        }

        public TextView getTvEmail() {
            return tvEmail;
        }

        public TextView getTvTelefone() {
            return tvTelefone;
        }

    }

}
