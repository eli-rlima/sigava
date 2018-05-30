package br.ufrpe.sigava.repositorios;

import br.ufrpe.sigava.pessoa.Professor;
import java.util.ArrayList;


public class repositorioProfessor {
    private ArrayList<Professor> repositorioProfessor = new ArrayList<Professor>();

    public repositorioProfessor(){
    }

    public boolean adicionarProf (Professor professor){
        return this.repositorioProfessor.add(professor);
    }

    public boolean removeProf (Professor professor){
        return this.repositorioProfessor.add(professor);
    }

    public Professor buscarProf (String nome){
        Professor professor = null;

        for(int i = 0; i<this.repositorioProfessor.size(); i++){
            if(this.repositorioProfessor.get(i).getNome().equalsIgnoreCase(nome)){
                professor = this.repositorioProfessor.get(i);
            }
        }
        return professor;
    }

    public boolean existeProf (Professor professor){
        return this.repositorioProfessor.contains(professor);
    }

}
