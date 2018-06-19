package br.ufrpe.sigava.repositorios;

import br.ufrpe.sigava.pessoa.Aluno;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IRepositorioAluno {

    boolean adicionar (Aluno aluno);

    boolean adicionar (String nome, String email, char sexo, LocalDate dataNascimento, String senha, String cpf);

    boolean adicionarMarcacao(String semestre, Aluno aluno, int codigoTarefa, LocalDate dataTermino);

    boolean remover (Aluno aluno);

    Aluno buscar (String cpf);

    boolean existe (Aluno aluno);


    boolean existeCronograma (Aluno aluno, String nomeCronograma);

}
