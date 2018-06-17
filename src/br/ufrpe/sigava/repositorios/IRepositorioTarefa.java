package br.ufrpe.sigava.repositorios;

import br.ufrpe.sigava.classes.Tarefa;

import java.time.LocalDate;

public interface IRepositorioTarefa {

    public boolean adicionar(Tarefa tarefa);
    public boolean adicionar (String descricao, LocalDate dataInicio, LocalDate dataTermino, int codigoTarefa);
    public boolean remover(Tarefa tarefa);
    public Tarefa buscar(int codigo);
    public boolean existe(Tarefa tarefa);
}
