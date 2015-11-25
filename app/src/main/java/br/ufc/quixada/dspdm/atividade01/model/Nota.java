package br.ufc.quixada.dspdm.atividade01.model;

/**
 * Created by andersonuchoa on 24/11/15.
 */
public class Nota {

    private String nome;
    private String descricao;


    public Nota() {

    }

    public Nota(String nome, String descricao) {
        this();
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return this.nome + " : " + this.descricao;
    }




}
