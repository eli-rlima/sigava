package br.ufrpe.sigava.repositorios;

import br.ufrpe.sigava.classes.Disciplina;
import br.ufrpe.sigava.pessoa.Aluno;

import java.util.ArrayList;

public class RepositorioAluno {
    private ArrayList<Aluno> repositorioAluno = new ArrayList<Aluno>();

    public RepositorioAluno(){}

    public boolean adicionar (Aluno aluno){
        return this.repositorioAluno.add(aluno);
    }

    public boolean remover (Aluno aluno){
        return this.repositorioAluno.remove(aluno);
    }

    public Aluno buscar (String nome){
        Aluno aluno = null;
        for (int i = 0; i < this.repositorioAluno.size(); i++) {
            if (this.repositorioAluno.get(i).getNome().equalsIgnoreCase(nome)) {
                aluno = this.repositorioAluno.get(i);
            }
        }
        return aluno;
    }

    public boolean existe (Aluno aluno) {
        return this.repositorioAluno.contains(aluno);
    }
}
