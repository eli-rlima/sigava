package br.ufrpe.sigava.repositorios;

import br.ufrpe.sigava.classes.Disciplina;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class RepositorioDisciplina implements IRepositorioDisciplina {
    private ArrayList<Disciplina> repositorioDisciplina = new ArrayList<Disciplina>();

    public RepositorioDisciplina(){}
    @Override
    public boolean adicionar(Disciplina disciplina){
        return this.repositorioDisciplina.add(disciplina);
    }

    @Override
    public boolean adicionar(String nome, LocalDate dataInicio, DayOfWeek diaAula, int duracaoAula, int cargaHoraria){
        Disciplina disciplina = new Disciplina(nome, dataInicio, diaAula, duracaoAula, cargaHoraria);
        return adicionar(disciplina);
    }
    @Override
    public boolean remover(Disciplina disciplina){
        return this.repositorioDisciplina.remove(disciplina);
    }

    @Override
    public Disciplina buscar(String nome){
        Disciplina disciplina = null;
        for (int i = 0; i < this.repositorioDisciplina.size(); i++){
            if (this.repositorioDisciplina.get(i).getNome().equalsIgnoreCase(nome)){
                disciplina = this.repositorioDisciplina.get(i);
            }
        }
        return disciplina;
    }
    @Override
    public boolean existe(Disciplina disciplina){
        return this.repositorioDisciplina.contains(disciplina);
    }
}
