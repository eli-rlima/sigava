package br.ufrpe.sigava.classes;

import br.ufrpe.sigava.repositorios.IRepositorioTarefa;

import java.time.LocalDate;

public class CadastroTarefa {
    private IRepositorioTarefa repositorioTarefa;

    public CadastroTarefa(IRepositorioTarefa instanciaRepositorio){
        this.repositorioTarefa = instanciaRepositorio;
    }

    public boolean cadastrar(Tarefa tarefa){
        boolean retorno = false;
        if (tarefa == null){
            retorno = false;
        }
        if (!this.repositorioTarefa.existe(tarefa)) {
            this.repositorioTarefa.adicionar(tarefa);
            retorno = true;
        }
        else{
            retorno = false;
        }
        return retorno;
    }

    public boolean cadastrar(String descricao, LocalDate dataInicio, LocalDate dataTermino, int codigoTarefa){
        boolean retorno = false;
        if (descricao != null){
            if (dataInicio != null){
                if (dataTermino != null){
                    if (codigoTarefa >= 0){
                        retorno = this.repositorioTarefa.adicionar(descricao, dataInicio, dataTermino, codigoTarefa);
                    }
                }
            }
        }
        return retorno;
    }

    public boolean descadastrar(Tarefa tarefa){
        boolean retorno = false;
        if(tarefa != null){
            this.repositorioTarefa.remover(tarefa);
            retorno = true;
        }
        return retorno;
    }

    public Tarefa procurar(int codigo){
        Tarefa tarefa = null;
        if(codigo >= 0){
            tarefa = this.repositorioTarefa.buscar(codigo);
        }
        return tarefa;
    }

    public boolean existe(Tarefa tarefa){
        boolean retorno = false;
        if (tarefa != null){
            retorno = this.repositorioTarefa.existe(tarefa);
        }
        return retorno;
    }

}
