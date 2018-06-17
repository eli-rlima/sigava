package br.ufrpe.sigava.repositorios;

import br.ufrpe.sigava.pessoa.Professor;

import java.time.LocalDate;
import java.util.ArrayList;


public class RepositorioProfessor implements IRepositorioProfessor {
    private ArrayList<Professor> repositorioProfessor = new ArrayList<Professor>();

    public RepositorioProfessor(){
    }

    @Override
    public boolean adicionarProfessor (Professor professor){
        return this.repositorioProfessor.add(professor);
    }

    @Override
    public boolean adicionarProfessor (String nome, String email, char sexo, LocalDate dataNascimento, String senha, String cpf){
        Professor professor =  new Professor(nome, email, sexo,dataNascimento,senha,cpf);
        return adicionarProfessor(professor);
    }
    @Override
    public boolean removeProfessor (Professor professor){
        return this.repositorioProfessor.add(professor);
    }
    @Override
    public Professor buscarProfessor (String nome){
        Professor professor = null;

        for(int i = 0; i<this.repositorioProfessor.size(); i++){
            if(this.repositorioProfessor.get(i).getNome().equalsIgnoreCase(nome)){
                professor = this.repositorioProfessor.get(i);
            }
        }
        return professor;
    }
    @Override
    public boolean existeProfessor (Professor professor){
        return this.repositorioProfessor.contains(professor);
    }

}
