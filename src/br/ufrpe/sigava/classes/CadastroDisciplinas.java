package br.ufrpe.sigava.classes;

import br.ufrpe.sigava.pessoa.Aluno;
import br.ufrpe.sigava.pessoa.Professor;
import br.ufrpe.sigava.repositorios.IRepositorioDisciplina;

public class CadastroDisciplinas {
    private IRepositorioDisciplina repositorioDisciplina;

    public CadastroDisciplinas(IRepositorioDisciplina instanciaRepositorio){
        this.repositorioDisciplina = instanciaRepositorio;
    }

    public boolean cadastrar(Disciplina disciplina){
        boolean retorno = false;
        if (disciplina == null){
            retorno = false;
        }
        if (!this.repositorioDisciplina.existe(disciplina)) {
            this.repositorioDisciplina.adicionar(disciplina);
            retorno = true;
        }
        else{
            retorno = false;
        }
        return retorno;
    }

    public boolean descadastrar(Disciplina disciplina){
        boolean retorno = false;
        if(disciplina != null){
            this.repositorioDisciplina.remover(disciplina);
            retorno = true;
        }
        return retorno;
    }

    public Disciplina procurar(String nome){
        Disciplina disciplina = null;
        if(nome != null){
            disciplina = this.repositorioDisciplina.buscar(nome);
        }
        return disciplina;
    }

    public boolean existe(Disciplina disciplina){
        return this.repositorioDisciplina.existe(disciplina);
    }

    public boolean cadastrarProfessor(String nome, Professor professor){
        boolean retorno = false;
        Disciplina disciplina = null;
        if (nome != null){
            disciplina = this.repositorioDisciplina.buscar(nome);
        }
        if (disciplina != null && professor != null){
            disciplina.adicionarProfessor(professor);
            retorno = true;
        }
        return retorno;
    }

    public boolean cadastrarAluno(String nome, Aluno aluno){
        boolean retorno = false;
        Disciplina disciplina = null;
        if (nome != null){
            disciplina = this.repositorioDisciplina.buscar(nome);
        }
        if (disciplina != null && aluno != null){
            disciplina.adicionarAluno(aluno);
            retorno = true;
        }
        return retorno;
    }

    public boolean cadastrarTarefa(String nome, Tarefa tarefa){
        boolean retorno = false;
        Disciplina disciplina = null;
        if (nome != null){
            disciplina = this.repositorioDisciplina.buscar(nome);
        }
        if (disciplina != null && tarefa != null){
            disciplina.adicionarTarefa(tarefa);
            retorno = true;
        }
        return retorno;
    }
}
