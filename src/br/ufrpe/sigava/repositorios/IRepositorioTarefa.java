package br.ufrpe.sigava.repositorios;

import br.ufrpe.sigava.classes.Tarefa;

import java.time.LocalDate;

public interface IRepositorioTarefa {
    /**
     * Adiciona uma tarefa no repositório tarefa
     *
     * @param tarefa
     *           tarefa a ser adionada
     *
     * @return true ou false, caso seja adicionado true, caso não false.
     */
    public boolean adicionar(Tarefa tarefa);

    /**
     * Adiciona uma nova tarefa no repositório tarefa
     *
     * @param descricao
     *            descrição da tarefa
     * @param dataInicio
     *            data de início da tarefa
     * @param dataTermino
     *            data de término
     * @param codigoTarefa
     *            código da tarefa
     *
     * @return true ou false, caso seja adicionado true, caso não false.
     */
    public boolean adicionar (String descricao, LocalDate dataInicio, LocalDate dataTermino, int codigoTarefa);

    /**
     * Remove uma tareda do repositório tarefa
     *
     * @param tarefa
     *          tarefa a ser removida
     *
     * @return true ou false, caso seja removida true, caso não false.
     */
    public boolean remover(Tarefa tarefa);

    /**
     * Procura uma tarefa no repositório tarefa
     *
     * @param codigo
     *          código da tarefa ser buscada
     *
     * @return a tarefa procurada
     */
    public Tarefa buscar(int codigo);

    /**
     * Verifica se a tarefa existe
     *
     * @param tarefa
     *           tarefa a ser procurada
     *
     * @return true ou false, caso seja encontrada true, caso não false.
     */
    public boolean existe(Tarefa tarefa);
}
