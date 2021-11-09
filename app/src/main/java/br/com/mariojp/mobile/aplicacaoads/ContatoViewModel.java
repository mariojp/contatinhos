package br.com.mariojp.mobile.aplicacaoads;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import br.com.mariojp.mobile.aplicacaoads.model.Contato;

public class ContatoViewModel extends ViewModel {

    private Repository repository;

    private MutableLiveData<List<Contato>> contatos;

    public ContatoViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<List<Contato>> getContatos(){
        if(contatos == null){
            contatos = new MutableLiveData<List<Contato>>();
            List<Contato> temp = new ArrayList<>();
            temp.add(new Contato("nome","32232","12312",2));
            this.contatos.postValue(temp);
        }
        return contatos;
    }

}
