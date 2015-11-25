package br.ufc.quixada.dspdm.atividade01.controller;

import java.util.List;

import br.ufc.quixada.dspdm.atividade01.dao.CategoriaDAO;
import br.ufc.quixada.dspdm.atividade01.dao.CategoriaDAOImpl;
import br.ufc.quixada.dspdm.atividade01.model.Categoria;
import br.ufc.quixada.dspdm.atividade01.model.Nota;

/**
 * Created by andersonuchoa on 24/11/15.
 */
public class ControllerNota {

    private CategoriaDAO categoriaDAO;

    public ControllerNota(){
        categoriaDAO = CategoriaDAOImpl.newIntance();
    }


    public List<Nota> getNotas() {
        return categoriaDAO.getNotas();
    }

        public void addNota(Nota nota) {
            categoriaDAO.addNota(nota);
    }

    public void addNota(Nota nota, Categoria categoria) {
        categoriaDAO.addNota(nota, categoria);
    }
}