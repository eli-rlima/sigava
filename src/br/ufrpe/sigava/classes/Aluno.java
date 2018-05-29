package br.ufrpe.sigava.classes;

import java.time.LocalDate;
import java.util.ArrayList;

public class Aluno extends Pessoa{
    private ArrayList<Disciplina> disciplinasCadastradas= new ArrayList<Disciplina>();
    public Aluno(String nome, String email, char sexo, LocalDate dataNascimento, String senha, String cpf){
        super(nome, email, sexo, dataNascimento, senha, cpf);
    }
}
