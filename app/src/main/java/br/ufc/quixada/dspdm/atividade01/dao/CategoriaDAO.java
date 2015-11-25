package br.ufc.quixada.dspdm.atividade01.dao;

import java.util.List;

import br.ufc.quixada.dspdm.atividade01.model.Categoria;
import br.ufc.quixada.dspdm.atividade01.model.Nota;

/**
 * Created by andersonuchoa on 24/11/15.
 */
public interface CategoriaDAO {


    String SEM_CATEGORIA = "Sem Categoria";

   public void addCategoria(Categoria categoria, boolean padrao);
    public List<Categoria> getCategoria();
    public List<Nota> getNotas();
    public void addNota(Nota nota, Categoria categoria);
    public void addNota(Nota nota);
    public Categoria getCategoria(String nome);
    public Categoria getCategoriaPadrao();

}
