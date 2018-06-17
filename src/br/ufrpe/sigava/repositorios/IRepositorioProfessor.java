package br.ufrpe.sigava.repositorios;

import br.ufrpe.sigava.pessoa.Professor;

import java.time.LocalDate;

public interface IRepositorioProfessor {

    public boolean adicionarProfessor (Professor professor);
    public boolean adicionarProfessor (String nome, String email, char sexo, LocalDate dataNascimento, String senha, String cpf);
    public boolean removeProfessor (Professor professor);
    public Professor buscarProfessor (String nome);
    public boolean existeProfessor (Professor professor);


}
