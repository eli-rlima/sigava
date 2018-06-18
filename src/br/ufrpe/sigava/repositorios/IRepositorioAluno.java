package br.ufrpe.sigava.repositorios;

import br.ufrpe.sigava.pessoa.Aluno;

import java.time.LocalDate;

public interface IRepositorioAluno {

    boolean adicionar (Aluno aluno);

    boolean adicionar (String nome, String email, char sexo, LocalDate dataNascimento, String senha, String cpf);

    boolean remover (Aluno aluno);

    Aluno buscar (String nome);

    boolean existe (Aluno aluno);
}
