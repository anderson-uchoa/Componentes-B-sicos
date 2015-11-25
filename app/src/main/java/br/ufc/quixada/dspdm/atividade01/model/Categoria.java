package br.ufc.quixada.dspdm.atividade01.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andersonuchoa on 24/11/15.
 */
public class Categoria {

    private String nome;
    private List<Nota> notas;
    private String areaRelacionada;


    public Categoria() {
        this.notas = new ArrayList<>();
    }


    public  Categoria(String nome, String areaRelacionada){
        this();
        this.nome = nome;
        this.areaRelacionada = areaRelacionada;


    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public String getAreaRelacionada() {
        return areaRelacionada;
    }

    public void setAreaRelacionada(String areaRelacionada) {
        this.areaRelacionada = areaRelacionada;
    }

    public void addNota (Nota nota){
        this.notas.add(nota);
    }

    @Override
    public String toString(){
        return this.nome;
    }

    @Override
    public boolean equals(Object object) {
        if ( this == object ) return true;

        if ( !(object instanceof Categoria) ) return false;
        Categoria  categoria = (Categoria) object;

        return categoria.getNome().toLowerCase().equals(this.getNome().toLowerCase());
    }
}
