package br.ufrpe.sigava.pessoa;

import br.ufrpe.sigava.classes.Disciplina;

import java.time.LocalDate;
import java.util.ArrayList;

public class Professor extends Pessoa {
    private ArrayList<Disciplina> disciplinasCadastradas = new ArrayList<Disciplina>();
    public Professor(String nome, String email, char sexo, LocalDate dataNascimento, String senha, String cpf){
        super(nome, email, sexo, dataNascimento, senha, cpf);
    }

    public boolean adicionarDisciplina(Disciplina disciplina){
        return this.disciplinasCadastradas.add(disciplina);
    }

    public boolean removerDisciplina(Disciplina disciplina){
        return this.disciplinasCadastradas.remove(disciplina);
    }

    public Disciplina buscarDisciplina(String nomeDisciplina){
        Disciplina disciplina = null;
        for (int i = 0; i < this.disciplinasCadastradas.size(); i++){
            if (this.disciplinasCadastradas.get(i).getNome().equals(nomeDisciplina)){
                disciplina = this.disciplinasCadastradas.get(i);
            }
        }
        return disciplina;
    }

    public boolean existeDisciplina(Disciplina disciplina){
        return this.disciplinasCadastradas.contains(disciplina);
    }
}
