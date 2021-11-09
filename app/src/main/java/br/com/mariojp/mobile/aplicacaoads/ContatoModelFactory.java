package br.com.mariojp.mobile.aplicacaoads;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ContatoModelFactory implements ViewModelProvider.Factory {

    private Repository repositorio;

    public ContatoModelFactory(Repository repositorio) {
        this.repositorio = repositorio;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        return (T) new ContatoViewModel(repositorio);
    }
}
