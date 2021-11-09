package br.com.mariojp.mobile.aplicacaoads.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Contato implements Serializable {

    public final static String CONTATO = "CONTATO";

    @PrimaryKey
    private int id;

    private String nome;
    private String telefone;
    private String email;
    private Integer nota;



    public Contato(String nome, String telefone, String email, Integer nota) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.nota = nota;
    }

    public Contato() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }
}
