package br.ufrpe.sigava.repositorios;

import br.ufrpe.sigava.classes.Disciplina;
import br.ufrpe.sigava.pessoa.Aluno;

import java.util.ArrayList;

public class RepositorioAluno {
    private ArrayList<Aluno> repositorioAluno = new ArrayList<Aluno>();

    public RepositorioAluno(){}

    public boolean adicionarAluno (Aluno aluno){
        return this.repositorioAluno.add(aluno);
    }

    public boolean removerAluno (Aluno aluno){
        return this.repositorioAluno.remove(aluno);
    }

    public Aluno buscarAluno (String nome){
        Aluno aluno = null;
        for (int i = 0; i < this.repositorioAluno.size(); i++) {
            if (this.repositorioAluno.get(i).getNome().equalsIgnoreCase(nome)) {
                aluno = this.repositorioAluno.get(i);
            }
        }
        return aluno;
    }

    public boolean existeAluno (Aluno aluno) {
        return this.repositorioAluno.contains(aluno);
    }
}
