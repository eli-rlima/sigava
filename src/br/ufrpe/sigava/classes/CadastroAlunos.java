package br.ufrpe.sigava.classes;

import br.ufrpe.sigava.pessoa.Aluno;
import br.ufrpe.sigava.repositorios.IRepositorioAluno;

import java.time.LocalDate;

public class CadastroAlunos {
    private IRepositorioAluno repositorioAluno;

    public CadastroAlunos(IRepositorioAluno instanciaRepositorio){
        this.repositorioAluno = instanciaRepositorio;
    }

    public boolean cadastrar(Aluno aluno){
        boolean retorno = false;
        if(aluno == null){
            retorno = false;
        }
        else if(!repositorioAluno.existe(aluno)){
            retorno = this.repositorioAluno.adicionar(aluno);
        }
        return retorno;
    }

    public boolean cadastrar (String nome, String email, char sexo, LocalDate dataNascimento, String senha, String cpf){
        boolean retorno = false;
        if(nome != null){
            if(email != null){
                if(sexo == 'm' || sexo == 'f'){
                    if(dataNascimento != null){
                        if(senha != null){
                            if(cpf != null){
                                Aluno aluno = repositorioAluno.buscar(cpf);
                                if(aluno == null){
                                    retorno = repositorioAluno.adicionar(nome, email, sexo, dataNascimento, senha, cpf);
                                }
                            }
                        }
                    }
                }
            }
        }
        return retorno;
    }

    public boolean descadastrar(Aluno aluno){
        boolean retorno = false;
         if(aluno != null && repositorioAluno.existe(aluno)){
            retorno = repositorioAluno.remover(aluno);
        }
        return retorno;
    }

    public Aluno procurar (String cpf){
        Aluno aluno = null;
        if(cpf != null){
            aluno = repositorioAluno.buscar(cpf);
        }
        return aluno;
    }

    public boolean existe(Aluno aluno){
        boolean retorno = false;
        if(aluno != null){
            retorno = repositorioAluno.existe(aluno);
        }
        return retorno;
    }

    public boolean adicionarMarcacao(String nomeDisciplina, String nomeCronograma, Aluno aluno, int codigoTarefa, LocalDate dataTermino){
        boolean retorno = false;
        Marcacao marcacao = null;
        Tarefa tarefa = null;

        if(nomeCronograma != null){
            if(repositorioAluno.existe(aluno) &&  repositorioAluno.existeCronograma(aluno,nomeCronograma)){
                if (codigoTarefa >= 0 && aluno.buscarDisciplina(nomeDisciplina) != null && aluno.buscarDisciplina(nomeDisciplina).buscarTarefa(codigoTarefa) != null) {
                    tarefa = aluno.buscarDisciplina(nomeDisciplina).buscarTarefa(codigoTarefa);
                    if (tarefa.getDataTermino().isEqual(dataTermino) || tarefa.getDataTermino().isBefore(dataTermino)){
                        marcacao.setCodigoTarefa(tarefa.getCodigoTarefa());
                        marcacao.setDataTermino(dataTermino);
                        retorno = repositorioAluno.adicionarMarcacao(nomeCronograma, aluno, codigoTarefa, dataTermino);
                    }
                }
            }
        }
        return retorno;
    }
}
