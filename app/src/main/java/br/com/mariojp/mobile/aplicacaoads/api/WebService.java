package br.com.mariojp.mobile.aplicacaoads.api;

import java.util.List;

import br.com.mariojp.mobile.aplicacaoads.model.Contato;
import retrofit2.Call;
import retrofit2.http.GET;

public interface WebService {


     @GET("users/mariojp/repos")
    Call<List<Contato>> todosContatos();
}
