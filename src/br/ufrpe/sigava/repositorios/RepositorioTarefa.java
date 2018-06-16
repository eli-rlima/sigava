package br.ufrpe.sigava.repositorios;
import br.ufrpe.sigava.classes.Tarefa;
import java.util.ArrayList;


public class RepositorioTarefa {

    private ArrayList <Tarefa> repositorioTarefas = new ArrayList<Tarefa>();


    public boolean adicionar(Tarefa tarefa){
        return this.repositorioTarefas.add(tarefa);
    }
    public boolean remover(Tarefa tarefa){
        return this.repositorioTarefas.remove(tarefa);
    }
    public Tarefa buscar(int codigo){
        Tarefa tarefa = null;
        for (int i = 0; i < this.repositorioTarefas.size(); i++){
            if (this.repositorioTarefas.get(i).getCodigoTarefa() == codigo){
                tarefa = this.repositorioTarefas.get(i);
            }
        }
        return tarefa;
    }
    public boolean existe(Tarefa tarefa){
        return this.repositorioTarefas.contains(tarefa);
    }
}

