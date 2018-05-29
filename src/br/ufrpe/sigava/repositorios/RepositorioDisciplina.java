package br.ufrpe.sigava.repositorios;

import br.ufrpe.sigava.classes.Disciplina;

import java.util.ArrayList;

public class RepositorioDisciplina {
    private ArrayList<Disciplina> repositorioDisciplina = new ArrayList<Disciplina>();

    public RepositorioDisciplina(){}

    public boolean adicionar(Disciplina disciplina){
        return this.repositorioDisciplina.add(disciplina);
    }
    public boolean remover(Disciplina disciplina){
        return this.repositorioDisciplina.remove(disciplina);
    }
    public Disciplina buscar(String nome){
        Disciplina disciplina = null;
        for (int i = 0; i < this.repositorioDisciplina.size(); i++){
            if (this.repositorioDisciplina.get(i).getNome().equalsIgnoreCase(nome)){
                disciplina = this.repositorioDisciplina.get(i);
            }
        }
        return disciplina;
    }
    public boolean existe(Disciplina disciplina){
        return this.repositorioDisciplina.contains(disciplina);
    }
}
