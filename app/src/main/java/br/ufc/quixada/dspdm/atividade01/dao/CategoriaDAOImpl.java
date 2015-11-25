package br.ufc.quixada.dspdm.atividade01.dao;

import android.util.Log;

import java.io.NotActiveException;
import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.dspdm.atividade01.model.Categoria;
import br.ufc.quixada.dspdm.atividade01.model.Nota;

/**
 * Created by andersonuchoa on 24/11/15.
 */
public class CategoriaDAOImpl implements CategoriaDAO {


    private static CategoriaDAOImpl categoriaDAOImpl = null;
    private static ArrayList<Categoria> categoriasList = new ArrayList<>();
    private static Categoria semCategoria  = null;
    private static Categoria categoriaPadrao  = null;


    public static CategoriaDAOImpl newIntance() {

        if (categoriaDAOImpl == null) {
            categoriaDAOImpl = new CategoriaDAOImpl();
            semCategoria = new Categoria(SEM_CATEGORIA, null);
            categoriaPadrao = null;
            categoriaDAOImpl.addCategoria(semCategoria, false);
        }

        return categoriaDAOImpl;

    }


    @Override
    public void addCategoria(Categoria categoria, boolean padrao) {
 categoriasList.add(categoria);
        if (padrao){
            categoriaPadrao = categoria;

        }
    }

    @Override
    public List<Categoria> getCategoria() {
        return categoriasList;
    }

    @Override
    public List<Nota> getNotas() {

      List<Nota> notas = new ArrayList<>();
        for (Categoria categoria : categoriasList){
            notas.addAll(categoria.getNotas());
        }

        return notas;
    }

    @Override
    public void addNota(Nota nota, Categoria categoria) {

        if(categoriasList.contains(categoria)){

        }else{
            addCategoria(categoria, false);
        }

        categoria.addNota(nota);
        Log.i("teste", categoriasList.size() + "");
        Log.i("teste", categoria.getNome());

    }


    @Override
    public void addNota(Nota nota) {
    semCategoria.addNota(nota);

    }

    @Override
    public Categoria getCategoria(String nome) {
        for(Categoria  categoria : categoriasList){
            if(categoria.getNome().toLowerCase().equals(nome.toLowerCase()))
                return categoria;

        }
        return null;

    }

    @Override
    public Categoria getCategoriaPadrao() {
        return categoriaPadrao;
    }
}