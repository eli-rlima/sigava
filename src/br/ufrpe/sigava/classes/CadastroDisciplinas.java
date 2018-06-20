package br.ufrpe.sigava.classes;

import br.ufrpe.sigava.pessoa.Aluno;
import br.ufrpe.sigava.pessoa.Professor;
import br.ufrpe.sigava.repositorios.RepositorioDisciplina;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class CadastroDisciplinas {
    private RepositorioDisciplina repositorioDisciplina;

    public CadastroDisciplinas(){
        this.repositorioDisciplina = RepositorioDisciplina.getInstance();
    }

    public boolean cadastrar(Disciplina disciplina){
        boolean retorno = false;
        if (disciplina == null){
            retorno = false;
        }
        else if (!this.repositorioDisciplina.existe(disciplina)) {
            this.repositorioDisciplina.adicionar(disciplina);
            retorno = true;
        }
        return retorno;
    }

    public boolean cadastrar(String nome, LocalDate dataInicio, DayOfWeek diaAula, int duracaoAula, int cargaHoraria){
        boolean retorno = false;
        if (nome != null){
            if (dataInicio != null){
                if (diaAula != null){
                    if (duracaoAula > 0){
                        if (cargaHoraria > 0){
                            retorno = this.repositorioDisciplina.adicionar(nome, dataInicio, diaAula, duracaoAula,
                                    cargaHoraria);
                        }
                    }
                }
            }
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
        boolean retorno = false;
        if (disciplina != null){
            retorno = this.repositorioDisciplina.existe(disciplina);
        }
        return retorno;
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
