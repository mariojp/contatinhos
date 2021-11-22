package br.com.mariojp.mobile.aplicacaoads.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Servico {

    private static Servico instancia;
    private WebService webService;


    private Servico(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webService = retrofit.create(WebService.class);
    }

    public static Servico getInstacia(){
        if(instancia == null){
            instancia = new Servico();
        }
        return instancia;
    }

    public WebService getWebService(){
        return webService;
    }


}
