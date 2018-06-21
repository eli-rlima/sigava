package br.ufrpe.sigava.repositorios;

import br.ufrpe.sigava.pessoa.Aluno;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IRepositorioAluno {
    /**
     * Adiciona um aluno ao repositório aluno
     *
     * @param aluno
     *         aluno a ser adicionado
     *
     * @return true ou false, caso tenha sido adicionado true, caso não false.
     */
    boolean adicionar (Aluno aluno);

    /**
     * Adiciona um novo aluno ao repositório aluno
     *
     * @param nome
     *         nome do aluno
     * @param email
     *         email do aluno
     * @param sexo
     *         sexo do aluno
     * @param dataNascimento
     *         data de nascimento do aluno
     * @param senha
     *         senha do aluno
     * @param cpf
     *         cpf do aluno
     *
     * @return true ou false, caso tenha sido adicionado true, caso não false.
     */
    boolean adicionar (String nome, String email, char sexo, LocalDate dataNascimento, String senha, String cpf);

    /**
     * Adiciona a marcação referente a tarefa selecionada ao repositorio do marcaçoes no cronograma.
     *
     * @param semestre
     *          semestre a ser adicionada a marcação
     * @param aluno
     *          referência do aluno
     * @param codigoTarefa
     *          código da tarefa a ser adicionada
     * @param dataTermino
     *          data de término da tarefa
     *
     * @return true ou false, caso tenha sido adicionado true, caso não false.
     */
    boolean adicionarMarcacao(String semestre, Aluno aluno, int codigoTarefa, LocalDate dataTermino);

    /**
     * Remove um aluno do repositório de alunos
     *
     * @param aluno
     *         aluno a ser removido
     *
     * @return true ou false, caso tenha sido removido true, caso não false.
     */
    boolean remover (Aluno aluno);

    /**
     * Procura um aluno no repositório de alunos
     *
     * @param cpf
     *         cpf do aluno procurado
     *
     * @return O Aluno procurado
     */
    Aluno buscar (String cpf);

    /**
     * Verifica se existe o aluno no repositório de alunos
     *
     * @param aluno
     *          aluno a ser procurado
     *
     * @return true ou false, caso tenha sido encontrado true, caso não false.
     */
    boolean existe (Aluno aluno);

    /**
     * Verifica se existe o cronograma no repositório de cronogramas do aluno
     *
     * @param aluno
     *          referência do aluno
     * @param nomeCronograma
     *          nome do cronograma a ser procurado.
     * @return true ou false, caso tenha sido encontrado true, caso não false.
     */
    boolean existeCronograma (Aluno aluno, String nomeCronograma);

}
