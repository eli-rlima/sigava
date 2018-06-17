package br.ufrpe.sigava.repositorios;

import br.ufrpe.sigava.classes.Tarefa;

public interface IRepositorioTarefa {

    public boolean adicionar(Tarefa tarefa);
    public boolean remover(Tarefa tarefa);
    public Tarefa buscar(int codigo);
    public boolean existe(Tarefa tarefa);
}
