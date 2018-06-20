package br.ufrpe.sigava.repositorios;
import br.ufrpe.sigava.classes.Tarefa;

import java.time.LocalDate;
import java.util.ArrayList;


public class RepositorioTarefa implements IRepositorioTarefa {

    private ArrayList <Tarefa> repositorioTarefas;
    private static RepositorioTarefa instance;

    private RepositorioTarefa(){
        this.repositorioTarefas = new ArrayList<Tarefa>();
    }


    public static RepositorioTarefa getInstance (){
        if (instance == null){
            instance = new RepositorioTarefa();
        }
        return instance;
    }



    @Override
    public boolean adicionar(Tarefa tarefa){
        return this.repositorioTarefas.add(tarefa);
    }

    @Override
    public boolean adicionar (String descricao, LocalDate dataInicio, LocalDate dataTermino, int codigoTarefa){
        Tarefa tarefa = new Tarefa(descricao,dataInicio,dataTermino,codigoTarefa);
        return adicionar(tarefa);
    }

    @Override
    public boolean remover(Tarefa tarefa){
        return this.repositorioTarefas.remove(tarefa);
    }
    @Override
    public Tarefa buscar(int codigo){
        Tarefa tarefa = null;
        for (int i = 0; i < this.repositorioTarefas.size(); i++){
            if (this.repositorioTarefas.get(i).getCodigoTarefa() == codigo){
                tarefa = this.repositorioTarefas.get(i);
            }
        }
        return tarefa;
    }
    @Override
    public boolean existe(Tarefa tarefa){
        return this.repositorioTarefas.contains(tarefa);
    }

}

