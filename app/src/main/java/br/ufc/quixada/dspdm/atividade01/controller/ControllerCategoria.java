package br.ufc.quixada.dspdm.atividade01.controller;

import java.util.List;

import br.ufc.quixada.dspdm.atividade01.dao.CategoriaDAO;
import br.ufc.quixada.dspdm.atividade01.dao.CategoriaDAOImpl;
import br.ufc.quixada.dspdm.atividade01.model.Categoria;

/**
 * Created by andersonuchoa on 24/11/15.
 */
public class ControllerCategoria {

   public String AREAS[] = {"Sem Area", "Blog", "Notícia", "Educação", "Trabalho"};


    private CategoriaDAO categoriaDAO;

    public ControllerCategoria(){
        categoriaDAO = CategoriaDAOImpl.newIntance();
    }


    public List<Categoria> getCategorias() {
        return categoriaDAO.getCategoria();
    }

    public void addCategoria(Categoria categoria, boolean padrao){

        categoriaDAO.addCategoria(categoria, padrao);
    }


    public Categoria getCategoria(String nomeCategoria) {

        return categoriaDAO.getCategoria(nomeCategoria);
    }


    public Categoria getCategoriaPadrao() {

        return categoriaDAO.getCategoriaPadrao();
    }
}


